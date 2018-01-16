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
}
