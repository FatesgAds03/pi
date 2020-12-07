/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jsfr
 */
public class Conexao {
    private static Connection conexao = null;

    public static Connection getConexao() {
        try {
                if (conexao==null){
                    String driver = "org.postgresql.Driver";
                    String url = "jdbc:postgresql://192.168.0.205:5432/db_mulacar";
                    String user = "postgres";
                    String password = "vin";

                    Class.forName(driver);
                    conexao = DriverManager.getConnection(url, user, password);
                } return conexao;    
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conexao;

    }
}
