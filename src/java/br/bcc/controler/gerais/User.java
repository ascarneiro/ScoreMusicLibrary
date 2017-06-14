/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bcc.controler.gerais;

/**
 *
 * @author ascarneiro
 */
public class User {

    private String nmUsuario = "root";
    private String nmPessoaFisica = "";
    private String dsSenha = "root";
    private String connectionName = "scoreold";

    public User(String nmUsuario, String dsSenha) {
        this.nmUsuario = nmUsuario;
        this.dsSenha = dsSenha;
    }


    public String getNmPessoaFisica() {
        return nmPessoaFisica;
    }

    public void setNmPessoaFisica(String nmPessoaFisica) {
        this.nmPessoaFisica = nmPessoaFisica;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
    }

    public String getConnectionName() {
        return connectionName;
    }
}
