/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Renan
 */
public class ConexaoBanco {
    
    private static final String URL = "jdbc:mysql://localhost:3306/bancoprismagraf";
    //---------------------------------------------------------------------//
    // QUALQUER ERRO DE CONEXÃO COM O BANCO ALTERE O USUARIO OU A SENHA //
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    // QUALQUER ERRO DE CONEXÃO COM O BANCO ALTERE O USUARIO OU A SENHA //
    //---------------------------------------------------------------------//
    
    
    
    
    
    
     public static Connection getConexao() throws SQLException{
    Connection c = null;
    try{
       
        c=(Connection)DriverManager.getConnection(
        URL, USUARIO, SENHA);
    }catch(SQLException e){
        throw new SQLException(""+e);
    
}
    return c;
}
}
    
    
    
    
    
    
    
    
    
    

