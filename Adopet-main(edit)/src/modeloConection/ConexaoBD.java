/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloConection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBD {
public Statement stm;
public ResultSet rs;
private String driver= "org.postgresql.Driver";
private String caminho="jdbc:postgresql://localhost:5432/projetoAdote";
private String usuario="postgres";
private String senha="1221";
public Connection con;

public void conexao(){
    try{
        System.setProperty("jdbc.Drivers", driver);
        con=DriverManager.getConnection(caminho,usuario,senha);
     // JOptionPane.showMessageDialog(null,"Conectado");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "erro ao conectar"+ex.getMessage());
         }
      }
public void executaSql(String sql){
    try {
        stm=con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
        rs=stm.executeQuery(sql);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Erro ExecutaSql: \n" +ex.getMessage());
    }
    
}
public void desconecta(){
    try{
        con.close();
      // JOptionPane.showMessageDialog(null, "BD desconectado");
    }catch(SQLException ex){
       
        JOptionPane.showConfirmDialog(null,"Erro ao Sair"+ex.getMessage());    }
    }
}
