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
public class Documento {

    private String id;
    private String autor;
    private String instrumento;
    private String dsLivro;
    private String dsCaminhoArquivo;

    public Documento(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public String getDsLivro() {
        return dsLivro;
    }

    public void setDsLivro(String dsLivro) {
        this.dsLivro = dsLivro;
    }

    public String getDsCaminhoArquivo() {
        return dsCaminhoArquivo;
    }

    public void setDsCaminhoArquivo(String dsCaminhoArquivo) {
        this.dsCaminhoArquivo = dsCaminhoArquivo;
    }

    @Override
    public int hashCode() {
        return (autor + instrumento + dsLivro).hashCode();
    }

}
