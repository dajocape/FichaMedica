package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.SignosVitales;

public class SignosVitalesContentFragment extends Fragment {

    private static final String TAG = "SignosVitalesContentFragment";
    EditText txt_presion_arterial,
            txt_pulso_por_minuto,
            txt_temperatura;
    Button btn_guardar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signos_vitales_content_fragment,container,false);

        txt_presion_arterial = view.findViewById(R.id.txt_presion_arterial);
        txt_pulso_por_minuto = view.findViewById(R.id.txt_pulso_por_minuto);
        txt_temperatura = view.findViewById(R.id.txt_temperatura);
        btn_guardar = view.findViewById(R.id.btn_guardar);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignosVitales signosVitalesPaciente = new SignosVitales();

                signosVitalesPaciente.setPresion_arterial(Integer.parseInt(txt_presion_arterial.getText().toString()));
                signosVitalesPaciente.setFrecuencia_cardiaca(Integer.parseInt(txt_pulso_por_minuto.getText().toString()));
                signosVitalesPaciente.setTemperatura(Integer.parseInt(txt_temperatura.getText().toString()));

                signosVitalesPaciente.save();

                Toast.makeText(getContext(),"Signos Vitales Guardados exitosamente",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
