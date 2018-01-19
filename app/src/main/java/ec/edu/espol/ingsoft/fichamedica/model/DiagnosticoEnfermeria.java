package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;

/**
 * Created by jorge on 18/1/2018.
 */

public class DiagnosticoEnfermeria extends SugarRecord {

    String contenido;

    public DiagnosticoEnfermeria() {
    }

    public DiagnosticoEnfermeria(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
