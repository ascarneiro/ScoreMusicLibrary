/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bcc.model;

/**
 *
 * @author Windows
 */
public class Usuario
{

    private String nmUsuario;
    private String dsEmail;
    private String dsSenha;
    private String ieAdministrador;

    public Usuario(String nmUsuario, String dsEmail, String ieAdministrador)
    {
        this.nmUsuario = nmUsuario;
        this.dsEmail = dsEmail;
        this.ieAdministrador = ieAdministrador;
    }
    
    public Usuario(String nmUsuario, String dsEmail, String dsSenha, String ieAdministrador)
    {
        this.nmUsuario = nmUsuario;
        this.dsEmail = dsEmail;
        this.dsSenha = dsSenha;
        this.ieAdministrador = ieAdministrador;
    }

    public Usuario(String dsEmail, String dsSenha)
    {
        this.dsEmail = dsEmail;
        this.dsSenha = dsSenha;
    }

    public String getDsEmail()
    {
        return dsEmail;
    }

    public String getDsSenha()
    {
        return dsSenha;
    }

    public String getNmUsuario()
    {
        return nmUsuario;
    }

    public String getIeAdministrador()
    {
        return ieAdministrador;
    }

    public void setIeAdministrador(String ieAdministrador)
    {
        this.ieAdministrador = ieAdministrador;
    }

}
