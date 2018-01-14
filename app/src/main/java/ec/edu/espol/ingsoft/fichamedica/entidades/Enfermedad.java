package ec.edu.espol.ingsoft.fichamedica.entidades;

/**
 * Created by jorge on 7/1/2018.
 */

public class Enfermedad {
    public String nombre;
    public String codigo;

    public Enfermedad(){
        super();
    }

    public Enfermedad(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
