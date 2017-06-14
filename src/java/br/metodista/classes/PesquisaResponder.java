package br.metodista.classes;

import java.util.List;

/**
 *
 * @author ascarneiro
 */
public class PesquisaResponder {

    private String idPesquisa;
    private List<Questao> questoes;

    public PesquisaResponder(String idPesquisa) {
        this.idPesquisa = idPesquisa;
    }

    public List<Questao> getQuestoes() {
        
        return questoes;
    }

}
