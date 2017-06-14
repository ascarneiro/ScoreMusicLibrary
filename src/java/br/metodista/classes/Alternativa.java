package br.metodista.classes;

/**
 *
 * @author ascarneiro
 */
public class Alternativa {

    private String dsAlternativa;
    private String nrSequencia;
    private boolean selecionada;

    public Alternativa(String nrSequencia, String dsAlternativa, String ieSelecionada) {
        this.nrSequencia = nrSequencia;
        this.dsAlternativa = dsAlternativa;
        this.selecionada = "S".equalsIgnoreCase(ieSelecionada);
    }

    public String getDsAlternativa() {
        return dsAlternativa;
    }

    public String getNrSequencia() {
        return nrSequencia;
    }

    public void setSelecionada(boolean selecionada) {
        this.selecionada = selecionada;
    }

    public boolean isSelecionada() {
        return selecionada;
    }
}
