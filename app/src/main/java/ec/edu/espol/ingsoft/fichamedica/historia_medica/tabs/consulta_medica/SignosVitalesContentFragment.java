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


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.SignosVitales;

public class SignosVitalesContentFragment extends Fragment {
    String idEmpleado;
    private static final String TAG = "SignosVitalesContentFragment";

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

    Button guardar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signos_vitales_content_fragment,container,false);

        idEmpleado = getArguments().getString("idEmpleado");

        presionSistolica = (EditText) view.findViewById(R.id.txt_presion_sistolica);
        presionDistolica = (EditText) view.findViewById(R.id.txt_presion_distolica);
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

        masSis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPress(view);
            }
        });
        menosSis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPress(view);
            }
        });
        masDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPress(view);
            }
        });
        menosDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPress(view);
            }
        });
        masPulso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPress(view);
            }
        });
        menosPulso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPress(view);
            }
        });
        masTemperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPress(view);
            }
        });
        menosTemperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPress(view);
            }
        });

        guardar = (Button) view.findViewById(R.id.btn_guardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeSignosVitales();
            }
        });

        return view;
    }

    public void writeSignosVitales(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date currentTime = Calendar.getInstance().getTime();
        String fechaActual = simpleDateFormat.format(currentTime);
        SignosVitales signosVitales = new SignosVitales();

        try{
            int presionArterialSistolica = Integer.parseInt(presionSistolica.getText().toString());
            int presionArterialDistolica = Integer.parseInt(presionDistolica.getText().toString());
            int pulsos = Integer.parseInt(pulsosPorMinuto.getText().toString());
            float tempert = Float.parseFloat(temperatura.getText().toString());

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

        }catch (Exception e){
            Toast.makeText(getContext(),"Por favor ingrese todos los datos",Toast.LENGTH_LONG).show();
        }
    }

    public void buttonPress(View view) {
        int valor;
        switch (view.getId()) {
            case R.id.btn_mas_sis:
                if(presionSistolica.getText().toString().isEmpty()){
                    presionSistolica.setText(String.valueOf(1));
                }else{
                    valor = Integer.parseInt(presionSistolica.getText().toString())+1;
                    presionSistolica.setText(String.valueOf(valor));
                }
                break;
            case R.id.btn_menos_sis:
                if(presionSistolica.getText().toString().isEmpty()){
                    presionSistolica.setText(String.valueOf(0));
                }else{
                    if(Integer.parseInt(presionSistolica.getText().toString())!=0){
                        valor = Integer.parseInt(presionSistolica.getText().toString())-1;
                        presionSistolica.setText(String.valueOf(valor));
                    }
                }
                break;
            case R.id.btn_mas_dis:
                if(presionDistolica.getText().toString().isEmpty()){
                    presionDistolica.setText(String.valueOf(1));
                }else{
                    valor = Integer.parseInt(presionDistolica.getText().toString())+1;
                    presionDistolica.setText(String.valueOf(valor));
                }
                break;
            case R.id.btn_menos_dis:
                if(presionDistolica.getText().toString().isEmpty()){
                    presionDistolica.setText(String.valueOf(0));
                }else{
                    if(Integer.parseInt(presionDistolica.getText().toString())!=0){
                        valor = Integer.parseInt(presionDistolica.getText().toString())-1;
                        presionDistolica.setText(String.valueOf(valor));
                    }
                }
                break;
            case R.id.btn_mas_pulso:
                if(pulsosPorMinuto.getText().toString().isEmpty()){
                    pulsosPorMinuto.setText(String.valueOf(1));
                }else{
                    valor = Integer.parseInt(pulsosPorMinuto.getText().toString())+1;
                    pulsosPorMinuto.setText(String.valueOf(valor));
                }
                break;
            case R.id.btn_menos_pulso:
                if(pulsosPorMinuto.getText().toString().isEmpty()){
                    pulsosPorMinuto.setText(String.valueOf(0));
                }else{
                    if(Integer.parseInt(pulsosPorMinuto.getText().toString())!=0){
                        valor = Integer.parseInt(pulsosPorMinuto.getText().toString())-1;
                        pulsosPorMinuto.setText(String.valueOf(valor));
                    }
                }
                break;
            case R.id.btn_mas_temperatura:
                if(temperatura.getText().toString().isEmpty()){
                    temperatura.setText(String.valueOf(1));
                }else{
                    valor = Integer.parseInt(temperatura.getText().toString())+1;
                    temperatura.setText(String.valueOf(valor));
                }
                break;
            case R.id.btn_menos_temperatura:
                if(temperatura.getText().toString().isEmpty()){
                    temperatura.setText(String.valueOf(0));
                }else{
                    if(Integer.parseInt(temperatura.getText().toString())!=0){
                        valor = Integer.parseInt(temperatura.getText().toString())-1;
                        temperatura.setText(String.valueOf(valor));
                    }
                }
                break;
        }
    }
}
