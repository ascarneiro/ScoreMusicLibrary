package br.bcc.controler.servlets;

import br.bcc.controler.classes.Usuarios;
import br.bcc.controler.intermediarias.UsuarioController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Windows
 */
@WebServlet("/NovoUsuarioServlet")
public class NovoUsuarioServlet extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String usuario = request.getParameter("usuario").trim();
        String email1 = request.getParameter("email1").trim();
        String email2 = request.getParameter("email2").trim();
        String senha1 = request.getParameter("senha1").trim();
        String senha2 = request.getParameter("senha2").trim();

        int STATUS = UsuarioController.novoUsuario(usuario, email1, email2, senha1, senha2);
        if (UsuarioController.EMAIL_INCOERENTE == STATUS
                || UsuarioController.SENHA_INCOERENTE == STATUS
                || UsuarioController.ERRO_DESCONHECIDO == STATUS)
        {
            response.setStatus(response.SC_UNAUTHORIZED);

        } else
        {
            response.setStatus(response.SC_ACCEPTED);
        }
    }
}
