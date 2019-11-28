/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infoq.dal;
import java.sql.*;


/**
 *
 * @author Grazi
 */
public class ModuloConexao {
    public static Connection conector(){
        java.sql.Connection conexao = null;
        //chamar o driver
        String DRIVER = "com.mysql.jdbc.Driver";
        
        
       // informações referente ao BD Local
        String URL = "jdbc:mysql://localhost:3306/DBINFOQ?useSSL=false";
        String USER = "root";
        String PASSWOD = "Info@1234"; 
         
        /*
        //informações referente ao BD Local Hospedado
        String URL = "jdbc:mysql://br944.hostgator.com.br:3306/mfsystem_dbinfoq?useSSL=false";
        String USER = "mfsystem_moniel";
        String PASSWODR = "Info@1234"; 
       */
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,USER,PASSWOD);
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            
            return null;
        }
    }
    
      public static void closeConnection(Connection con){
          if (con != null){
              
              try {
                  con.close();
              } catch (SQLException ex) {
                   System.err.println("ERRO: "+ex);
              }
          }
      }
      
      
      public static void closeConnection(Connection con, PreparedStatement stmt){
          if (stmt != null){
              
              try {
                  stmt.close();
              } catch (SQLException ex) {
                 System.err.println("ERRO "+ex);    
                         
                         
              }
          }
          
          closeConnection(con);
      }
      
      public static void closeConnection(Connection con, PreparedStatement stnt, ResultSet rs){
          if (rs != null){
              
              try {
                  rs.close();
              } catch (SQLException ex) {
                  System.err.println("ERRO "+ex); 
          }
          
          closeConnection(con, stnt);
      }
}
}
