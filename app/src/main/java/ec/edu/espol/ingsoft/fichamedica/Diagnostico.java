package ec.edu.espol.ingsoft.fichamedica;

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
}
