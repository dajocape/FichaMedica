package ec.edu.espol.ingsoft.fichamedica.model;

import com.orm.SugarRecord;

/**
 * Created by Anny on 20/01/2018.
 */

public class RevisionMedica extends SugarRecord{
    String enfermedad;
    String revision_organos_sistemas;

    public RevisionMedica(){

    }

    public RevisionMedica(String enfermedad, String revision_organos_sistemas){
        this.enfermedad=enfermedad;
        this.revision_organos_sistemas=revision_organos_sistemas;

    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getRevision_organos_sistemas() {
        return revision_organos_sistemas;
    }

    public void setRevision_organos_sistemas(String revision_organos_sistemas) {
        this.revision_organos_sistemas = revision_organos_sistemas;
    }
}
