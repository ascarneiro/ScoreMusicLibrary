package br.metodista.classes;

import br.metodista.dao.GeralDao;

/**
 *
 * @author ascarneiro
 */
public class Questao extends GeralDao {

    private String nrSequencia;
    private String dsQuestao;

    public Questao(String nrSequencia, String dsQuestao) {
        this.nrSequencia = nrSequencia;
        this.dsQuestao = dsQuestao;
    }

    public String getDsQuestao() {
        return dsQuestao;
    }

    public String getNrSequencia() {
        return nrSequencia;
    }   
}
