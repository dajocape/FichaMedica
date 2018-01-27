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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.SignosVitales;

public class SignosVitalesEnfermeriaContentFragment extends Fragment {
    String idEmpleado;
    private static final String TAG = "SignosVitalesEnfermeriaContentFragment";

    EditText presionSistolica;
    EditText presionDistolica;
    EditText pulsosPorMinuto;
    EditText temperatura;

    Button masSis;
    Button menosSis;
    Button masDis;
    Button menosDis;
    Button masPulso;
    Button menosPulso;
    Button masTemperatura;
    Button menosTemperatura;
    Button btn_guardar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signos_vitales_enfermeria_content_fragment, container, false);
        idEmpleado = getArguments().getString("idEmpleado");

        presionSistolica = (EditText) view.findViewById(R.id.txt_presion_distolica);
        presionDistolica = (EditText) view.findViewById(R.id.txt_presion_sistolica);
        pulsosPorMinuto = (EditText) view.findViewById(R.id.txt_pulso);
        temperatura = (EditText) view.findViewById(R.id.txt_temperatura);

        masSis = (Button) view.findViewById(R.id.btn_mas_sis);
        menosSis = (Button) view.findViewById(R.id.btn_menos_sis);
        masDis = (Button) view.findViewById(R.id.btn_mas_dis);
        menosDis = (Button) view.findViewById(R.id.btn_menos_dis);
        masPulso = (Button) view.findViewById(R.id.btn_mas_pulso);
        menosPulso = (Button) view.findViewById(R.id.btn_menos_pulso);
        masTemperatura = (Button) view.findViewById(R.id.btn_mas_temperatura);
        menosTemperatura = (Button) view.findViewById(R.id.btn_menos_temperatura);
        btn_guardar =     view.findViewById(R.id.btn_guardar);



        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeSignosVitales();
            }
        });
        return view;
    }

    public void writeSignosVitales(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date currentTime = Calendar.getInstance().getTime();
        String fechaActual = simpleDateFormat.format(currentTime);
        int presionArterialSistolica = Integer.parseInt(presionSistolica.getText().toString());
        int presionArterialDistolica = Integer.parseInt(presionDistolica.getText().toString());
        int pulsos = Integer.parseInt(pulsosPorMinuto.getText().toString());
        float tempert = Float.parseFloat(temperatura.getText().toString());

        SignosVitales signosVitales = new SignosVitales();
        signosVitales.setIdEmpleado(idEmpleado);
        signosVitales.setConsultaEnfermeria(true);
        signosVitales.setFecha(fechaActual);
        signosVitales.setPresionArterialSistolica(presionArterialSistolica);
        signosVitales.setPresionArterialDistolica(presionArterialDistolica);
        signosVitales.setFrecuenciaCardiaca(pulsos);
        signosVitales.setTemperatura(tempert);

        try{
            signosVitales.save();
            Toast.makeText(getContext(),"Signos vitales guardados",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
