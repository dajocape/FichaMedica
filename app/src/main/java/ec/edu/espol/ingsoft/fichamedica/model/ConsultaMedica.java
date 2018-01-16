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
}
