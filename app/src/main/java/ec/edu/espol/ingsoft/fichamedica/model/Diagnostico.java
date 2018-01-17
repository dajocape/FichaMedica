package ec.edu.espol.ingsoft.fichamedica.model;

import android.support.annotation.StringDef;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by jorge on 7/1/2018.
 */

public class Diagnostico extends SugarRecord {

    @Unique
    Enfermedad enfermedad;

    String descripcion;

    public Diagnostico() {
    }

    public Diagnostico(Enfermedad enfermedad, String descripcion) {
        this.enfermedad = enfermedad;
        this.descripcion = descripcion;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
