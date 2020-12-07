/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.dal;

import br.com.mulacar.model.Marca;
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
 * @author deockar
 */
public class MarcaDal {
    
    private Connection conexao;

    public MarcaDal() {
        conexao = Conexao.getConexao();
    }

    public void addMarca(Marca marca) {
        String sql = "insert into marca(mar_iden,mar_nome) values (?,?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setInt(1, marca.getMarca_iden());
            preparedStatement.setString(2, marca.getNome());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMarca(int marcaId) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("delete from marca where marcaid");
            preparedStatement.setInt(1, marcaId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMarca(Marca marca) {
        try {

            PreparedStatement preparedStatement = conexao.prepareStatement("update marca set mar_iden = ? "
                    + "where mar_nome = ? ");
            preparedStatement.setInt(1, marca.getMarca_iden());
            preparedStatement.setString(2, marca.getNome());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Marca> getAllMarca() {
        List<Marca> marcas = new ArrayList<Marca>();
        String sql = "select * from marca";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Marca marca = new Marca();
                marca.setMarca_iden(rs.getInt("mar_iden"));
                marca.setNome(rs.getString("mar_nome"));
                marcas.add(marca);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marcas;
    }

    public Marca getMarcaById(int marcaId) {
        Marca marca = new Marca();
        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from marca where mar_iden=?");
            preparedStatement.setInt(1, marcaId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                marca.setMarca_iden(rs.getInt("mar_iden"));
                marca.setNome(rs.getString("mar_nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marca;
    }
    
    public Marca getMarcaByName(String marcaNome) {
        Marca marca = new Marca();
        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from marca where mar_nome=?");
            preparedStatement.setString(1, marcaNome);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()){
                marca.setMarca_iden(rs.getInt("mar_iden"));
                marca.setNome(rs.getString("mar_nome"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marca;
    }
}
