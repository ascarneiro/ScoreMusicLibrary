package br.bcc.controler.servlets;

import br.bcc.controler.classes.FilaProcessar;
import br.bcc.controler.classes.Uploads;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.bcc.model.Documento;
import br.bcc.model.Upload;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Windows
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String autor = request.getParameter("autor").trim();
        String instrumento = request.getParameter("instrumento").trim();
        String livro = request.getParameter("livro").trim();
        String caminho = request.getParameter("caminho").trim();

        String id = (autor + instrumento + livro).hashCode() + "";

        if (!Uploads.getInstance().exists(id)) {
            Documento doc = new Documento(id);
            doc.setAutor(autor);
            doc.setDsLivro(livro);
            doc.setInstrumento(instrumento);
            doc.setDsCaminhoArquivo(caminho);
            Uploads.getInstance().addUpload(doc.hashCode() + "", new Upload(doc));
            FilaProcessar.getFila().add(doc);
        }

    }
}
