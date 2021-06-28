/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansUsuario;
import modeloConection.ConexaoBD;

/**
 *
 * @author USUARIO
 */
public class DaoUsuario {
     ConexaoBD conex=new ConexaoBD();
    BeansUsuario mod=new BeansUsuario();
    
    
    public void Salvar(BeansUsuario mod){
        conex.conexao();
        try{
        PreparedStatement pst=conex.con.prepareStatement("insert into usuarios(usu_nome,usu_senha,usu_tipo)values(?,?,?)");
        pst.setString(1,mod.getUsuNome());
        pst.setString(2,mod.getUsuSenha());
        pst.setString(3,mod.getUsuTipo());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "erro ao inserir usuário!/nErro: "+ex);
        }
        conex.desconecta();
}
    public void Alterar (BeansUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst= conex.con.prepareStatement("update usuarios set usu_nome=?, usu_senha=?, usu_tipo=? where usu_id=?");
        pst.setString(1,mod.getUsuNome());
        pst.setString(2,mod.getUsuSenha());
        pst.setString(3,mod.getUsuTipo());
        pst.setInt(4, mod.getIdUsu());
        pst.execute();
        JOptionPane.showMessageDialog(null, " Usuario alterado com sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro na alteraçãodo usuario!" +ex);
        }
        conex.desconecta();
    }
    
    
public BeansUsuario buscaUsuario(BeansUsuario mod){
        conex.conexao();
        conex.executaSql("select *from usuarios where usu_nome like'%"+mod.getUsuPesquisar()+"%'");
        try {
            conex.rs.first();
            mod.setIdUsu(conex.rs.getInt("usu_id"));
            mod.setUsuNome(conex.rs.getString("usu_nome"));
            mod.setUsuSenha(conex.rs.getString("usu_senha"));
            mod.setUsuTipo(conex.rs.getString("usu_tipo"));
           
          
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Usuário não encontrado não cadastrado");
        }
        conex.desconecta();
        return mod;
    }

    public void Excluir(BeansUsuario mod){
        conex.conexao();
        try{
            PreparedStatement pst=conex.con.prepareStatement("delete from usuarios where usu_id=?");
            pst.setInt(1, mod.getIdUsu());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Usuario Excluido com sucesso");
        }catch(SQLException ex ){
            JOptionPane.showMessageDialog(null,"Erro ao excluir usuário"+ ex);}
        
        
    }    




    }


