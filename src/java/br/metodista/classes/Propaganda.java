package br.metodista.classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ascarneiro
 */
public class Propaganda {

    private String dsPropaganda;
    private List<Midia> midias;

    public Propaganda(String dsPropaganda) {
        this.midias = new ArrayList<Midia>(1);
        this.dsPropaganda = dsPropaganda;
    }

    public void addMidia(Midia midia) {
        this.midias.add(midia);
    }

    public String getDsPropaganda() {
        return dsPropaganda;
    }

    public List<Midia> getMidias() {
        return midias;
    }

}
