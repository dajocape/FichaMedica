package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.SignosVitales;

public class SignosVitalesContentFragment extends Fragment {

    private static final String TAG = "SignosVitalesContentFragment";
    EditText txtPresionArterial,
            txtPulsoPorMinuto,
            txtTemperatura,
            txtmotivoConsulta;
    Button btnGuardar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signos_vitales_content_fragment,container,false);

        txtPresionArterial = view.findViewById(R.id.txt_presion_arterial);
        txtPulsoPorMinuto = view.findViewById(R.id.txt_pulso_por_minuto);
        txtTemperatura = view.findViewById(R.id.txt_temperatura);
        btnGuardar = view.findViewById(R.id.btn_guardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignosVitales signosVitalesPaciente = new SignosVitales(
                        Integer.parseInt(txtPresionArterial.getText().toString()),
                        Integer.parseInt(txtPulsoPorMinuto.getText().toString()),
                        Integer.parseInt(txtTemperatura.getText().toString()));
                signosVitalesPaciente.save();
            }
        });
        return view;
    }
}
