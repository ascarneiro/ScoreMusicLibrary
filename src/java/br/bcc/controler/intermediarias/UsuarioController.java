/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bcc.controler.intermediarias;

import br.bcc.controler.gerais.ValueByName;
import br.bcc.dao.DAO;

/**
 *
 * @author Windows
 */
public class UsuarioController
{

    public static final int SENHA_INCOERENTE = 0;
    public static final int EMAIL_INCOERENTE = 1;
    public static final int CADASTRO_REALIZADO = 2;
    public static final int ERRO_DESCONHECIDO = 3;

    public static boolean login(String email, String senha)
    {
        try
        {
            DAO dao = DaoFactory.getUser();
            ValueByName p = new ValueByName();
            p.put("DS_EMAIL", email);
            p.put("DS_SENHA", senha);
            return dao.execSQL("SELECT count(*) qt from usuario where ds_email = :ds_email and ds_senha = :ds_senha", p).get(0).getAsInteger("QT") > 0;
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static int novoUsuario(String usuario,
            String email1,
            String email2,
            String senha1,
            String senha2)
    {
        try
        {

            if (!email1.equalsIgnoreCase(email2))
            {
                return SENHA_INCOERENTE;
            } else if (!senha1.equalsIgnoreCase(senha2))
            {
                return EMAIL_INCOERENTE;
            }

            DAO dao = DaoFactory.getUser();
            ValueByName v = new ValueByName();
            v.put("DS_EMAIL", email1);
            v.put("DS_SENHA", senha1);
            dao.insert("USUARIO", v);

            return CADASTRO_REALIZADO;
        } catch (Exception e)
        {
            return ERRO_DESCONHECIDO;
        }
    }
}
