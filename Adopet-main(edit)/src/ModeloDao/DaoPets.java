/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import modeloConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.BeansPets;

/**
 *
 * @author USUARIO
 */
public class DaoPets {
    ConexaoBD conex=new ConexaoBD();
    BeansPets mod=new BeansPets();
    
    
    public void Salvar(BeansPets mod){
        conex.conexao();
        try{
        PreparedStatement pst=conex.con.prepareStatement("insert into pets(nome_pet,raca_pet,tipo_pet)values(?,?,?)");
        pst.setString(1,mod.getNome());
        pst.setString(2,mod.getRaca());
        pst.setString(3,mod.getTipo());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Dados inseridos");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "erro ao inserir dados!/nErro: "+ex);
        }
        conex.desconecta();
    }
    public void Editar (BeansPets mod){
        conex.conexao();
        try {
            PreparedStatement pst= conex.con.prepareStatement("update pets set nome_pet=?, raca_pet=?, tipo_pet=? where id_pet=? ");
        pst.setString(1,mod.getNome());
        pst.setString(2,mod.getRaca());
        pst.setString(3,mod.getTipo());
        pst.setInt(4, mod.getCodigo());
        pst.execute();
        JOptionPane.showMessageDialog(null, "alterado com sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro na alteração!" +ex);
        }
    }
public void Excluir(BeansPets mod){
        conex.conexao();
        try{
            PreparedStatement pst=conex.con.prepareStatement("delete from pets where id_pet=?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Excluidos com sucesso");
        }catch(SQLException ex ){
            JOptionPane.showMessageDialog(null,"Erro ao excluir"+ ex);}
        
        
    }    


    
    public BeansPets buscaPets(BeansPets mod){//pesquisa campos no BD
        conex.conexao();
        conex.executaSql("select *from pets where nome_pet like'%"+mod.getPesquisa()+"%'");
        try {
            conex.rs.first();
            mod.setCodigo(conex.rs.getInt("id_pet"));
            mod.setNome(conex.rs.getString("nome_pet"));
            mod.setTipo(conex.rs.getString("tipo_pet"));
            mod.setRaca(conex.rs.getString("raca_pet"));
          
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Pet não cadastrado");
        }
        conex.desconecta();
        return mod;
    }
    
}
