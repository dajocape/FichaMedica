package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;

/**
 * Created by Anny on 20/01/2018.
 */

public class ExamenFisico extends SugarRecord {
    String descripcion;

    public ExamenFisico(){

    }

    public ExamenFisico(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
