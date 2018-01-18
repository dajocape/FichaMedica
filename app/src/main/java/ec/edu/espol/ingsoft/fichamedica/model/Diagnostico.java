package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by jorge on 7/1/2018.
 */

public class Diagnostico extends SugarRecord {

    @Unique
    Enfermedad enfermedad;
    String tipoEnfermedad;

    public Diagnostico() {
    }

    public Diagnostico(Enfermedad enfermedad, String descripcion) {
        this.enfermedad = enfermedad;
        this.tipoEnfermedad = descripcion;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getTipoEnfermedad() {
        return tipoEnfermedad;
    }

    public void setTipoEnfermedad(String tipoEnfermedad) {
        this.tipoEnfermedad = tipoEnfermedad;
    }
}
