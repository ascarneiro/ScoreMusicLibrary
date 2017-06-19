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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/documentos")
public class DocumentoRestService
{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll()
    {
        ArrayList documentos = new ArrayList();
        try
        {
            DAO dao = DaoFactory.getUser();
            ArrayList<ValueByName> linhas = dao.execSQL("select nr_sequencia ,"
                    + " ds_autor, "
                    + "ds_instrumento, "
                    + "ds_livro "
                    + "from documento");
            //

            for (ValueByName linha : linhas)
            {
                Documento doc = new Documento(linha.getAsString("NR_SEQUENCIA"));
                doc.setAutor(linha.getAsString("DS_AUTOR"));
                doc.setDsCaminhoArquivo(linha.getAsString("DS_CAMINHO_ARQUIVO"));
                doc.setLivro(linha.getAsString("DS_LIVRO"));
                doc.setInstrumento(linha.getAsString("DS_INSTRUMENTO"));
                documentos.add(doc);
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(documentos);

        } catch (Exception e)
        {
            return null;
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getById(@PathParam("id") int id
    )
    {
        try
        {
            DAO dao = DaoFactory.getUser();

            ValueByName restricao = new ValueByName();
            restricao.put("NR_SEQUENCIA", id);
            ArrayList<ValueByName> linhas = dao.execSQL("select nr_sequencia, ds_autor, "
                    + "nr_seq_instrumento, "
                    + "ds_caminho_arquivo "
                    + "from documento where nr_sequencia = :nr_sequencia", restricao);
            //
            Documento doc = new Documento(linhas.get(0).getAsString("NR_SEQUENCIA"));
            doc.setAutor(linhas.get(0).getAsString("DS_AUTOR"));
            doc.setDsCaminhoArquivo(linhas.get(0).getAsString("DS_CAMINHO_ARQUIVO"));
            doc.setLivro(linhas.get(0).getAsString("DS_LIVRO"));
            doc.setInstrumento(linhas.get(0).getAsString("NR_SEQ_INSTRUMENTO"));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(doc);
        } catch (Exception e)
        {
            return null;
        }
    }

    @PUT
    @Path("/create/{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String create(@PathParam("json") String json
    )
    {

        Gson gson = new Gson();
        Documento doc = gson.fromJson(json, Documento.class);
        DAO dao = DaoFactory.getUser();
        ValueByName p = new ValueByName();
        p.put("NR_SEQUENCIA", (doc.getAutor() + doc.getInstrumento() + doc.getLivro()).hashCode());
        p.put("DS_AUTOR", doc.getAutor());
        p.put("DS_LIVRO", doc.getLivro());
        p.put("DS_INSTRUMENTO", doc.getInstrumento());
        p.put("DS_CAMINHO_ARQUIVO", doc.getDsCaminhoArquivo());
        try
        {
            dao.insert("DOCUMENTO", p);

            return gson.toJson(doc);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return "{}";

    }

    @PUT
    @Path("/update/{json}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@PathParam("json") String json
    )
    {
        try
        {
            Gson gson = new Gson();
            Documento doc = gson.fromJson(json, Documento.class);
            DAO dao = DaoFactory.getUser();
            ValueByName restricao = new ValueByName();
            restricao.put("NR_SEQUENCIA", doc.getId());

            ValueByName update = new ValueByName();
            update.put("NR_SEQUENCIA", doc.getAutor());
            update.put("DS_AUTOR", doc.getAutor());
            update.put("DS_LIVRO", doc.getLivro());
            update.put("NR_SEQ_INSTRUMENTO", doc.getInstrumento());
            update.put("DS_CAMINHO_ARQUIVO", doc.getDsCaminhoArquivo());
            dao.update("DOCUMENTO", update, restricao);

            return json;
        } catch (Exception e)
        {
            return null;
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") int id
    )
    {
        try
        {
            DAO dao = DaoFactory.getUser();
            ValueByName p = new ValueByName();
            p.put("NR_SEQUENCIA", id);
            dao.delete("DOCUMENTO", p);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
