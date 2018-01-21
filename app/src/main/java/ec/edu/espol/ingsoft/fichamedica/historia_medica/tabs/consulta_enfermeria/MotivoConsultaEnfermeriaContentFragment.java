package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_enfermeria;

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
import ec.edu.espol.ingsoft.fichamedica.model.ConsultaEnfermeria;

public class MotivoConsultaEnfermeriaContentFragment extends Fragment {

    private static final String TAG = "MotivoConsultaEnfermeriaContentFragment";
    EditText txt_motivo_atencion;
    Button btn_guardar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.motivo_consulta_enfermeria_content_fragment, container, false);

        txt_motivo_atencion = (EditText) view.findViewById(R.id.txt_motivo_atencion);
        btn_guardar = (Button) view.findViewById(R.id.btn_guardar);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConsultaEnfermeria consultaEnfermeria = new ConsultaEnfermeria();
                consultaEnfermeria.setMotivo_atencion(txt_motivo_atencion.getText().toString());

                consultaEnfermeria.save();

                Toast.makeText(getContext(), "Motivo de Atencion guardado exitoso",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}


