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
public class Upload {

    private Documento documento;

    public Upload(Documento documento) {
        this.documento = documento;
    }

    public Documento getDocumento() {
        return documento;
    }

}
