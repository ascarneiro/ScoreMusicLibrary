/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bcc.services;

import br.bcc.controler.gerais.ValueByName;
import br.bcc.controler.intermediarias.DaoFactory;
import br.bcc.dao.DAO;
import br.bcc.model.Instrumento;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Windows
 */
@Path("instrumentos")
public class InstrumentoRestService
{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll()
    {
        ArrayList instrumentos = new ArrayList();
        try
        {
            DAO dao = DaoFactory.getUser();

            ArrayList<ValueByName> linhas = dao.execSQL("select nr_sequencia, ds_Instrumento, "
                    + "ds_Familia "
                    + "from instrumento");
            //

            for (ValueByName linha : linhas)
            {
                Instrumento usuario = new Instrumento();
                usuario.setId(linha.getAsString("NR_SEQUENCIA"));
                usuario.setDsInstrumento(linha.getAsString("DS_INSTRUMENTO"));
                usuario.setDsFamilia(linha.getAsString("DS_FAMILIA"));
                instrumentos.add(usuario);
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(instrumentos);
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
            ArrayList<ValueByName> linhas = dao.execSQL("select nr_sequencia, ds_instrumento, "
                    + "ds_familia "
                    + "from instrumento where nr_sequencia = :nr_sequencia", restricao);
            //
            Instrumento instrumento = new Instrumento();
            instrumento.setId(linhas.get(0).getAsString("NR_SEQUENCIA"));
            instrumento.setDsInstrumento(linhas.get(0).getAsString("DS_INSTRUMENTO"));
            instrumento.setDsFamilia(linhas.get(0).getAsString("DS_FAMILIA"));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(instrumento);
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
        Instrumento instrumento = gson.fromJson(json, Instrumento.class);
        DAO dao = DaoFactory.getUser();
        ValueByName p = new ValueByName();
        p.put("NR_SEQUENCIA", (instrumento.getDsInstrumento() + instrumento.getDsFamilia()).hashCode());
        p.put("DS_INSTRUMENTO", instrumento.getDsInstrumento());
        p.put("DS_FAMILIA", instrumento.getDsFamilia());
        try
        {
            dao.insert("INSTRUMENTO", p);

            return gson.toJson(instrumento);
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
            Instrumento instrumento = gson.fromJson(json, Instrumento.class);
            DAO dao = DaoFactory.getUser();
            ValueByName restricao = new ValueByName();
            restricao.put("NR_SEQUENCIA", instrumento.getId());

            ValueByName update = new ValueByName();
            update.put("NR_SEQUENCIA", (instrumento.getDsInstrumento() + instrumento.getDsFamilia()).hashCode());
            update.put("DS_INSTRUMENTO", instrumento.getDsInstrumento());
            update.put("DS_FAMILIA", instrumento.getDsFamilia());

            dao.update("INSTRUMENTO", update, restricao);

            return json;
        } catch (Exception e)
        {
            return null;
        }
    }

    @DELETE
    @Path("/delete/{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("json") String json
    )
    {
        try
        {

            Gson gson = new Gson();
            Instrumento instrumento = gson.fromJson(json, Instrumento.class);
            DAO dao = DaoFactory.getUser();
            ValueByName p = new ValueByName();
            p.put("NR_SEQUENCIA", instrumento.getId());
            dao.delete("INSTRUMENTO", p);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
