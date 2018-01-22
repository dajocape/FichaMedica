package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;

public class ConsultaEnfermeria extends SugarRecord {

    //@Unique
    //Empleado empleado;

    String motivo_atencion;
    String diagnostico_enfermeria;
    String plan_cuidados;

    public ConsultaEnfermeria() {
    }

    public ConsultaEnfermeria(String motivo_atencion) {
        //this.empleado = empleado;
        this.motivo_atencion = motivo_atencion;
        //this.diagnostico_enfermeria = diagnostico_enfermeria;
        //this.plan_cuidados = plan_cuidados;
    }

    public ConsultaEnfermeria(String motivo_atencion,String diagnostico_enfermeria, String plan_cuidados) {
        //this.empleado = empleado;
        this.motivo_atencion = motivo_atencion;
        this.diagnostico_enfermeria = diagnostico_enfermeria;
        this.plan_cuidados = plan_cuidados;
    }

    public String getMotivo_atencion() {
        return motivo_atencion;
    }

    public void setMotivo_atencion(String motivo_atencion) {
        this.motivo_atencion = motivo_atencion;
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
