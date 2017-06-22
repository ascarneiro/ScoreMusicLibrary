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
                    + "		b.ds_autor,\n"
                    + "		b.ds_instrumento,\n"
                    + "		b.ds_livro, a.nm_usuario, a.dt_atualizacao, "
                    + "(select max(x.DS_CAMINHO) from midia x where x.nr_sequencia = a.nr_seq_midia_PDF) DS_CAMINHO_ARQUIVO_PDF, \n"
                    + "(select max(x.DS_CAMINHO) from midia x where x.nr_sequencia = a.nr_seq_midia_MIDI) DS_CAMINHO_ARQUIVO_MIDI \n"
                    + "		from documento_processo a, documento b "
                    + " where   a.nr_seq_documento = b.nr_sequencia");
            //

            for (ValueByName linha : linhas)
            {

                DocumentoProcesso doc = new DocumentoProcesso(linha.getAsString("NR_SEQUENCIA"));
                doc.setAutor(linha.getAsString("DS_AUTOR"));
                doc.setDsCaminhoArquivoPDF(linha.getAsString("DS_CAMINHO_ARQUIVO_PDF"));
                doc.setDsCaminhoArquivoMIDI(linha.getAsString("DS_CAMINHO_ARQUIVO_MIDI"));
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
