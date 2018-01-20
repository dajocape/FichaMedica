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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getOcupacion_actual() {
        return ocupacion_actual;
    }

    public void setOcupacion_actual(String ocupacion_actual) {
        this.ocupacion_actual = ocupacion_actual;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
