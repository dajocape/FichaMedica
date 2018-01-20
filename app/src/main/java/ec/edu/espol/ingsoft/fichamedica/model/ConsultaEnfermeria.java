package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * TODO Javadoc
 */

public class ConsultaEnfermeria extends SugarRecord {

    @Unique
    Empleado empleado;

    String motivo;
    String diagnostico_enfermeria;
    String plan_cuidados;

    public ConsultaEnfermeria() {
    }

    public ConsultaEnfermeria(Empleado empleado, String motivo, String diagnostico_enfermeria, String plan_cuidados) {
        this.empleado = empleado;
        this.motivo = motivo;
        this.diagnostico_enfermeria = diagnostico_enfermeria;
        this.plan_cuidados = plan_cuidados;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico_enfermeria() {
        return diagnostico_enfermeria;
    }

    public void setDiagnostico_enfermeria(String diagnostico_enfermeria) {
        this.diagnostico_enfermeria = diagnostico_enfermeria;
    }

    public String getPlan_cuidados() {
        return plan_cuidados;
    }

    public void setPlan_cuidados(String plan_cuidados) {
        this.plan_cuidados = plan_cuidados;
    }
}
