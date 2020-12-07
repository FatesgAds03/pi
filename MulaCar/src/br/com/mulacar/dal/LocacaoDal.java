/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.dal;

import br.com.mulacar.model.Locacao;
import br.com.mulacar.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jsfr
 */
public class LocacaoDal {
    private Connection conexao;
    VeiculoDal veiculo = new VeiculoDal();


    public LocacaoDal() {
        conexao = Conexao.getConexao();
    }

    public void addLocacao(Locacao locacao) {
        String sql = "insert into locacao(loc_iden,loc_cliente_iden,loc_motorista_iden,loc_dt_ret, loc_dt_dev, loc_km_ini, loc_km_fim "
                + "loc_valor, loc_tnq_cheio, loc_dt_dev_prevista,loc_vei_placa ) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement(sql);
            // Parameters start with 1
            preparedStatement.setInt(1, locacao.getIden());
            preparedStatement.setInt(2, locacao.getLocatario().getIden());
            preparedStatement.setInt(3, locacao.getMotorista().getIden());
            preparedStatement.setDate(4, locacao.getDataRetirada());
            preparedStatement.setDate(5, locacao.getDataDevolucao());
            preparedStatement.setInt(6, locacao.getKilometragenInicial());
            preparedStatement.setInt(7, locacao.getKilometragemFinal());
            preparedStatement.setDouble(8, locacao.calcularValorLocacao());
            preparedStatement.setBoolean(9, locacao.getTanqueCheio());
            preparedStatement.setDate(10, locacao.getDataDevolucaoPrevista());
            preparedStatement.setString(11, locacao.getVeiculo().getPlaca_veiculo());
            
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLocacao(int locacaoId) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("delete from locacaos where locacaoid=?");
            // Parameters start with 1
            preparedStatement.setInt(1, locacaoId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLocacao(Locacao locacao) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("update locacao set loc_cliente_iden=?,loc_motorista_iden=?,loc_dt_ret=?, loc_dt_dev=?, loc_km_ini=?, loc_km_fim=? "
                + "loc_valor=?, loc_tnq_cheio=?, loc_dt_dev_prevista=? where loc_vei_placa=?");
            // Parameters start with 1
            preparedStatement.setInt(1, locacao.getIden());
            preparedStatement.setInt(2, locacao.getLocatario().getIden());
            preparedStatement.setInt(3, locacao.getMotorista().getIden());
            preparedStatement.setDate(4, locacao.getDataRetirada());
            preparedStatement.setDate(5, locacao.getDataDevolucao());
            preparedStatement.setInt(6, locacao.getKilometragenInicial());
            preparedStatement.setInt(7, locacao.getKilometragemFinal());
            preparedStatement.setDouble(8, locacao.calcularValorLocacao());
            preparedStatement.setBoolean(9, locacao.getTanqueCheio());
            preparedStatement.setDate(10, locacao.getDataDevolucaoPrevista());
            preparedStatement.setString(11, locacao.getVeiculo().getPlaca_veiculo());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Locacao> getAllLocacoes() {
        List<Locacao> locacoes = new ArrayList<Locacao>();
        PessoaDal locatario = new PessoaDal();
        PessoaDal motorista = new PessoaDal();
        String sql = "select * from locacao";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Locacao locacao = new Locacao();
                locacao.setIden(rs.getInt("loc_iden"));
                locacao.setVeiculo(veiculo.getVeiculoByPlaca(rs.getInt("loc_vei_placa")));
                locacao.setLocatario(locatario.getPessoaById(rs.getInt("loc_cliente_iden")));
                locacao.setMotorista(motorista.getPessoaById(rs.getInt("loc_motorista_iden")));
                locacao.setDataRetirada(rs.getDate("loc_dt_ret"));
                locacao.setDataDevolucaoPrevista(rs.getDate("loc_dt_dev_prevista"));
                locacao.setDataDevolucao(rs.getDate("loc_dt_dev"));
                locacao.setKilometragenInicial(rs.getInt("loc_km_ini"));
                locacao.setKilometragemFinal(rs.getInt("loc_km_fim"));
                locacao.setTanqueCheio(rs.getBoolean("loc_tnq_cheio"));
                locacoes.add(locacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locacoes;
    }

    public Locacao getLocacaoById(int locacaoId) {
        Locacao locacao = new Locacao();
        PessoaDal locatario = new PessoaDal();
        PessoaDal motorista = new PessoaDal();
        try {
            PreparedStatement preparedStatement = conexao.
            prepareStatement("select * from locacao where loc_id=?");
            preparedStatement.setInt(1, locacaoId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                locacao.setVeiculo(veiculo.getVeiculoByPlaca(rs.getInt("loc_vei_placa")));
                locacao.setLocatario(locatario.getPessoaById(rs.getInt("loc_cliente_iden")));
                locacao.setMotorista(motorista.getPessoaById(rs.getInt("loc_motorista_iden")));
                locacao.setDataRetirada(rs.getDate("loc_dt_ret"));
                locacao.setDataDevolucaoPrevista(rs.getDate("loc_dt_dev_prevista"));
                locacao.setDataDevolucao(rs.getDate("loc_dt_dev"));
                locacao.setKilometragenInicial(rs.getInt("loc_km_ini"));
                locacao.setKilometragemFinal(rs.getInt("loc_km_fim"));
                locacao.setTanqueCheio(rs.getBoolean("loc_tnq_cheio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locacao;
    }
}
