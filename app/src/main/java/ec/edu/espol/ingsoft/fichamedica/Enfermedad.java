package ec.edu.espol.ingsoft.fichamedica;

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
}
