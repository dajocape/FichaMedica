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

public class SignosVitalesFragment extends Fragment {

    private static final String TAG = "SignosVitalesFragment";
    EditText ET_presionArterial,
            ET_pulsoPorMinuto,
            ET_temperatura,
            ET_motivoConsulta;
    Button BTN_guardar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signos_vitales_fragment,container,false);

        ET_presionArterial = view.findViewById(R.id.ET_presionArterial);
        ET_pulsoPorMinuto = view.findViewById(R.id.ET_pulsoPorMinuto);
        ET_temperatura = view.findViewById(R.id.ET_temperatura);
        BTN_guardar = view.findViewById(R.id.BTN_guardar);

        BTN_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignosVitales signosVitalesPaciente = new SignosVitales(
                        Integer.parseInt(ET_presionArterial.getText().toString()),
                        Integer.parseInt(ET_pulsoPorMinuto.getText().toString()),
                        Integer.parseInt(ET_temperatura.getText().toString()));
                signosVitalesPaciente.save();
            }
        });
        return view;
    }
}
