package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;

/**
 * Created by Renato on 20/01/2018.
 */

public class AntecedentesPatologicosFamiliares extends SugarRecord{

    private String idEmpleado;
    private String parentescoPaciente;
    private String enfermedadPariente;

    public AntecedentesPatologicosFamiliares() {
    }

    public AntecedentesPatologicosFamiliares(String idEmpleado, String parentescoPaciente, String enfermedadPariente) {
        this.idEmpleado = idEmpleado;
        this.parentescoPaciente = parentescoPaciente;
        this.enfermedadPariente = enfermedadPariente;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setParentescoPaciente(String parentescoPaciente) {
        this.parentescoPaciente = parentescoPaciente;
    }

    public void setEnfermedadPariente(String enfermedadPariente) {
        this.enfermedadPariente = enfermedadPariente;
    }

    public String getParentescoPaciente(){
        return parentescoPaciente;
    }
    public String getEnfermedadPariente(){
        return enfermedadPariente;
    }

}


