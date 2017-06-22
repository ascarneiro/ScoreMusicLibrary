/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bcc.services;

import br.bcc.controler.gerais.ValueByName;
import br.bcc.controler.intermediarias.DaoFactory;
import br.bcc.dao.DAO;
import br.bcc.model.Usuario;
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
@Path("usuarios")
public class UsuariosRestService
{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll()
    {
        ArrayList usuarios = new ArrayList();
        try
        {
            DAO dao = DaoFactory.getUser();

            ArrayList<ValueByName> linhas = dao.execSQL("select nr_sequencia, ds_email, "
                    + "ie_administrador, "
                    + "nm_usuario "
                    + "from usuario");
            //

            for (ValueByName linha : linhas)
            {
                Usuario usuario = new Usuario();
                usuario.setId(linha.getAsString("NR_SEQUENCIA"));
                usuario.setDsEmail(linha.getAsString("DS_EMAIL"));
                usuario.setIeAdministrador(linha.getAsString("IE_ADMINISTRADOR"));
                usuario.setNmUsuario(linha.getAsString("NM_USUARIO"));
                usuarios.add(usuario);
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(usuarios);
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
            ArrayList<ValueByName> linhas = dao.execSQL("select nr_sequencia, ds_email, "
                    + "ie_administrador, "
                    + "nm_usuario "
                    + "from usuario where nr_sequencia = :nr_sequencia", restricao);
            //
            Usuario usuario = new Usuario();
            usuario.setId(linhas.get(0).getAsString("NR_SEQUENCIA"));
            usuario.setDsEmail(linhas.get(0).getAsString("DS_EMAIL"));
            usuario.setIeAdministrador(linhas.get(0).getAsString("IE_ADMINISTRADOR"));
            usuario.setNmUsuario(linhas.get(0).getAsString("NM_USUARIO"));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(usuario);
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
        Usuario usuario = gson.fromJson(json, Usuario.class);
        DAO dao = DaoFactory.getUser();
        ValueByName p = new ValueByName();
        p.put("NR_SEQUENCIA", (usuario.getDsEmail() + usuario.getNmUsuario()).hashCode());
        p.put("NM_USUARIO", usuario.getNmUsuario());
        p.put("DS_EMAIL", usuario.getDsEmail());
        p.put("DS_SENHA", usuario.getDsSenha());
        p.put("IE_ADMINISTRADOR", usuario.getIeAdministrador());
        try
        {
            dao.insert("USUARIO", p);

            return gson.toJson(usuario);
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
            Usuario usuario = gson.fromJson(json, Usuario.class);
            DAO dao = DaoFactory.getUser();
            ValueByName restricao = new ValueByName();
            restricao.put("NR_SEQUENCIA", (usuario.getDsEmail() + usuario.getNmUsuario()).hashCode());

            ValueByName update = new ValueByName();
            update.put("NR_SEQUENCIA", (usuario.getDsEmail() + usuario.getNmUsuario()).hashCode());
            update.put("NM_USUARIO", usuario.getNmUsuario());
            update.put("DS_EMAIL", usuario.getDsEmail());
            update.put("DS_SENHA", usuario.getDsSenha());
            update.put("IE_ADMINISTRADOR", usuario.getIeAdministrador());
            dao.update("USUARIO", update, restricao);

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
            Usuario usuario = gson.fromJson(json, Usuario.class);
            
            DAO dao = DaoFactory.getUser();
            ValueByName p = new ValueByName();
            p.put("NR_SEQUENCIA", (usuario.getDsEmail() + usuario.getNmUsuario()).hashCode());
            dao.delete("USUARIO", p);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
