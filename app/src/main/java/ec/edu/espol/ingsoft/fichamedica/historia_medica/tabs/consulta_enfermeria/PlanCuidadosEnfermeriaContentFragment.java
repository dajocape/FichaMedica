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

public class PlanCuidadosEnfermeriaContentFragment extends Fragment {

    private static final String TAG = "SignosVitalesContentFragment";
    EditText txt_plan_cuidados;
    Button btn_guardar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plan_de_cuidados_enfermeria_content_fragment, container, false);

        txt_plan_cuidados= view.findViewById(R.id.txt_plan_cuidados);
        btn_guardar =     view.findViewById(R.id.btn_guardar);

//        btn_guardar.setOnClickListener(new View.OnClickListener() {
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
