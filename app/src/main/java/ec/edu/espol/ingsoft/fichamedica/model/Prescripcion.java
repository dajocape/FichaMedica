package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;

/**
 * Created by jorge on 18/1/2018.
 */

public class Prescripcion extends SugarRecord {

    int id;
    String contenido;

    public Prescripcion() {
    }

    public Prescripcion(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
