package br.metodista.classes;

import br.metodista.dao.GeralDao;
import gerais.ValueByName;

/**
 *
 * @author ascarneiro
 */
public class Pesquisa extends GeralDao {

    private String nrSequencia;
    private String dsPesquisa;

    public Pesquisa(String nrSequencia, String dsPesquisa) {
        super();
        this.nrSequencia = nrSequencia;
        this.dsPesquisa = dsPesquisa;
    }

    public String getDsPesquisa() {
        return dsPesquisa;
    }

    public String getNrSequencia() {
        return nrSequencia;
    }

  
}
