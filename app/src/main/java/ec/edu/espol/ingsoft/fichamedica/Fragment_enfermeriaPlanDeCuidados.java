package ec.edu.espol.ingsoft.fichamedica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ec.edu.espol.ingsoft.fichamedica.model.PlanCuidadosEnfermeria;

public class Fragment_enfermeriaPlanDeCuidados extends AppCompatActivity {

    EditText contenido;
    Button guardar;
    List<PlanCuidadosEnfermeria> planCuidadosEnfermeria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_enfermeria_plan_de_cuidados);

        contenido = (EditText) findViewById(R.id.etPlanEnferContenido);
        guardar = (Button)findViewById(R.id.btnPlanEnferGuardar);

        readPlanCuidadosEnfermeria();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writePlanCuidadosEnfermeria();
            }
        });
    }

    public void readPlanCuidadosEnfermeria(){
        planCuidadosEnfermeria = PlanCuidadosEnfermeria.listAll(PlanCuidadosEnfermeria.class);

        if(!planCuidadosEnfermeria.isEmpty()) {
            contenido.setText(planCuidadosEnfermeria.get(planCuidadosEnfermeria.size()-1).getContenido());
        }
    }

    public void writePlanCuidadosEnfermeria(){
        PlanCuidadosEnfermeria nuevo_planCuidadosEnfermeria = new PlanCuidadosEnfermeria();

        String texto = contenido.getText().toString();

        if(!texto.isEmpty()){
            nuevo_planCuidadosEnfermeria.setContenido(texto);
            try{
                nuevo_planCuidadosEnfermeria.save();
            }catch(Exception e){
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),"No se guardo nada porque no se escribio nada",Toast.LENGTH_LONG).show();
        }
    }
}
