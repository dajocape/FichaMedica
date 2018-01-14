package ec.edu.espol.ingsoft.fichamedica.utilidades;

/**
 * Created by jorge on 13/1/2018.
 */

public class Utilidades {

    //Base de datos
    public static final String NOMBRE_BASE = "bd_historial_medico";

    //Constantes campos tabla enfermedad
    public static final String TABLA_ENFERMEDAD = "enfermedad";
    public static final String ENFERMEDAD_CAMPO_NOMBRE = "nombre";
    public static final String ENFERMEDAD_CAMPO_CODIGO = "codigo";


    //Constantes campos tabla diagnostico
    public static final String TABLA_DIAGNOSTICO = "diagnostico";
    public static final String DIAGNOSTICO_CAMPO_ENFERMEDAD = "enfermedad";
    public static final String DIAGNOSTICO_CAMPO_CODIGO = "codigo";
    public static final String DIAGNOSTICO_CAMPO_TIPO_ENFERMEDAD = "tipoEnfermedad";

    public static final String CREAR_TABLA_ENFERMEDAD =  "CREATE TABLE " +TABLA_ENFERMEDAD+"("+ ENFERMEDAD_CAMPO_NOMBRE +" TEXT, " + ENFERMEDAD_CAMPO_CODIGO +" TEXT)";
    public static final String CREAR_TABLA_DIAGNOSTICO = "CREATE TABLE " +TABLA_DIAGNOSTICO+"("+ DIAGNOSTICO_CAMPO_ENFERMEDAD +" TEXT, " + DIAGNOSTICO_CAMPO_CODIGO +" TEXT, "+DIAGNOSTICO_CAMPO_TIPO_ENFERMEDAD+" TEXT)";
}
