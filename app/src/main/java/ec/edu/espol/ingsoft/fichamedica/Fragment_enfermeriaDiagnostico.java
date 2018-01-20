package ec.edu.espol.ingsoft.fichamedica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ec.edu.espol.ingsoft.fichamedica.model.DiagnosticoEnfermeria;

public class Fragment_enfermeriaDiagnostico extends AppCompatActivity {

    EditText contenido;
    Button guardar;
    List<DiagnosticoEnfermeria> diagnosticoEnfermeria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_enfermeria_diagnostico);

        contenido = (EditText) findViewById(R.id.etDiagEnferContenido);
        guardar = (Button)findViewById(R.id.btnDiagEnferGuardar);

        readDiagnosticoEnfermeria();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeDiagnosticoEnfermeria();
            }
        });
    }

    public void readDiagnosticoEnfermeria(){
        diagnosticoEnfermeria = DiagnosticoEnfermeria.listAll(DiagnosticoEnfermeria.class);

        if(!diagnosticoEnfermeria.isEmpty()) {
            contenido.setText(diagnosticoEnfermeria.get(diagnosticoEnfermeria.size()-1).getContenido());
        }
    }

    public void writeDiagnosticoEnfermeria(){
        DiagnosticoEnfermeria nuevo_diagnostico = new DiagnosticoEnfermeria();

        String texto = contenido.getText().toString();

        if(!texto.isEmpty()){
            nuevo_diagnostico.setContenido(texto);
            try{
                nuevo_diagnostico.save();
            }catch(Exception e){
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),"No se guardo nada porque no se escribio nada",Toast.LENGTH_LONG).show();
        }
    }
}
