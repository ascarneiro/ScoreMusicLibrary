package br.bcc.controler.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.bcc.controler.classes.TheadProcessar;
import br.bcc.controler.classes.Usuarios;
import br.bcc.controler.intermediarias.UsuarioDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.bcc.model.Usuario;

/**
 *
 * @author Windows
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String email = request.getParameter("email").trim();
        String senha = request.getParameter("senha").trim();
        if (UsuarioDAO.login(email, senha))
        {
            response.setStatus(response.SC_ACCEPTED);
        } else
        {
            response.setStatus(response.SC_UNAUTHORIZED);
        }

    }

}
