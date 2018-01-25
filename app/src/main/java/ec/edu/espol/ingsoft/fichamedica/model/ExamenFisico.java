package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;

/**
 * Created by Anny on 20/01/2018.
 */

public class ExamenFisico extends SugarRecord {

    String idEmpleado;
    String descripcion;

    public ExamenFisico(){
    }

    public ExamenFisico(String idEmpleado, String descripcion) {
        this.idEmpleado = idEmpleado;
        this.descripcion = descripcion;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
