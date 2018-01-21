package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;

/**
 * Created by jorge on 7/1/2018.
 */

public class Enfermedad extends SugarRecord{

    String nombre;
    String codigo;
    String grupo;

    public Enfermedad() {
    }

    public Enfermedad(String codigo, String nombre, String grupo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.grupo = grupo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
