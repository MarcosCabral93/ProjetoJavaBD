/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBeans;

/**
 *
 * @author USUARIO
 */
public class BeansUsuario {

    /**
     * @return the idUsu
     */
    public Integer getIdUsu() {
        return idUsu;
    }

    /**
     * @param idUsu the idUsu to set
     */
    public void setIdUsu(Integer idUsu) {
        this.idUsu = idUsu;
    }

    /**
     * @return the usuNome
     */
    public String getUsuNome() {
        return usuNome;
    }

    /**
     * @param usuNome the usuNome to set
     */
    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    /**
     * @return the usuTipo
     */
    public String getUsuTipo() {
        return usuTipo;
    }

    /**
     * @param usuTipo the usuTipo to set
     */
    public void setUsuTipo(String usuTipo) {
        this.usuTipo = usuTipo;
    }

    /**
     * @return the usuSenha
     */
    public String getUsuSenha() {
        return usuSenha;
    }

    /**
     * @param usuSenha the usuSenha to set
     */
    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }
    
    private Integer idUsu;
    private String usuNome;
    private String usuTipo;
    private String usuSenha;
    private String usuPesquisar;

    /**
     * @return the usuPesquisar
     */
    public String getUsuPesquisar() {
        return usuPesquisar;
    }

    /**
     * @param usuPesquisar the usuPesquisar to set
     */
    public void setUsuPesquisar(String usuPesquisar) {
        this.usuPesquisar = usuPesquisar;
    }
}
