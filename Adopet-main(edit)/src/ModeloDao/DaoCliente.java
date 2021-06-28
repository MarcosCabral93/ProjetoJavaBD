/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.BeansClientes;
import modeloConection.ConexaoBD;

/**
 *
 * @author USUARIO
 */
public class DaoCliente {
  
   ConexaoBD conex=new ConexaoBD();
   ConexaoBD conexBairro = new ConexaoBD();
   String nomeBairro;
   
   
   int codBai;
   public void Salvar(BeansClientes cli ){
       buscaBaiCod(cli.getNomeBairro());
       conex.conexao();
       try {
           PreparedStatement pst=conex.con.prepareStatement("insert into clientes(cliente_nome,cliente_data,cliente_rg,cliente_telefone,cliente_rua,cliente_cep,cliente_complemento,cliente_bairro_codigo) values(?,?,?,?,?,?,?,?) ");
           pst.setString(1,cli.getNomeCliente());
           pst.setString(2, cli.getNasc());
           pst.setString(3, cli.getRg());
           pst.setString(4,cli.getTelefone());
           pst.setString(5,cli.getRua());
           pst.setString(6, cli.getCep());
           pst.setString(7, cli.getComplemento());
           pst.setInt(8,codBai);
           pst.execute();
           JOptionPane.showMessageDialog(null, "Salvo com sucesso");
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao salvar"+ ex);
       }
       conex.desconecta();

}
   
    public void Alterar(BeansClientes cli ){
       buscaBaiCod(cli.getNomeBairro());
       conex.conexao();
       try {
           PreparedStatement pst=conex.con.prepareStatement("update clientes set cliente_nome=?,cliente_data=?,cliente_rg=?,cliente_telefone=?,cliente_rua=?,cliente_cep=?,cliente_complemento=?,cliente_bairro_codigo=? where cliente_id=?");
           pst.setString(1,cli.getNomeCliente());
           pst.setString(2, cli.getNasc());
           pst.setString(3, cli.getRg());
           pst.setString(4,cli.getTelefone());
           pst.setString(5,cli.getRua());
           pst.setString(6, cli.getCep());
           pst.setString(7, cli.getComplemento());
           pst.setInt(8,codBai);
           pst.setInt(9,cli.getCodCliente());
           pst.execute();
           JOptionPane.showMessageDialog(null, "Aterado  com sucesso");
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Alterar"+ ex);
       }
       conex.desconecta();

}
   
   
   
   public void buscaBaiCod(String nome){
       conex.conexao();
       conex.executaSql("select * from bairro where bairro_nome='"+nome+"'");
       try {
           conex.rs.first();
           codBai=conex.rs.getInt("bairro_codigo");
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,"Erro ao buscar Bairro" + ex);
       }
   }
   
   public BeansClientes buscaCliente(BeansClientes cli){
       conex.conexao();
       try{
       conex.executaSql("select * from clientes where cliente_nome like '%"+cli.getPesquisar()+"%'");
       conex.rs.first();
       buscaNomeBairro(conex.rs.getInt("cliente_bairro_codigo"));
       cli.setNomeCliente(conex.rs.getString("cliente_nome"));
       cli.setCep(conex.rs.getString("cliente_cep"));
       cli.setCodCliente(conex.rs.getInt("cliente_id"));
       cli.setComplemento(conex.rs.getString("cliente_complemento"));
       cli.setNasc(conex.rs.getString("cliente_data"));
       cli.setRg(conex.rs.getString("cliente_rg"));
       cli.setRua(conex.rs.getString("cliente_rua"));
       cli.setNomeBairro(nomeBairro);
       cli.setTelefone(conex.rs.getString("cliente_telefone"));
       }catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao buscar cliente"+ ex);
       }
       conex.desconecta();
       return cli;
       
   }
   public void Excluir(BeansClientes cli){
       conex.conexao();
       try {
           PreparedStatement pst=conex.con.prepareStatement("delete from clientes where cliente_id=?");
           pst.setInt(1,cli.getCodCliente());
           pst.execute();
           JOptionPane.showMessageDialog(null,"cliente excluido com sucesso");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao excluir clientes"+ ex);
       }
    
}
   
   
   
   public void buscaNomeBairro(int cod){
       conexBairro.conexao();
       
       try {
           conexBairro.executaSql("select *  from bairro where bairro_codigo="+cod);
           conexBairro.rs.first();
           nomeBairro=conexBairro.rs.getString("bairro_nome");
       } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Erro ao buscar nome do bairro"+ ex);
       }
       
   }

}
