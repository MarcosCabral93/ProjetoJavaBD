/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBeans;

import java.util.Date;

/**
 *
 * @author USUARIO
 */
public class BeansAgenda {

    /**
     * @return the agendaCod
     */
    public int getAgendaCod() {
        return agendaCod;
    }

    /**
     * @param agendaCod the agendaCod to set
     */
    public void setAgendaCod(int agendaCod) {
        this.agendaCod = agendaCod;
    }

    /**
     * @return the nomePet
     */
    public String getNomePet() {
        return nomePet;
    }

    /**
     * @param nomePet the nomePet to set
     */
    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    private int agendaCod;
    private String nomePet;
    private String nomeCliente;
    private String turno;
    private Date data;
    private String status;
    private String cliente_nascimento;

    public String getCliente_nascimento() {
        return cliente_nascimento;
    }

    public void setCliente_nascimento(String cliente_nascimento) {
        this.cliente_nascimento = cliente_nascimento;
    }
    
}
