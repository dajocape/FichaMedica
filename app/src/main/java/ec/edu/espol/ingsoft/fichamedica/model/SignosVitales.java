package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * TODO Javadoc
 */

public class SignosVitales extends SugarRecord {

    @Unique
    ConsultaMedica consultaMedica;

    //@Unique
    // ConsultaEnfermeria consultaEnfermeria;

    int presion_arterial;
    int frecuencia_cardiaca;
    int frecuencia_respiratoria;
    float talla;
    float peso;
    float IMC;
    int temperatura;

    public SignosVitales() {
    }

    public SignosVitales(ConsultaMedica consultaMedica, int presion_arterial, int frecuencia_cardiaca, int frecuencia_respiratoria, float talla, float peso, float IMC, int temperatura) {
        this.consultaMedica = consultaMedica;
        this.presion_arterial = presion_arterial;
        this.frecuencia_cardiaca = frecuencia_cardiaca;
        this.frecuencia_respiratoria = frecuencia_respiratoria;
        this.talla = talla;
        this.peso = peso;
        this.IMC = IMC;
        this.temperatura = temperatura;
    }
}
