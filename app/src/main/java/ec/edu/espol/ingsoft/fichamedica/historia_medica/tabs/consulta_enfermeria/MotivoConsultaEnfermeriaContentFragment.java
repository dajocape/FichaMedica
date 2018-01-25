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
import ec.edu.espol.ingsoft.fichamedica.model.MotivoConsultaEnfermeria;

public class MotivoConsultaEnfermeriaContentFragment extends Fragment {
    String idEmpleado;
    private static final String TAG = "MotivoConsultaEnfermeriaContentFragment";

    EditText txt_motivo_atencion;
    Button btn_guardar;

    List<MotivoConsultaEnfermeria> motivoConsultaEnfermeriaList;

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
            motivoConsultaEnfermeriaList = MotivoConsultaEnfermeria.find(MotivoConsultaEnfermeria.class, "ID_EMPLEADO = ?",idEmpleado);
        }catch (Exception e){
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

        if(!motivoConsultaEnfermeriaList.isEmpty()) {
            txt_motivo_atencion.setText(motivoConsultaEnfermeriaList.get(0).getContenido());
        }

    }
    private void writeMotivoConsultaEnfermeria() {
        String texto = txt_motivo_atencion.getText().toString();

        MotivoConsultaEnfermeria nuevo_motivo = new MotivoConsultaEnfermeria();
        nuevo_motivo.setIdEmpleado(idEmpleado);
        nuevo_motivo.setContenido(texto);
        nuevo_motivo.save();
        Toast.makeText(getContext(),"Motivo guardado",Toast.LENGTH_LONG).show();
    }
}


