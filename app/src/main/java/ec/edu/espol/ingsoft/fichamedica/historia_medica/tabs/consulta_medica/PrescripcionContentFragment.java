package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica;


import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import java.util.List;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.Prescripcion;

public class PrescripcionContentFragment extends Fragment {
    String idEmpleado;
    private static final String TAG = "PrescripcionContentFragment";

    EditText contenido;
    Button guardar;
    List<Prescripcion> prescripcionList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.prescripcion_content_fragment, container, false);
        idEmpleado = getArguments().getString("idEmpleado");
        //Toast.makeText(getContext(),idEmpleado,Toast.LENGTH_SHORT).show();

        contenido = (EditText) view.findViewById(R.id.txt_prescripcion);
        guardar = (Button) view.findViewById(R.id.btn_guardar);

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
        try{
            prescripcionList = Prescripcion.find(Prescripcion.class, "ID_EMPLEADO = ?",idEmpleado);
        }catch (Exception e){
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

        if(!prescripcionList.isEmpty()) {
            contenido.setText(prescripcionList.get(prescripcionList.size()-1).getContenido());
        }
    }

    public void writePrescripcion(){
        Prescripcion nueva_prescripcion = new Prescripcion();

        nueva_prescripcion.setIdEmpleado(idEmpleado);
        String texto = contenido.getText().toString();

        if(!texto.isEmpty()){
            nueva_prescripcion.setContenido(texto);
            try{
                nueva_prescripcion.save();
            }catch(Exception e){
                Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getContext(),"No se guardo nada porque no se escribio nada",Toast.LENGTH_LONG).show();
        }
    }
}

