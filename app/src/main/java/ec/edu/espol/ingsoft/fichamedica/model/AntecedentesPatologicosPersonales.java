package ec.edu.espol.ingsoft.fichamedica.model;

/**
 * Created by Renato on 21/01/2018.
 */

public class AntecedentesPatologicosPersonales{
    private String patologia;
    private String detallePatologia;

    public AntecedentesPatologicosPersonales(String patologia, String detallePatologia){
        this.patologia=patologia;
        this.detallePatologia=detallePatologia;
    }

    public String getPatologia(){
        return patologia;
    }

    public String getDetallePatologia(){
        return detallePatologia;
    }
}
