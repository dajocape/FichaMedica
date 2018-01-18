package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by jorge on 7/1/2018.
 */

public class Diagnostico extends SugarRecord {

    String enfermedad;
    String codigo;
    String tipoEnfermedad;

    public Diagnostico() {
    }

    public Diagnostico(String enfermedad, String codigo, String tipoEnfermedad) {
        this.enfermedad = enfermedad;
        this.codigo = codigo;
        this.tipoEnfermedad = tipoEnfermedad;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoEnfermedad() {
        return tipoEnfermedad;
    }

    public void setTipoEnfermedad(String tipoEnfermedad) {
        this.tipoEnfermedad = tipoEnfermedad;
    }
}
