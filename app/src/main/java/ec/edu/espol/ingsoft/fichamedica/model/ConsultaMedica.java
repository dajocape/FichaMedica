package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * TODO Javadoc
 */

public class ConsultaMedica extends SugarRecord {

    @Unique
    Empleado empleado;

    @Unique
    Diagnostico diagnostico;

//    @Unique
//    Medicamento medicamento;

//    @Unique
//    ExamenFisico examenFisico

    String motivo;
    String revision_aparatos;

    public ConsultaMedica() {
    }

    public ConsultaMedica(Empleado empleado, Diagnostico diagnostico, String motivo, String revision_aparatos) {
        this.empleado = empleado;
        this.diagnostico = diagnostico;
        this.motivo = motivo;
        this.revision_aparatos = revision_aparatos;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getRevision_aparatos() {
        return revision_aparatos;
    }

    public void setRevision_aparatos(String revision_aparatos) {
        this.revision_aparatos = revision_aparatos;
    }
}
