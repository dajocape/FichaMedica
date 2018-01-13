package ec.edu.espol.ingsoft.fichamedica.utilidades;

/**
 * Created by jorge on 13/1/2018.
 */

public class Utilidades {

    //Constantes campos tabla enfermedad
    public static final String TABLA_ENFERMEDAD="enfermedad";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_CODIGO="codigo";

    public static final String CREAR_TABLA_ENFERMEDAD= "CREATE TABLE " +TABLA_ENFERMEDAD+"("+CAMPO_NOMBRE+" TEXT, " +CAMPO_CODIGO+" TEXT)";
}
