package ec.edu.espol.ingsoft.fichamedica.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.Prescripcion;

public class PrescripcionActivity extends AppCompatActivity {

    EditText contenido;
    Button guardar;
    List<Prescripcion> prescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescripcion);

        contenido = (EditText) findViewById(R.id.etContenido);
        guardar = (Button)findViewById(R.id.btnGuardar);

        readPrescripcion();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writePrescripcion();
            }
        });
    }

    public void readPrescripcion(){
        prescripcion = Prescripcion.listAll(Prescripcion.class);

        if(!prescripcion.isEmpty()) {
            contenido.setText(prescripcion.get(prescripcion.size()-1).getContenido());
        }else{
            Toast.makeText(getApplicationContext(),"No se cargo porque si hay texto lol",Toast.LENGTH_LONG).show();
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
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),"No se guardo nada porque no se escribio nada",Toast.LENGTH_LONG).show();
        }
    }
}

