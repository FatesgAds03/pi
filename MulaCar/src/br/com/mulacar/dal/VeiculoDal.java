/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.dal;

/**
 *
 * @author deockar
 */
import br.com.mulacar.model.Veiculo;
import br.com.mulacar.util.CategoriaEnum;
import br.com.mulacar.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDal {

    private Connection conexao;
    ModeloDal modelo = new ModeloDal();
    MarcaDal marca = new MarcaDal();
    FotoDal foto = new FotoDal();

    public VeiculoDal() {
        conexao = Conexao.getConexao();
    }

    public void addVeiculo(Veiculo veiculo) {
        String sql = "insert into veiculo(vei_placa,vei_ren,vei_cat,vei_preco_com,vei_preco_ven,vei_nro_pas,vei_ano_fab,vei_ano_mod,vei_tip_comb,"
                + "vei_tip,vei_sit,vei_km,vei_Foto_iden,vei_Modelo_iden) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, veiculo.getPlaca_veiculo());
            preparedStatement.setInt(2, veiculo.getRenavam());
            preparedStatement.setString(3, veiculo.getCategoria().toString());
            preparedStatement.setDouble(4, veiculo.getPreco_compra());
            preparedStatement.setDouble(5, veiculo.getPreco_venda());
            preparedStatement.setInt(6, veiculo.getNumero_passageiro());
            preparedStatement.setInt(7, veiculo.getAno_fabricacao());
            preparedStatement.setInt(8, veiculo.getAno_modelo());
            preparedStatement.setString(9, veiculo.getTipo_combustivel());
            preparedStatement.setString(10, veiculo.getTipo());
            preparedStatement.setString(11, veiculo.getSituacao());
            preparedStatement.setInt(12, veiculo.getQuilometragem());
            preparedStatement.setInt(13, veiculo.getModelo_iden());
            preparedStatement.setInt(15, veiculo.getFoto_iden());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVeiculo(String veiculo_Placa) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("delete from veiculo where vei_placa=?");
            preparedStatement.setString(1, veiculo_Placa);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateVeiculo(Veiculo veiculo) {
        String sql = "insert into veiculo(vei_placa,vei_ren,vei_cat,vei_preco_com,vei_preco_ven,vei_nro_pas,vei_ano_fab,vei_ano_mod,vei_tip_comb,"
                + "vei_tip,vei_sit,vei_km,vei_Foto_iden,vei_Modelo_iden) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, veiculo.getPlaca_veiculo());
            preparedStatement.setInt(2, veiculo.getRenavam());
            preparedStatement.setString(3, veiculo.getCategoria().toString());
            preparedStatement.setDouble(4, veiculo.getPreco_compra());
            preparedStatement.setDouble(5, veiculo.getPreco_venda());
            preparedStatement.setInt(6, veiculo.getNumero_passageiro());
            preparedStatement.setInt(7, veiculo.getAno_fabricacao());
            preparedStatement.setInt(8, veiculo.getAno_modelo());
            preparedStatement.setString(9, veiculo.getTipo_combustivel());
            preparedStatement.setString(10, veiculo.getTipo());
            preparedStatement.setString(11, veiculo.getSituacao());
            preparedStatement.setInt(12, veiculo.getQuilometragem());
            preparedStatement.setInt(13, veiculo.getModelo_iden());
            preparedStatement.setInt(15, veiculo.getFoto_iden());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Veiculo> getAllVeiculo() {
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        String sql = "select * from veiculo";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();

                veiculo.setPlaca_veiculo(rs.getString("vei_placa"));
                veiculo.setRenavam(rs.getInt("vei_ren"));
                veiculo.setCategoria(CategoriaEnum.valueOf("vei_cat"));
                veiculo.setPreco_compra(rs.getFloat("vei_preco_com"));
                veiculo.setPreco_venda(rs.getFloat("vei_preco_ven"));
                veiculo.setNumero_passageiro(rs.getInt("vei_nro_pas"));
                veiculo.setAno_fabricacao(rs.getInt("vei_ano_fab"));
                veiculo.setAno_modelo(rs.getInt("vei_ano_mod"));
                veiculo.setTipo_combustivel(rs.getString("vei_tip_comb"));
                veiculo.setTipo(rs.getString("vei_tip"));
                veiculo.setSituacao(rs.getString("vei_sit"));
                veiculo.setQuilometragem(rs.getInt("vei_km"));
                veiculo.setFoto_iden(rs.getInt("vei_Foto_iden"));
                veiculo.setModelo_iden(rs.getInt("vei_Modelo_iden"));

                veiculos.add(veiculo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculos;
    }
    
    public List<Veiculo> getAllVeiculoDisponiveis() {
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        String sql = "select * from veiculo where vei_sit='disponivel' ";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();

                veiculo.setPlaca_veiculo(rs.getString("vei_placa"));
                veiculo.setRenavam(rs.getInt("vei_ren"));
                veiculo.setCategoria(CategoriaEnum.valueOf("vei_cat"));
                veiculo.setPreco_compra(rs.getFloat("vei_preco_com"));
                veiculo.setPreco_venda(rs.getFloat("vei_preco_ven"));
                veiculo.setNumero_passageiro(rs.getInt("vei_nro_pas"));
                veiculo.setAno_fabricacao(rs.getInt("vei_ano_fab"));
                veiculo.setAno_modelo(rs.getInt("vei_ano_mod"));
                veiculo.setTipo_combustivel(rs.getString("vei_tip_comb"));
                veiculo.setTipo(rs.getString("vei_tip"));
                veiculo.setSituacao(rs.getString("vei_sit"));
                veiculo.setQuilometragem(rs.getInt("vei_km"));
                veiculo.setFoto_iden(rs.getInt("vei_Foto_iden"));
                veiculo.setModelo_iden(rs.getInt("vei_Modelo_iden"));

                veiculos.add(veiculo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculos;
    }

    public Veiculo getVeiculoByPlaca(int veiculoId) {
        Veiculo veiculo = new Veiculo();
        try {

            PreparedStatement preparedStatement = conexao.prepareStatement("select * from veiculo where vei_placa");
            preparedStatement.setInt(1, veiculoId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                veiculo.setPlaca_veiculo(rs.getString("vei_placa"));
                veiculo.setRenavam(rs.getInt("vei_ren"));
                veiculo.setCategoria((CategoriaEnum)rs.getObject("vei_cat"));
                veiculo.setPreco_compra(rs.getFloat("vei_preco_com"));
                veiculo.setPreco_venda(rs.getFloat("vei_preco_ven"));
                veiculo.setNumero_passageiro(rs.getInt("vei_nro_pas"));
                veiculo.setAno_fabricacao(rs.getInt("vei_ano_fab"));
                veiculo.setAno_modelo(rs.getInt("vei_ano_mod"));
                veiculo.setTipo_combustivel(rs.getString("vei_tip_comb"));
                veiculo.setTipo(rs.getString("vei_tip"));
                veiculo.setSituacao(rs.getString("vei_sit"));
                veiculo.setQuilometragem(rs.getInt("vei_km"));
                veiculo.setFoto_iden(rs.getInt("vei_Foto_iden"));
                veiculo.setModelo_iden(rs.getInt("vei_Modelo_iden"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return veiculo;
    }

}
