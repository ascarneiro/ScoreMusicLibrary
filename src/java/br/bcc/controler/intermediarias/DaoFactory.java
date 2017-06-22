/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bcc.controler.intermediarias;

import br.bcc.controler.gerais.User;
import br.bcc.dao.DAO;

/**
 *
 * @author Windows
 */
public class DaoFactory {

    public static DAO getUser() {
        User user = new User("root", "root");
        return new DAO(user);
    }
}
