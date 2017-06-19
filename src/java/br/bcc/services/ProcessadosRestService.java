/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bcc.services;

import br.bcc.controler.gerais.ValueByName;
import br.bcc.controler.intermediarias.DaoFactory;
import br.bcc.dao.DAO;
import br.bcc.model.Documento;
import br.bcc.model.DocumentoProcesso;
import br.bcc.model.Midia;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/processados")
public class ProcessadosRestService
{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll()
    {
        ArrayList processados = new ArrayList();
        try
        {
            DAO dao = DaoFactory.getUser();
            ArrayList<ValueByName> linhas = dao.execSQL("select 	a.nr_sequencia,\n"
                    + "		a.ds_autor,\n"
                    + "		a.ds_instrumento,\n"
                    + "		a.ds_livro, b.nm_usuario, b.dt_atualizacao, \n"
                    + "		c.ds_caminho from midia c, documento_processo b, documento a where a.nr_sequencia = b.nr_seq_documento and  b.nr_seq_midia = c.nr_sequencia");
            //

            for (ValueByName linha : linhas)
            {

                DocumentoProcesso doc = new DocumentoProcesso(linha.getAsString("NR_SEQUENCIA"));
                doc.setAutor(linha.getAsString("DS_AUTOR"));
                doc.setDsCaminhoArquivo(linha.getAsString("DS_CAMINHO_ARQUIVO"));
                doc.setLivro(linha.getAsString("DS_LIVRO"));
                doc.setInstrumento(linha.getAsString("DS_INSTRUMENTO"));
                doc.setDtAtualizacao(linha.getAsString("DS_ATUALIZACAO"));
                doc.setNmUsuario(linha.getAsString("NM_USUARIO"));

                Midia midia = new Midia(linha.getAsString("DS_CAMINHO"));
                doc.addMidia(midia);
                processados.add(doc);
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(processados);

        } catch (Exception e)
        {
            return null;
        }
    }
}
