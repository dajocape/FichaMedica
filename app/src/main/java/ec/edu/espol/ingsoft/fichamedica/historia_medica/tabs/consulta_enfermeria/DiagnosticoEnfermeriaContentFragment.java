package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_enfermeria;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.DiagnosticoEnfermeria;

public class DiagnosticoEnfermeriaContentFragment extends Fragment {

    private static final String TAG = "DiagnosticoEnfermeriaContentFragment";

    EditText txt_diagnostico;
    Button btn_guardar;
    List<DiagnosticoEnfermeria> diagnosticoEnfermeria;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.diagnostico_enfermeria_content_fragment, container, false);

        txt_diagnostico = view.findViewById(R.id.txt_diagnostico);
        btn_guardar = view.findViewById(R.id.btn_guardar);

        readDiagnosticoEnfermeria();

        btn_guardar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 writeDiagnosticoEnfermeria();
             }
        });

        return view;
    }

    public void readDiagnosticoEnfermeria(){
        diagnosticoEnfermeria = DiagnosticoEnfermeria.listAll(DiagnosticoEnfermeria.class);

        if(!diagnosticoEnfermeria.isEmpty()) {
            txt_diagnostico.setText(diagnosticoEnfermeria.get(diagnosticoEnfermeria.size()-1).getContenido());
        }
    }

    public void writeDiagnosticoEnfermeria(){
        DiagnosticoEnfermeria nuevo_diagnostico = new DiagnosticoEnfermeria();

        String texto = txt_diagnostico.getText().toString();

        if(!texto.isEmpty()){
            nuevo_diagnostico.setContenido(texto);
            try{
                nuevo_diagnostico.save();
                Toast.makeText(getContext(),"Diagnostico Guardado",Toast.LENGTH_SHORT).show();
            }catch(Exception e){
                Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getContext(),"No se ha escrito nada",Toast.LENGTH_LONG).show();
        }
    }
}
