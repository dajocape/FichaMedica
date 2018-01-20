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

    public SignosVitales(int presion_arterial, int frecuencia_cardiaca, int temperatura) {
        this.presion_arterial = presion_arterial;
        this.frecuencia_cardiaca = frecuencia_cardiaca;
        this.temperatura = temperatura;
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

    public ConsultaMedica getConsultaMedica() {
        return consultaMedica;
    }

    public void setConsultaMedica(ConsultaMedica consultaMedica) {
        this.consultaMedica = consultaMedica;
    }

    public int getPresion_arterial() {
        return presion_arterial;
    }

    public void setPresion_arterial(int presion_arterial) {
        this.presion_arterial = presion_arterial;
    }

    public int getFrecuencia_cardiaca() {
        return frecuencia_cardiaca;
    }

    public void setFrecuencia_cardiaca(int frecuencia_cardiaca) {
        this.frecuencia_cardiaca = frecuencia_cardiaca;
    }

    public int getFrecuencia_respiratoria() {
        return frecuencia_respiratoria;
    }

    public void setFrecuencia_respiratoria(int frecuencia_respiratoria) {
        this.frecuencia_respiratoria = frecuencia_respiratoria;
    }

    public float getTalla() {
        return talla;
    }

    public void setTalla(float talla) {
        this.talla = talla;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getIMC() {
        return IMC;
    }

    public void setIMC(float IMC) {
        this.IMC = IMC;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
}
