package br.metodista.classes;

/**
 *
 * @author ascarneiro
 */
public class Usuario {

    private Long nrSequencia;
    private String nmUsuario;
    private String ieStatus;
    private String ieTipo;

    public Usuario(Long nrSequencia, String nmUsuario, String ieStatus, String ieTipo) {
        this.nrSequencia = nrSequencia;
        this.nmUsuario = nmUsuario;
        this.ieStatus = ieStatus;
        this.ieTipo = ieTipo;
    }

    public Long getNrSequencia() {
        return nrSequencia;
    }

    public void setNrSequencia(Long nrSequencia) {
        this.nrSequencia = nrSequencia;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getIeStatus() {
        return ieStatus;
    }

    public void setIeStatus(String ieStatus) {
        this.ieStatus = ieStatus;
    }

    public String getIeTipo() {
        return ieTipo;
    }

    public void setIeTipo(String ieTipo) {
        this.ieTipo = ieTipo;
    }

}
