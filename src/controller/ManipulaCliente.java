
package Controller;

import Model.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ManipulaCliente {

    
    
    
    
    
       public void cadastrarCli(Cliente cli) throws SQLException {

        
        Connection c = controller.ConexaoBanco.getConexao();
       
        Statement stat = c.createStatement();

        try {

            String sql;
            sql = "insert into cliente (codcli,nomecli,email,idade,telefone, codprod) values ("
                    + cli.getCodCli()+ ",'" + cli.getNomeCli()+ "','" + 
                    cli.getEmail()+ "',"+ cli.getIdade()+ ",'"+ cli.getTelefone()+ "',"+
                    cli.getCodProdCom()+")";
            
            stat.execute(sql);

        } catch (SQLException e) { 
            throw new SQLException("ERRO AO CADASTRAR: \n" + e);
        } finally { 
            c.close();
            stat.close();

        } //fecha finally 
  
    }
       
       public ArrayList<Cliente> buscarCli() throws SQLException{
        Connection c = controller.ConexaoBanco.getConexao();
        Statement stat = c.createStatement();
        try{
            String sql;
            sql = "select * from cliente";
            
           
            
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Cliente> alC = new ArrayList();
           
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setCodCli(rs.getInt("codcli"));
                cli.setNomeCli(rs.getString("nomecli"));
                cli.setEmail(rs.getString("email"));
                cli.setIdade(rs.getInt("idade"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setCodProdCom(rs.getInt("codprod"));
                alC.add(cli);
                      
            }
            return alC;
        }catch (SQLException e){
            throw new SQLException("Erro ao buscar: \n" +e);
        }finally{
            c.close();
            stat.close();
        }
    }//fecha o buscar 
       
        public void excluir(int codCli) throws SQLException{
       Connection c = controller.ConexaoBanco.getConexao();
        Statement stat = c.createStatement();
        try{
            String sql;
            sql = "delete from cliente where codcli="+codCli;
            stat.execute(sql);
        }catch(SQLException e){
            throw new SQLException("Erro ao excluir: \n" +e);
    }finally{
            c.close();
            stat.close();
        }
    
    }//Fecha o excluir
       
        public void alterarCli(Cliente cli)throws SQLException{
        Connection c = controller.ConexaoBanco.getConexao();
        Statement stat = c.createStatement();
        try{
            String sql;
            sql = "update cliente set nomecli ='"+cli.getNomeCli()+"' " 
                    + "where codcli="+cli.getCodCli();
               stat.execute(sql);
               
        }catch(SQLException e){
            throw new SQLException("Erro ao alterar:\n" +e);
        }finally{
            c.close();
            stat.close();
        }
    }//Fecha o alterar
       
         public ArrayList<Cliente> filtrarClientes(String query)throws SQLException{
           Connection c = controller.ConexaoBanco.getConexao();
           Statement stat = c.createStatement();
           
           try{
            String sql;
            sql = "select * from cliente "+query;
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Cliente> alC = new ArrayList();
 
            while(rs.next()){
               Cliente cli = new Cliente();
                cli.setCodCli(rs.getInt("codcli"));
                cli.setNomeCli(rs.getString("nomecli"));
                cli.setEmail(rs.getString("email"));
                cli.setIdade(rs.getInt("idade"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setCodProdCom(rs.getInt("codprod"));
                alC.add(cli);
                      
            }
            return alC;
           }catch(SQLException e){
           throw new SQLException("Erro ao filtrar pesquisa \n" +e);
           }finally{
               c.close();
               stat.close();
           }
    }

}//Fecha o método manipular

       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
