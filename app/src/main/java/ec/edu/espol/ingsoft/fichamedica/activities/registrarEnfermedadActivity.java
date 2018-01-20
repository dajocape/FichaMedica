package ec.edu.espol.ingsoft.fichamedica.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.orm.SugarRecord;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica.Fragment_diagnostico;
import ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica.Fragment_diagnosticoNuevo;
import ec.edu.espol.ingsoft.fichamedica.model.Enfermedad;

public class registrarEnfermedadActivity extends AppCompatActivity {

    EditText nombre;
    EditText codigo;
    Button guardar;
    Button irDiagnosticoNuevo;
    Button irDiagnosticos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_enfermedad);

        nombre = (EditText) findViewById(R.id.etEnfermedad);
        codigo = (EditText) findViewById(R.id.etCodigo);
        guardar = (Button)findViewById(R.id.btnGuardarEnfermedad);
        irDiagnosticoNuevo = (Button)findViewById(R.id.btnIr);
        irDiagnosticos= (Button)findViewById(R.id.btnIrDiagnosticos);

        irDiagnosticoNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irDiagnosticoNuevo(view);
            }
        });

        irDiagnosticos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irDiagnostico(view);
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarEnfermedad();
            }
        });
    }

    public void guardarEnfermedad(){
        Enfermedad nueva_enfermedad = new Enfermedad();
        nueva_enfermedad.setNombre(nombre.getText().toString());
        nueva_enfermedad.setCodigo(codigo.getText().toString());

        SugarRecord.save(nueva_enfermedad);
    }

    public void irDiagnosticoNuevo(View view) {
        Intent intent = new Intent(this, Fragment_diagnosticoNuevo.class);
        startActivity(intent);
    }

    public void irDiagnostico(View view) {
        Intent intent = new Intent(this, Fragment_diagnostico.class);
        startActivity(intent);
    }
}
