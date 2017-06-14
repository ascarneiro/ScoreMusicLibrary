package br.bcc.services;

import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author ascarneiro
 */
@Path("pesquisas")
public class PesquisasResource {

//    @Context
//    private UriInfo context;
//
//    /**
//     * Creates a new instance of PesquisasResource
//     */
//    public PesquisasResource() {
//    }
//
//    /**
//     * Retrieves representation of an instance of
//     * br.metodista.servicos.PesquisasResource
//     *
//     * @return an instance of java.lang.String
//     */
//    @GET
//    @Produces("application/json")
//    public String getJson() {
//        try {
//            List<Pesquisa> pesquisas = new ArrayList<Pesquisa>();
//            GeralDao geralDao = new GeralDao();
//            ArrayList<ValueByName> linhas = geralDao.getDao().execSQL("select nr_sequencia, ds_pesquisa from pesquisa");
//            for (ValueByName linha : linhas) {
//                pesquisas.add(new Pesquisa(linha.getAsString("NR_SEQUENCIA"),
//                        linha.getAsString("DS_PESQUISA")));
//            }
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            return gson.toJson(pesquisas);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        }
//    }
//
//    @GET
//    @Produces("application/json")
//    @Path("/{nrSequencia}/")
//    public String getPesquisa(@PathParam("nrSequencia") String nrSequencia) {
//        try {
//            List<Pesquisa> pesquisas = new ArrayList<Pesquisa>();
//            GeralDao geralDao = new GeralDao();
//            ValueByName valueByName = new ValueByName();
//            valueByName.put("NR_SEQUENCIA", nrSequencia);
//            ArrayList<ValueByName> linhas = geralDao.getDao().execSQL("select nr_sequencia, ds_pesquisa from pesquisa where nr_sequencia = :nr_sequencia", valueByName);
//            for (ValueByName linha : linhas) {
//                pesquisas.add(new Pesquisa(linha.getAsString("NR_SEQUENCIA"),
//                        linha.getAsString("DS_PESQUISA")));
//            }
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            return gson.toJson(pesquisas);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        }
//    }
//
//    @GET
//    @Produces("application/json")
//    @Path("/questionarios")
//    public String getQuestionario() {
//        try {
//            GeralDao geralDao = new GeralDao();
//            ArrayList<Questao> questionarios = new ArrayList<Questao>();
//            ArrayList<ValueByName> linhas = geralDao.getDao().execSQL("select nr_sequencia, ds_questao from questao");
//            for (ValueByName linha : linhas) {
//                questionarios.add(new Questao(
//                        linha.getAsString("NR_SEQUENCIA"),
//                        linha.getAsString("DS_QUESTAO")));
//            }
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            return gson.toJson(questionarios);
//
//        } catch (Exception e) {
//        }
//
////        Pesquisa pesquisa = new Pesquisa(id);
//        Gson gson = new Gson();
//        return gson.toJson(null);
//    }
//
//    @GET
//    @Produces("application/json")
//    @Path("/{nrSeqPesquisa}/questionario")
//    public String getQuestionario(@PathParam("nrSeqPesquisa") String nrSeqPesquisa) {
//        try {
//            GeralDao geralDao = new GeralDao();
//            ValueByName valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_PESQUISA", nrSeqPesquisa);
//            ArrayList<Questao> questionarios = new ArrayList<Questao>();
//            ArrayList<ValueByName> linhas = geralDao.getDao().execSQL("select nr_sequencia, ds_questao from questao where nr_seq_pesquisa = :NR_SEQ_PESQUISA", valueByName);
//            for (ValueByName linha : linhas) {
//                questionarios.add(new Questao(
//                        linha.getAsString("NR_SEQUENCIA"),
//                        linha.getAsString("DS_QUESTAO")));
//            }
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            return gson.toJson(questionarios);
//
//        } catch (Exception e) {
//        }
//
////        Pesquisa pesquisa = new Pesquisa(id);
//        Gson gson = new Gson();
//        return gson.toJson(null);
//    }
//
//    @GET
//    @Produces("application/json")
//    @Path("/questionario/{nrSeqQuestao}/alternativas")
//    public String getAlternativas(@PathParam("nrSeqPesquisa") String nrSeqPesquisa, @PathParam("nrSeqQuestao") String nrSeqQuestao) {
//        try {
//            GeralDao geralDao = new GeralDao();
//
//            ValueByName valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_QUESTAO", nrSeqQuestao);
//
//            ArrayList<Alternativa> alternativas = new ArrayList<Alternativa>();
//            ArrayList<ValueByName> linhas = geralDao.getDao().execSQL(
//                    " select    a.nr_seq_alternativa, "
//                    + "         (select x.ds_alternativa from alternativa x where x.nr_sequencia = a.nr_seq_alternativa) ds_alternativa, "
//                    + "         nr_seq_alternativa_select"
//                    + " from    alternativa_questao a"
//                    + " where   a.nr_seq_questao   = :nr_seq_questao", valueByName);
//
//            for (ValueByName linha : linhas) {
//                alternativas.add(new Alternativa(
//                        linha.getAsString("NR_SEQ_ALTERNATIVA"),
//                        linha.getAsString("DS_ALTERNATIVA"),
//                        "N"));
//            }
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            return gson.toJson(alternativas);
//
//        } catch (Exception e) {
//        }
//
////        Pesquisa pesquisa = new Pesquisa(id);
//        Gson gson = new Gson();
//        return gson.toJson(null);
//    }
//
//    /**
//     * PUT method for updating or creating an instance of PesquisasResource
//     *
//     * @param content representation for the resource
//     * @return an HTTP response with content of the updated or created resource.
//     */
//    @PUT
//    @Consumes("application/json")
//    public void putJson(String content) {
//    }
}
