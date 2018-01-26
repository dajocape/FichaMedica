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

import java.util.List;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.ConsultaEnfermeria;

public class MotivoConsultaEnfermeriaContentFragment extends Fragment {
    String idEmpleado;
    private static final String TAG = "MotivoConsultaEnfermeriaContentFragment";

    EditText txt_motivo_atencion;
    Button btn_guardar;

    List<ConsultaEnfermeria> consultaEnfermeriaList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.motivo_consulta_enfermeria_content_fragment, container, false);
        idEmpleado = getArguments().getString("idEmpleado");

        txt_motivo_atencion = (EditText) view.findViewById(R.id.txt_motivo_atencion);
        btn_guardar = (Button) view.findViewById(R.id.btn_guardar);

        readMotivoConsultaEnfermeria();

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            writeMotivoConsultaEnfermeria();
            }
        });

        return view;
    }

    private void readMotivoConsultaEnfermeria() {
        try{
            consultaEnfermeriaList = ConsultaEnfermeria.findWithQuery(ConsultaEnfermeria.class,"Select * from CONSULTA_ENFERMERIA where ID_EMPLEADO = ?;",idEmpleado);
        }catch (Exception e){
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

        if(!consultaEnfermeriaList.isEmpty()) {
            txt_motivo_atencion.setText(consultaEnfermeriaList.get(0).getMotivo_atencion());
        }

    }
    private void writeMotivoConsultaEnfermeria() {
        String texto = txt_motivo_atencion.getText().toString();
        ConsultaEnfermeria consulta;

        try{
            consultaEnfermeriaList = ConsultaEnfermeria.findWithQuery(ConsultaEnfermeria.class,"Select * from CONSULTA_ENFERMERIA where ID_EMPLEADO = ?;",idEmpleado);
            if(consultaEnfermeriaList.isEmpty()){
                consulta = new ConsultaEnfermeria();
                consulta.setIdEmpleado(idEmpleado);
                consulta.setMotivo_atencion(texto);
                consulta.save();
                Toast.makeText(getContext(),"Motivo Guardado",Toast.LENGTH_LONG).show();
            }else{
                consulta = consultaEnfermeriaList.get(0);
                consulta.setMotivo_atencion(texto);
                consulta.save();
                Toast.makeText(getContext(),"Motivo Guardado",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}


