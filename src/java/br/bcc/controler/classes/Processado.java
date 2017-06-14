/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bcc.controler.classes;

import br.bcc.model.Upload;

/**
 *
 * @author Windows
 */
public class Processado {

    private String id;
    private Upload up;

    public Processado(String id, Upload up) {
        this.id = id;
        this.up = up;
    }

    public String getId() {
        return id;
    }

    public Upload getUpload() {
        return up;
    }

}
