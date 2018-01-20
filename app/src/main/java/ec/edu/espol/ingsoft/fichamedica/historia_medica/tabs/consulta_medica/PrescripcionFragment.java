package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica;


import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.Fragment;

import java.util.List;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.Prescripcion;

public class PrescripcionFragment extends Fragment {


    private static final String TAG = "PrescripcionFragment";

    EditText contenido;
    Button guardar;
    List<Prescripcion> prescripcion;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.prescripcion_fragment, container, false);

        contenido = (EditText) view.findViewById(R.id.etPresContenido);
        guardar = (Button) view.findViewById(R.id.btnPresGuardar);

        readPrescripcion();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writePrescripcion();
            }
        });

        return view;
    }

    public void readPrescripcion(){
        prescripcion = Prescripcion.listAll(Prescripcion.class);

        if(!prescripcion.isEmpty()) {
            contenido.setText(prescripcion.get(prescripcion.size()-1).getContenido());
        }
    }

    public void writePrescripcion(){
        Prescripcion nueva_prescripcion = new Prescripcion();

        String texto = contenido.getText().toString();

        if(!texto.isEmpty()){
            nueva_prescripcion.setContenido(texto);
            try{
                nueva_prescripcion.save();
            }catch(Exception e){
                //Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }else{
            //Toast.makeText(getApplicationContext(),"No se guardo nada porque no se escribio nada",Toast.LENGTH_LONG).show();
        }
    }
}

