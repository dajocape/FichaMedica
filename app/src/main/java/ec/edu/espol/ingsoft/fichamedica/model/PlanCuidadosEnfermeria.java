package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;

/**
 * Created by jorge on 19/1/2018.
 */

public class PlanCuidadosEnfermeria extends SugarRecord {

    String contenido;

    public PlanCuidadosEnfermeria() {
    }

    public PlanCuidadosEnfermeria(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
