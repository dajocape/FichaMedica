package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by jorge on 7/1/2018.
 */

public class Enfermedad extends SugarRecord{

    @Unique
    int codigo_cie10;

    String nombre_cie10;

    public Enfermedad() {
    }

    public Enfermedad(int codigo_cie10, String nombre_cie10) {
        this.codigo_cie10 = codigo_cie10;
        this.nombre_cie10 = nombre_cie10;
    }
}
