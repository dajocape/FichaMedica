package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_enfermeria;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.ConsultaEnfermeria;
import ec.edu.espol.ingsoft.fichamedica.model.DiagnosticoEnfermeria;

public class DiagnosticoEnfermeriaContentFragment extends Fragment {
    String idEmpleado;
    private static final String TAG = "DiagnosticoEnfermeriaContentFragment";
    EditText txt_diagnostico;
    Button btn_guardar;
    List<DiagnosticoEnfermeria> diagnosticoEnfermeriaList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.diagnostico_enfermeria_content_fragment, container, false);
        idEmpleado = getArguments().getString("idEmpleado");

        txt_diagnostico = view.findViewById(R.id.txt_diagnostico);
        btn_guardar = view.findViewById(R.id.btn_guardar);

        readDiagnosticosEnfermeria();

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeDiagnosticoEnfermeria();
            }
        });
        return view;
    }

    public void readDiagnosticosEnfermeria(){
        try{
            diagnosticoEnfermeriaList = DiagnosticoEnfermeria.find(DiagnosticoEnfermeria.class, "ID_EMPLEADO = ?",idEmpleado);
        }catch (Exception e){
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

        if(!diagnosticoEnfermeriaList.isEmpty()) {
            txt_diagnostico.setText(diagnosticoEnfermeriaList.get(0).getContenido());
        }
    }

    public void writeDiagnosticoEnfermeria(){
        String texto = txt_diagnostico.getText().toString();

        DiagnosticoEnfermeria nuevo_diagnostico = new DiagnosticoEnfermeria();
        nuevo_diagnostico.setIdEmpleado(idEmpleado);
        nuevo_diagnostico.setContenido(texto);
        nuevo_diagnostico.save();
        Toast.makeText(getContext(),"Diagnostico Guardado",Toast.LENGTH_LONG).show();
    }
}
