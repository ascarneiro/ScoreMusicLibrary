/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bcc.controler.classes;

import java.util.HashMap;
import br.bcc.model.Upload;

/**
 *
 * @author Windows
 */
public class Processados {

    private HashMap<String, Processado> processados = new HashMap<String, Processado>();

    private static Processados p;

    private Processados() {
    }

    public static Processados getInstance() {
        if (p == null) {
//            p = (Processados) new SerializeInfra().Get("USUARIOS");

            if (p == null) {
                p = new Processados();
            }
        }
        return p;
    }

    public void addProcessado(String id, Upload upload) {
        processados.put(id, new Processado(id, upload));
//        new SerializeInfra().Post("PROCESSADOS", this);
    }

}
