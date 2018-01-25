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

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.RevisionMedica;
import ec.edu.espol.ingsoft.fichamedica.model.SignosVitales;

public class RevisionMedicaContentFragment extends Fragment {
    String idEmpleado;
    private static final String TAG = "RevisionMedicaContentFragment";
    EditText txtEnfermedad,
            txtRevision;
    Button btnGuardar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.revision_medica_content_fragment, container, false);
        idEmpleado = getArguments().getString("idEmpleado");
        //Toast.makeText(getContext(),idEmpleado,Toast.LENGTH_SHORT).show();

        txtEnfermedad =view.findViewById(R.id.text_enfermedad);
        txtRevision =view.findViewById(R.id.text_revision);
        btnGuardar =view.findViewById(R.id.button_guardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RevisionMedica revisionMedica = new RevisionMedica();

                revisionMedica.setEnfermedad(txtEnfermedad.getText().toString());
                revisionMedica.setRevision_organos_sistemas(txtRevision.getText().toString());

                revisionMedica.save();

                Toast.makeText(getContext(),"Datos de revisión médica Guardados exitosamente",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
