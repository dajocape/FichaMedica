package ec.edu.espol.ingsoft.fichamedica.entidades;

/**
 * Created by jorge on 7/1/2018.
 */

public class Diagnostico {
    public String enfermedad;
    public String codigo;
    public String tipoEnfermedad;

    public Diagnostico() {
        super();
    }

    public Diagnostico(String enfermedad, String codigo, String tipoEnfermedad) {
        this.enfermedad = enfermedad;
        this.codigo = codigo;
        this.tipoEnfermedad = tipoEnfermedad;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoEnfermedad() {
        return tipoEnfermedad;
    }

    public void setTipoEnfermedad(String tipoEnfermedad) {
        this.tipoEnfermedad = tipoEnfermedad;
    }
}
