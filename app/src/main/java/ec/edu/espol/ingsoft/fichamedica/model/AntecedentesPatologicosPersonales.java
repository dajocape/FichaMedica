package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;

/**
 * Created by Renato on 21/01/2018.
 */

public class AntecedentesPatologicosPersonales extends SugarRecord{

    private String idEmpleado;
    private String patologia;
    private String detallePatologia;

    public AntecedentesPatologicosPersonales() {
    }

    public AntecedentesPatologicosPersonales(String idEmpleado, String patologia, String detallePatologia) {
        this.idEmpleado = idEmpleado;
        this.patologia = patologia;
        this.detallePatologia = detallePatologia;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getDetallePatologia() {
        return detallePatologia;
    }

    public void setDetallePatologia(String detallePatologia) {
        this.detallePatologia = detallePatologia;
    }
}
