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
}
