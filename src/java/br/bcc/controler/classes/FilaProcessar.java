/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bcc.controler.classes;

import java.util.ArrayList;
import br.bcc.model.Documento;

/**
 *
 * @author Windows
 */
public class FilaProcessar {

    private static ArrayList<Documento> fila = new ArrayList<Documento>();

    public static ArrayList<Documento> getFila() {
        return fila;
    }

}
