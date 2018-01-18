package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by jorge on 7/1/2018.
 */

public class Enfermedad extends SugarRecord{


    String codigo_cie10;

    String nombre_cie10;

    public Enfermedad() {
    }

    public Enfermedad(String codigo_cie10, String nombre_cie10) {
        this.codigo_cie10 = codigo_cie10;
        this.nombre_cie10 = nombre_cie10;
    }

    public String getCodigo_cie10() {
        return codigo_cie10;
    }

    public void setCodigo_cie10(String codigo_cie10) {
        this.codigo_cie10 = codigo_cie10;
    }

    public String getNombre_cie10() {
        return nombre_cie10;
    }

    public void setNombre_cie10(String nombre_cie10) {
        this.nombre_cie10 = nombre_cie10;
    }
}
