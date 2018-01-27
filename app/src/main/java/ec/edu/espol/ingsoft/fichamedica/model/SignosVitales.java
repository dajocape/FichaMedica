package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;

public class SignosVitales extends SugarRecord {

    String idEmpleado;

    boolean isConsultaMedica;
    boolean isConsultaEnfermeria;

    //===> ConsultaMedica
    String fecha;
    int presionArterialSistolica;
    int presionArterialDistolica;
    int frecuenciaCardiaca;
    float temperatura;
    //<===


    int frecuencia_respiratoria;
    float talla;
    float peso;
    float IMC;

    public SignosVitales() {
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public boolean isConsultaMedica() {
        return isConsultaMedica;
    }

    public void setConsultaMedica(boolean consultaMedica) {
        isConsultaMedica = consultaMedica;
    }

    public boolean isConsultaEnfermeria() {
        return isConsultaEnfermeria;
    }

    public void setConsultaEnfermeria(boolean consultaEnfermeria) {
        isConsultaEnfermeria = consultaEnfermeria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPresionArterialSistolica() {
        return presionArterialSistolica;
    }

    public void setPresionArterialSistolica(int presionArterialSistolica) {
        this.presionArterialSistolica = presionArterialSistolica;
    }

    public int getPresionArterialDistolica() {
        return presionArterialDistolica;
    }

    public void setPresionArterialDistolica(int presionArterialDistolica) {
        this.presionArterialDistolica = presionArterialDistolica;
    }

    public int getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
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
}
