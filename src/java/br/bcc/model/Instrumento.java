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
public class Instrumento
{

    private String id;
    private String dsFamilia;
    private String dsInstrumento;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getDsFamilia()
    {
        return dsFamilia;
    }

    public void setDsFamilia(String dsFamilia)
    {
        this.dsFamilia = dsFamilia;
    }

    public String getDsInstrumento()
    {
        return dsInstrumento;
    }

    public void setDsInstrumento(String dsInstrumento)
    {
        this.dsInstrumento = dsInstrumento;
    }

}
