package ec.edu.espol.ingsoft.fichamedica.model;

/**
 * Created by Renato on 20/01/2018.
 */

public class AntecedentesPatologicosFamiliares{

    private String parentescoPaciente;
    private String enfermedadPariente;

    public AntecedentesPatologicosFamiliares(String parentescoPaciente, String enfermedadPariente){
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


