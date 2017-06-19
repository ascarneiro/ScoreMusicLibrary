/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bcc.model;

import java.util.ArrayList;

/**
 *
 * @author Windows
 */
public class DocumentoProcesso extends Documento
{

    private String nmUsuario;
    private String dtAtualizacao;
    private ArrayList<Midia> midias = new ArrayList<Midia>();

    public DocumentoProcesso(String id)
    {
        super(id);
    }

    public void addMidia(Midia midia)
    {
        midias.add(midia);
    }

    public ArrayList<Midia> getMidias()
    {
        return midias;
    }

    public void setNmUsuario(String nmUsuario)
    {
        this.nmUsuario = nmUsuario;
    }

    public String getNmUsuario()
    {
        return nmUsuario;
    }

    public void setDtAtualizacao(String dtAtualizacao)
    {
        this.dtAtualizacao = dtAtualizacao;
    }

    public String getDtAtualizacao()
    {
        return dtAtualizacao;
    }

}
