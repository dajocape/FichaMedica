package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.util.Date;

/**
 * TODO Javadoc
 */

public class PermisoMedico extends SugarRecord {

    @Unique
    Empleado empleado;

    @Unique
    Enfermedad enfermedad;

    String emitido_por;
    Date fecha_inicio;
    Date fecha_fin;
    int dias_permiso;
    String diagnostico;

    public PermisoMedico() {
    }

    public PermisoMedico(Empleado empleado, Enfermedad enfermedad, String emitido_por, Date fecha_inicio, Date fecha_fin, int dias_permiso, String diagnostico) {
        this.empleado = empleado;
        this.enfermedad = enfermedad;
        this.emitido_por = emitido_por;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.dias_permiso = dias_permiso;
        this.diagnostico = diagnostico;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getEmitido_por() {
        return emitido_por;
    }

    public void setEmitido_por(String emitido_por) {
        this.emitido_por = emitido_por;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getDias_permiso() {
        return dias_permiso;
    }

    public void setDias_permiso(int dias_permiso) {
        this.dias_permiso = dias_permiso;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
