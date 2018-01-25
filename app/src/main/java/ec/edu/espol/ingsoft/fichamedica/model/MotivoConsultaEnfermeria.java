package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by jorge on 25/1/2018.
 */

public class MotivoConsultaEnfermeria extends SugarRecord {
    @Unique
    private String idEmpleado;
    private String contenido;
    private String rutaImagen;

    public MotivoConsultaEnfermeria() {
    }

    public MotivoConsultaEnfermeria(String idEmpleado, String contenido, String rutaImagen) {
        this.idEmpleado = idEmpleado;
        this.contenido = contenido;
        this.rutaImagen = rutaImagen;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
