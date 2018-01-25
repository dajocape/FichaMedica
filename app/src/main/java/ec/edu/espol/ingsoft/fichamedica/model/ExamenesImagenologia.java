package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;

/**
 * Created by jorge on 25/1/2018.
 */

public class ExamenesImagenologia extends SugarRecord {

    private String idEmpleado;
    private String rutaExamenes;
    private String rutaImagen;

    public ExamenesImagenologia() {
    }

    public ExamenesImagenologia(String idEmpleado, String rutaExamenes, String rutaImagen) {
        this.idEmpleado = idEmpleado;
        this.rutaExamenes = rutaExamenes;
        this.rutaImagen = rutaImagen;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getRutaExamenes() {
        return rutaExamenes;
    }

    public void setRutaExamenes(String rutaExamenes) {
        this.rutaExamenes = rutaExamenes;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
