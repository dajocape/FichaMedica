package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.util.Date;

/**
 * TODO Javadoc
 */

public class Empleado extends SugarRecord {

    @Unique
    String cedula;

    String profesion;
    String estado_civil;
    String sexo;
    String lugar_nacimiento;
    String ocupacion_actual;
    Date fecha_nacimiento;

    public Empleado() {
    }

    public Empleado(String cedula, String profesion, String estado_civil, String sexo, String lugar_nacimiento, String ocupacion_actual, Date fecha_nacimiento) {
        this.cedula = cedula;
        this.profesion = profesion;
        this.estado_civil = estado_civil;
        this.sexo = sexo;
        this.lugar_nacimiento = lugar_nacimiento;
        this.ocupacion_actual = ocupacion_actual;
        this.fecha_nacimiento = fecha_nacimiento;
    }


}
