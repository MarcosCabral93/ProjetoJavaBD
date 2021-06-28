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
import modeloBeans.BeansAgenda;
import modeloConection.ConexaoBD;


/**
 *
 * @author USUARIO
 */
public class DaoAgenda {
    BeansAgenda agenda = new BeansAgenda();
    ConexaoBD conexPet=new ConexaoBD();
    ConexaoBD conexCli=new ConexaoBD();
    ConexaoBD conex=new ConexaoBD();
    int codPet;
    int codCli;
    public void Salvar(BeansAgenda agenda){
        BuscaPet(agenda.getNomePet());
        BuscaCli(agenda.getNomeCliente());
        conex.conexao();
        try{
        PreparedStatement pst = conex.con.prepareStatement("insert into agendamento (agenda_cliente_id, agenda_pet_id, agenda_turno, agenda_data,agenda_status) values(?,?,?,?,?)");
        pst.setInt(1,codCli);
        pst.setInt(2, codPet);
        pst.setString(3,agenda.getTurno());
        pst.setDate(4, new java.sql.Date(agenda.getData().getTime()));
        pst.setString(5, agenda.getStatus());
        pst.execute();
        JOptionPane.showMessageDialog(null,"Tudo certo!");
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao Salvar agendamento"+ex);
                }
        conex.desconecta();
    }
    
    public void BuscaPet(String nomePet){
        conexPet.conexao();
        conexPet.executaSql("select * from pets where nome_pet='"+nomePet+"'");
        try {
            conexPet.rs.first();
            codPet=conexPet.rs.getInt("id_pet");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar"+ ex);
        }
    }
     public int BuscaCodPet(String nomePet){
        conexPet.conexao();
        conexPet.executaSql("select * from pets where nome_pet='"+nomePet+"'");
        try {
            conexPet.rs.first();
            codPet=conexPet.rs.getInt("id_pet");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar"+ ex);
        }
        return codPet;
     }
    
    
   public void alterar(BeansAgenda agenda){
       conex.conexao();
       
       try {
           PreparedStatement pst=conex.con.prepareStatement("update agendamento set agenda_status=?  where agenda_codigo=?");
           pst.setString(1,agenda.getStatus());
           pst.setInt(2, agenda.getAgendaCod());
          
           pst.execute();
           JOptionPane.showMessageDialog(null, "Agendamento em atendimento");
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao atender"+ ex);
       }
       conex.desconecta();
       
       
       
       
   }
    public void BuscaCli(String nomeCli){
        conexCli.conexao();
        conexCli.executaSql("select * from clientes where cliente_nome='"+nomeCli+"'");
        try {
            conexCli.rs.first();
            codCli=conexCli.rs.getInt("cliente_id");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar"+ ex);
        }
    }
    
    public BeansAgenda buscaAgendaPorCodigo(int cod){
        BeansAgenda agen= new BeansAgenda();
        conex.conexao();
        conex.executaSql("select * from agendamento inner join clientes on agenda_cliente_id=cliente_id inner join pets on agenda_pet_id=id_pet where agenda_codigo='"+cod+"'");
        try{
            conex.rs.first();
            agen.setNomeCliente(conex.rs.getString("cliente_nome"));
            agen.setNomePet(conex.rs.getString("nome_pet"));
            agen.setCliente_nascimento(conex.rs.getString("cliente_data"));
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "erro ao buscar"+ex);
        }
        return agen;
        }
        
    }

