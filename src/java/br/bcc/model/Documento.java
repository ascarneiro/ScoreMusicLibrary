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
public class Documento
{

    private String id;
    private String obra;
    private String autor;
    private String instrumento;
    private String livro;
    private String dsCaminhoArquivoPDF;
    private String dsCaminhoArquivoMIDI;

    public Documento(String id)
    {
        this.id = id;
    }

    public String getObra()
    {
        return obra;
    }

    public void setObra(String obra)
    {
        this.obra = obra;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public String getAutor()
    {
        return autor;
    }

    public void setLivro(String livro)
    {
        this.livro = livro;
    }

    public void setAutor(String autor)
    {
        this.autor = autor;
    }

    public String getInstrumento()
    {
        return instrumento;
    }

    public void setInstrumento(String instrumento)
    {
        this.instrumento = instrumento;
    }

    public String getLivro()
    {
        return livro;
    }

    public String getDsCaminhoArquivo()
    {
        return dsCaminhoArquivoPDF;
    }

    public void setDsCaminhoArquivoPDF(String dsCaminhoArquivo)
    {
        this.dsCaminhoArquivoPDF = dsCaminhoArquivo;
    }

    public void setDsCaminhoArquivoMIDI(String dsCaminhoArquivoMIDI)
    {
        this.dsCaminhoArquivoMIDI = dsCaminhoArquivoMIDI;
    }

    public String getDsCaminhoArquivoMIDI()
    {
        return dsCaminhoArquivoMIDI;
    }

    @Override
    public int hashCode()
    {
        return (autor + instrumento + livro).hashCode();
    }

}
