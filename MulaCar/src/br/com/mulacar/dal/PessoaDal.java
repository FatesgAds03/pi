/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.dal;

import br.com.mulacar.model.ClientePessoaFisica;
import br.com.mulacar.model.ClientePessoaJuridica;
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
public class PessoaDal {

    private Connection conexao;

    public PessoaDal() {
        conexao = Conexao.getConexao();
    }

    public void addPessoa(ClientePessoaFisica obj) {
        String sql = "insert into pessoa (pes_nome,pes_tel, pes_email, pes_login, pes_senha, pes_cpf, pes_identidade, pes_val_cnh,pes_cat_cnh, pes_num_cnh,pes_foto_iden,pes_perfil_iden) values (?,?,?,?,?,?,?,?,?,?,?,?,? )";
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement(sql);
            // Parameters start with 1
            preparedStatement.setString(1, obj.getNome());
            preparedStatement.setLong(2, obj.getTelefone());
            preparedStatement.setString(3, obj.getEmail());
            preparedStatement.setString(4, obj.getLogin());
            preparedStatement.setString(5, obj.getSenha());
            preparedStatement.setLong(6, obj.getCpf());
            preparedStatement.setLong(7, obj.getIdentidade());
            preparedStatement.setDate(8, obj.getDt_validade_cnh());
            preparedStatement.setString(9, obj.getCat_cnh());
            preparedStatement.setLong(10, obj.getCnh());
            preparedStatement.setInt(11, obj.getFoto_iden());
            preparedStatement.setString(12, obj.getPerfil());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPessoa(ClientePessoaJuridica obj) {
        String sql = "insert into pessoa (pes_nome,pes_tel, pes_email, pes_login, pes_senha,pes_perfil_iden, pes_cnpj, pes_rezao_soc, pes_foto_iden) values (? )";
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement(sql);
            // Parameters start with 1
            preparedStatement.setString(1, obj.getNome());
            preparedStatement.setLong(2, obj.getTelefone());
            preparedStatement.setString(3, obj.getEmail());
            preparedStatement.setString(4, obj.getLogin());
            preparedStatement.setString(5, obj.getSenha());
            preparedStatement.setString(6, obj.getPerfil());
            preparedStatement.setLong(7, obj.getCnpj());
            preparedStatement.setString(8, obj.getRazaoSocial());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePessoa(int pessoaId) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("delete from pessoa where pes_iden=?");
            // Parameters start with 1
            preparedStatement.setInt(1, pessoaId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePessoa(ClientePessoaFisica obj) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("update pessoa set  pes_nome=?, pes_tel=?, pes_email=?, pes_login=?, pes_senha=?, pes_cpf=?, pes_identidade=?, pes_val_cnh=?, pes_cat_cnh=?, pes_num_cnh=?,pes_foto_iden=?,pes_perfil_iden=? where pes_iden = ?");
            // Parameters start with 1
            preparedStatement.setString(1, obj.getNome());
            preparedStatement.setLong(2, obj.getTelefone());
            preparedStatement.setString(3, obj.getEmail());
            preparedStatement.setString(4, obj.getLogin());
            preparedStatement.setString(5, obj.getSenha());
            preparedStatement.setLong(6, obj.getCpf());
            preparedStatement.setLong(7, obj.getIdentidade());
            preparedStatement.setDate(8, obj.getDt_validade_cnh());
            preparedStatement.setString(9, obj.getCat_cnh());
            preparedStatement.setLong(10, obj.getCnh());
            preparedStatement.setInt(11, obj.getFoto_iden());
            preparedStatement.setString(12, obj.getPerfil());
            preparedStatement.setInt(13, obj.getIden());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePessoa(ClientePessoaJuridica obj) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("update pessoa set pes_nome=?, pes_tel=?, pes_email=?, pes_login=?, pes_senha=?, pes_cnpj=?, pes_razao_soc=?, pes_perfil_iden=?  where pes_iden = ?");
            // Parameters start with 1
            preparedStatement.setString(1, obj.getNome());
            preparedStatement.setLong(2, obj.getTelefone());
            preparedStatement.setLong(3, obj.getTelefone());
            preparedStatement.setString(4, obj.getEmail());
            preparedStatement.setString(5, obj.getLogin());
            preparedStatement.setString(6, obj.getSenha());
            preparedStatement.setLong(7, obj.getCnpj());
            preparedStatement.setString(8, obj.getRazaoSocial());
            preparedStatement.setString(9, obj.getPerfil());
            preparedStatement.setInt(10, obj.getIden());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ClientePessoaFisica> getAllPessoaFisica() {
        List<ClientePessoaFisica> pessoas = new ArrayList<>();
        String sql = "select * from pessoa";
        System.out.println(sql);
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ClientePessoaFisica pessoa = new ClientePessoaFisica();
                pessoa.setIden(rs.getInt("pes_iden"));
                pessoa.setNome(rs.getString("pes_nome"));
                pessoa.setTelefone(rs.getLong("pes_tel"));
                pessoa.setEmail(rs.getString("pes_email"));
                pessoa.setLogin(rs.getString("pes_login"));
                pessoa.setSenha(rs.getString("pes_senha"));
                pessoa.setCpf(rs.getInt("pes_cpf"));
                pessoa.setIdentidade(rs.getInt("pes_identidade"));
                pessoa.setDt_validade_cnh(rs.getDate("pes_val_cnh"));
                pessoa.setCat_cnh(rs.getString("pes_cat_cnh"));
                pessoa.setCnh(rs.getInt("pes_num_cnh"));

                pessoas.add(pessoa);
                System.out.println(pessoa.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoas;
    }

    public ClientePessoaFisica getPessoaById(int PessoaFisicaId) {
        ClientePessoaFisica pessoa = new ClientePessoaFisica();
        try {
            PreparedStatement preparedStatement = conexao.
            prepareStatement("select * from pessoa where pes_iden=?");
            preparedStatement.setInt(1, PessoaFisicaId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                pessoa.setIden(rs.getInt("pes_iden"));
                pessoa.setNome(rs.getString("pes_nome"));
                pessoa.setTelefone(rs.getLong("pes_tel"));
                pessoa.setEmail(rs.getString("pes_email"));
                pessoa.setLogin(rs.getString("pes_login"));
                pessoa.setSenha(rs.getString("pes_senha"));
                pessoa.setCpf(rs.getInt("pes_cpf"));
                pessoa.setIdentidade(rs.getInt("pes_identidade"));
                pessoa.setDt_validade_cnh(rs.getDate("pes_val_cnh"));
                pessoa.setCat_cnh(rs.getString("pes_cat_cnh"));
                pessoa.setCnh(rs.getInt("pes_num_cnh"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoa;
    }

    public ClientePessoaFisica getPessoaByName(String pessoaNome) {
        ClientePessoaFisica pessoa = new ClientePessoaFisica();
        try {
            PreparedStatement preparedStatement = conexao.
            prepareStatement("select * from pessoa where pes_nome=?");
            preparedStatement.setString(1, pessoaNome);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                pessoa.setIden(rs.getInt("pes_iden"));
                pessoa.setNome(rs.getString("pes_nome"));
                pessoa.setTelefone(rs.getLong("pes_tel"));
                pessoa.setEmail(rs.getString("pes_email"));
                pessoa.setLogin(rs.getString("pes_login"));
                pessoa.setSenha(rs.getString("pes_senha"));
                pessoa.setCpf(rs.getInt("pes_cpf"));
                pessoa.setIdentidade(rs.getInt("pes_identidade"));
                pessoa.setDt_validade_cnh(rs.getDate("pes_val_cnh"));
                pessoa.setCat_cnh(rs.getString("pes_cat_cnh"));
                pessoa.setCnh(rs.getInt("pes_num_cnh"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoa;
    }
}
