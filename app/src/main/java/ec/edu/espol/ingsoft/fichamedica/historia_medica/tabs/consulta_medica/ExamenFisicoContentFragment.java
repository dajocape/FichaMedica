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
import ec.edu.espol.ingsoft.fichamedica.model.ExamenFisico;
import ec.edu.espol.ingsoft.fichamedica.model.RevisionMedica;

/**
 * Created by Anny on 07/01/2018.
 */

public class ExamenFisicoContentFragment extends Fragment {
    String idEmpleado;
    private static final String TAG = "ExamenFisicoContentFragment";

    EditText txtDescripcion;
    Button btnGuardar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.examen_fisico_content_fragment, container, false);
        idEmpleado = getArguments().getString("idEmpleado");
        //Toast.makeText(getContext(),idEmpleado,Toast.LENGTH_SHORT).show();

        txtDescripcion = view.findViewById(R.id.text_revision);

        btnGuardar = view.findViewById(R.id.button_guardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExamenFisico examenFisico = new ExamenFisico();
                examenFisico.setDescripcion(txtDescripcion.getText().toString());

                examenFisico.save();

                Toast.makeText(getContext(),"Datos de Examen físico Guardados exitosamente",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
