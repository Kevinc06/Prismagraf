/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

import Model.Produto;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManipulaProduto {
    
    
     public void cadastrarProd(Produto p) throws SQLException {

        
        Connection c = controller.ConexaoBanco.getConexao();
       
        Statement stat = c.createStatement();

        try {

            String sql;
            sql = "insert into produto(codprod,nomeprod,quantidade,valordevenda) values ("+
                     p.getCodProd()+ ",'" + p.getNomeProd()+ "'," + 
                    p.getQuantidade()+ ",'"+ p.getValorDeVenda()+ "')"  ;
            
            stat.execute(sql);

        }catch(SQLException e) { 
            throw new SQLException("ERRO AO CADASTRAR: \n" + e);
        } finally { 
            c.close();
            stat.close();

        } //fecha finally 

        
        
        
    }
     
    public ArrayList<Produto> buscarProd() throws SQLException{
        Connection c = controller.ConexaoBanco.getConexao();
        Statement stat = c.createStatement();
        try{
            String sql;
            sql = "select * from produto";
            
           
            ArrayList<Produto> alP = new ArrayList();
            ResultSet rs = stat.executeQuery(sql);
           
            
            while(rs.next()){
                Produto p = new Produto();
                p.setCodProd(rs.getInt("codprod"));
                p.setNomeProd(rs.getString("nomeprod"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setValorDeVenda(rs.getString("valordevenda"));
               alP.add(p);
                      
            }
            return alP;
        }catch (SQLException e){
            throw new SQLException("Erro ao buscar: \n" +e);
        }finally{
            c.close();
            stat.close();
        }
    }//fecha o buscar 
    
    
    
    
    
    
    
    
    
    
    
    public void excluir(int codProd) throws SQLException{
       Connection c = controller.ConexaoBanco.getConexao();
        Statement stat = c.createStatement();
        try{
            String sql;
            sql = "delete from produto where codProd="+codProd;
            stat.execute(sql);
        }catch(SQLException e){
            throw new SQLException("Erro ao excluir: \n" +e);
    }finally{
            c.close();
            stat.close();
        }
    
    }//Fecha o excluir
      
     public void alterarProd(Produto p)throws SQLException{
        Connection c = controller.ConexaoBanco.getConexao();
        Statement stat = c.createStatement();
        try{
            String sql;
            sql = "update produto set nomeprod ='"+p.getNomeProd()+"' " 
                    + "where codprod="+p.getCodProd();
               stat.execute(sql);
               
        }catch(SQLException e){
            throw new SQLException("Erro ao alterar:\n" +e);
        }finally{
            c.close();
            stat.close();
        }
    }//Fecha o alterar
    
      public ArrayList<Produto> filtrarProdutos(String query)throws SQLException{
           Connection c = controller.ConexaoBanco.getConexao();
           Statement stat = c.createStatement();
           
           try{
            String sql;
            sql = "select * from produto "+query;
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Produto> alP = new ArrayList();
 
            while(rs.next()){
                Produto p = new Produto();
                p.setCodProd(rs.getInt("codprod"));
                p.setNomeProd(rs.getString("nomeprod"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setValorDeVenda(rs.getString("valordevenda"));
                alP.add(p);
                      
            }
            return alP;
           }catch(SQLException e){
           throw new SQLException("Erro ao filtrar pesquisa \n" +e);
           }finally{
               c.close();
               stat.close();
           }
    }

}//Fecha o método manipular

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//Fecha a CLASSE
