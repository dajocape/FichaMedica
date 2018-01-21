package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.util.Date;

/**
 * TODO Javadoc
 */

public class PermisoMedico extends SugarRecord {
    String fechaInicio;
    String fechaFin;
    String enfermedadNombre;
    String enfermedadCodigo;
    String observacion;
    int dias;

    public PermisoMedico(){

    }

    public PermisoMedico(String fechaInicio, String fechaFin, String enfermedadNombre, String enfermedadCodigo, String observacion, int dias){
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.enfermedadNombre = enfermedadNombre;
        this.enfermedadCodigo = enfermedadCodigo;
        this.observacion = observacion;
        this.dias = dias;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEnfermedadNombre() {
        return enfermedadNombre;
    }

    public void setEnfermedadNombre(String enfermedadNombre) {
        this.enfermedadNombre = enfermedadNombre;
    }

    public String getEnfermedadCodigo() {
        return enfermedadCodigo;
    }

    public void setEnfermedadCodigo(String enfermedadCodigo) {
        this.enfermedadCodigo = enfermedadCodigo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
}
