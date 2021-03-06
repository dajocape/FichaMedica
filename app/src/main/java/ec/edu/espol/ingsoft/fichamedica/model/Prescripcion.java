package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;

/**
 * Created by jorge on 18/1/2018.
 */

public class Prescripcion extends SugarRecord {

    String idEmpleado;
    String contenido;

    public Prescripcion() {
    }

    public Prescripcion(String idEmpleado, String contenido) {
        this.idEmpleado = idEmpleado;
        this.contenido = contenido;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
