/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.dal;

import br.com.mulacar.model.Modelo;
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
public class ModeloDal {

    private Connection conexao;
    MarcaDal marca = new MarcaDal();
    
    public ModeloDal() {
        conexao = Conexao.getConexao();
    }

    public void addModelo(Modelo modelo) {
        String sql = "insert into modelo(mod_iden,mod_nome,mod_Marca_iden) values (?,?,?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setInt(1, modelo.getModelo_iden());
            preparedStatement.setString(2, modelo.getNome());
            preparedStatement.setInt(3, modelo.getMarca().getMarca_iden());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteModelo(int modeloId) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("delete from modelo where modeloid");
            preparedStatement.setInt(1, modeloId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateModelo(Modelo modelo) {
        try {

            PreparedStatement preparedStatement = conexao.prepareStatement("update modelo set mod_iden = ? "
                    + "where mod_nome = ? where mod_Marca_iden = ?");
            preparedStatement.setInt(1, modelo.getModelo_iden());
            preparedStatement.setString(2, modelo.getNome());
            preparedStatement.setInt(3, modelo.getModelo_iden());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Modelo> getAllModelo() {
        List<Modelo> modelos = new ArrayList<Modelo>();
        
        String sql = "select * from modelo";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Modelo modelo = new Modelo();
                modelo.setModelo_iden(rs.getInt("mod_iden"));
                modelo.setNome(rs.getString("mod_nome"));
                modelo.setMarca(marca.getMarcaById(rs.getInt("mod_Marca_iden")));
                modelos.add(modelo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelos;
    }

    public Modelo getModeloById(int modeloId) {
        Modelo modelo = new Modelo();
        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from modelo where mod_iden=?");
            preparedStatement.setInt(1, modeloId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                modelo.setModelo_iden(rs.getInt("mod_iden"));
                modelo.setNome(rs.getString("mod_nome"));
                modelo.setMarca(marca.getMarcaById(rs.getInt("mod_Marca_iden")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelo;
    }
    
    public Modelo getModeloByName(String modeloNome) {
        Modelo modelo = new Modelo();
        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from modelo where mod_nome=?");
            preparedStatement.setString(1, modeloNome);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()){
                modelo.setModelo_iden(rs.getInt("mod_iden"));
                modelo.setNome(rs.getString("mod_nome"));
                modelo.setMarca(marca.getMarcaById(rs.getInt("mod_Marca_iden")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelo;
    }
}
