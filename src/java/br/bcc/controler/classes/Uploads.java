/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bcc.controler.classes;

import java.util.HashMap;
import java.util.Iterator;
import br.bcc.model.Upload;

/**
 *
 * @author Windows
 */
public class Uploads {

    private static Uploads u;
    private static HashMap<String, Upload> uploads = new HashMap<>();

    private Uploads() {
    }

    public void addUpload(String id, Upload u) {
        uploads.put(id, u);
//        new SerializeInfra().Post("UPLOADS", u);
    }

    public boolean exists(String id) {
        return uploads.containsKey(id);
    }

    public static Uploads getInstance() {
        if (u == null) {
//            u = (Uploads) new SerializeInfra().Get("UPLOADS");
            if (u == null) {
                u = new Uploads();

                Iterator<String> iterator = uploads.keySet().iterator();
                //Reprocessar
                while (iterator.hasNext()) {
                    FilaProcessar.getFila().add(uploads.get(iterator.next()).getDocumento());
                }

            }
        }
        return u;
    }
}
