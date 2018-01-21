package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_enfermeria;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ec.edu.espol.ingsoft.fichamedica.R;

public class SignosVitalesEnfermeriaContentFragment extends Fragment {

    private static final String TAG = "SignosVitalesEnfermeriaContentFragment";

    EditText txtPresionArterial,
            txtPulsoPorMinuto,
            txtTemperatura;
    Button btnGuardar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signos_vitales_enfermeria_content_fragment, container, false);

        txtPresionArterial = view.findViewById(R.id.txt_presion_arterial);
        txtPulsoPorMinuto = view.findViewById(R.id.txt_pulso_por_minuto);
        txtTemperatura = view.findViewById(R.id.txt_temperatura);
        btnGuardar =     view.findViewById(R.id.btn_guardar);

//        btnGuardar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SignosVitales signosVitalesPaciente = new SignosVitales();
//
//                signosVitalesPaciente.setPresion_arterial(Integer.parseInt(txtPresionArterial.getText().toString()));
//                signosVitalesPaciente.setFrecuencia_cardiaca(Integer.parseInt(txtPulsoPorMinuto.getText().toString()));
//                signosVitalesPaciente.setTemperatura(Integer.parseInt(txtTemperatura.getText().toString()));
//
//                signosVitalesPaciente.save();
//
//                Toast.makeText(getContext(), "Signos Vitales Guardados exitosamente", Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;
    }
}
