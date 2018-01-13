package ec.edu.espol.ingsoft.fichamedica;

/**
 * Created by Renato on 09/01/2018.
 */

public class EntidadAntecedentesPatologicosFamiliares {

    private String parentescoPaciente;
    private String enfermedadPariente;

    public EntidadAntecedentesPatologicosFamiliares(String parentescoPaciente, String enfermedadPariente){
        this.parentescoPaciente=parentescoPaciente;
        this.enfermedadPariente=enfermedadPariente;
    }

    public String getParentescoPaciente(){
        return parentescoPaciente;
    }

    public String getEnfermedadPariente(){
        return enfermedadPariente;
    }

}
