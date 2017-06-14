/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bcc.controler.classes;

import br.bcc.controler.classes.Processados;
import br.bcc.model.Documento;
import br.bcc.model.Upload;

/**
 *
 * @author Windows
 */
public class TheadProcessar extends Thread {
    
    @Override
    public void run() {
        while (true) {
            if (!FilaProcessar.getFila().isEmpty()) {
                Documento doc = FilaProcessar.getFila().remove(FilaProcessar.getFila().size()-1);
                String id = doc.getId();
                Processados.getInstance().addProcessado(id, new Upload(doc));
            } else {
                try {
                    //Aguarda um tempo
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }
    }
    
}
