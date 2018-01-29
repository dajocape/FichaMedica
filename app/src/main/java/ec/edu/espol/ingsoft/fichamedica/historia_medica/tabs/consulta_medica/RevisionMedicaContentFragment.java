package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.RevisionMedica;


public class RevisionMedicaContentFragment extends Fragment {

    private static final String TAG = "RevisionMedicaContentFragment";

    String idEmpleado;
    EditText enfermedad,
            revision;
    Button guardar;

    List<RevisionMedica> revisionMedicaList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.revision_medica_content_fragment, container, false);
        idEmpleado = getArguments().getString("idEmpleado");
        //Toast.makeText(getContext(),idEmpleado,Toast.LENGTH_SHORT).show();

        enfermedad =view.findViewById(R.id.text_enfermedad);
        revision =view.findViewById(R.id.text_revision);
        guardar =view.findViewById(R.id.button_guardar);

        cargarRevisionMedica();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RevisionMedica revisionMedica = new RevisionMedica();

                revisionMedica.setEnfermedad(enfermedad.getText().toString());
                revisionMedica.setRevision_organos_sistemas(revision.getText().toString());
                revisionMedica.setIdEmpleado(idEmpleado);

                revisionMedica.save();

                Toast.makeText(getContext(),"Datos de revisión médica Guardados exitosamente",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public void cargarRevisionMedica(){
        try{
            revisionMedicaList = RevisionMedica.find(RevisionMedica.class, "ID_EMPLEADO = ?",idEmpleado);
        }catch (Exception e){
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

        if(!revisionMedicaList.isEmpty()) {
            enfermedad.setText(revisionMedicaList.get(revisionMedicaList.size()-1).getEnfermedad());
            revision.setText(revisionMedicaList.get(revisionMedicaList.size()-1).getRevision_organos_sistemas());
        }
    }

}
