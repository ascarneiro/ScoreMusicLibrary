package br.bcc.controler.classes;

import java.util.HashMap;
import br.bcc.model.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Windows
 */
public class Usuarios {

    private static Usuarios u;

    private Usuarios() {
    }

    private static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();

    public void addUsuario(String nmUsuario, String dsEmail, String dsSenha) {
        usuarios.put(dsEmail + dsSenha, new Usuario(dsEmail, dsSenha));
//        new SerializeInfra().Post("USUARIOS", this);
    }

    public void addUsuario(String dsEmail, String dsSenha) {
        usuarios.put(dsEmail + dsSenha, new Usuario(dsEmail, dsSenha));
//        new SerializeInfra().Post("USUARIOS", u);
    }

    public boolean existeUsuario(String dsEmail, String dsSenha) {
        return usuarios.containsKey(dsEmail + dsSenha);
    }

    public static Usuarios getInstance() {
        if (u == null) {
//            u = (Usuarios) new SerializeInfra().Get("USUARIOS");
            if (u == null) {
                u = new Usuarios();
            }
        }
        return u;
    }
}
