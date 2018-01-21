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
import ec.edu.espol.ingsoft.fichamedica.model.PlanCuidadosEnfermeria;
import ec.edu.espol.ingsoft.fichamedica.model.SignosVitales;

public class PlanCuidadosEnfermeriaContentFragment extends Fragment {

    private static final String TAG = "SignosVitalesContentFragment";
    EditText txt_plan_cuidados;
    Button btn_guardar;
    List<PlanCuidadosEnfermeria> planCuidadosEnfermeria;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plan_de_cuidados_enfermeria_content_fragment, container, false);

        txt_plan_cuidados= view.findViewById(R.id.txt_plan_cuidados);
        btn_guardar =     view.findViewById(R.id.btn_guardar);

        readPlanCuidadosEnfermeria();

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writePlanCuidadosEnfermeria();
            }
        });

        return view;
    }

    public void readPlanCuidadosEnfermeria(){
        planCuidadosEnfermeria = PlanCuidadosEnfermeria.listAll(PlanCuidadosEnfermeria.class);
        if(!planCuidadosEnfermeria.isEmpty()) {
            txt_plan_cuidados.setText(planCuidadosEnfermeria.get(planCuidadosEnfermeria.size()-1).getContenido());
        }
    }

    public void writePlanCuidadosEnfermeria(){
        PlanCuidadosEnfermeria nuevo_planCuidadosEnfermeria = new PlanCuidadosEnfermeria();

        String texto = txt_plan_cuidados.getText().toString();

        if(!texto.isEmpty()){
            nuevo_planCuidadosEnfermeria.setContenido(texto);
            try{
                nuevo_planCuidadosEnfermeria.save();
                Toast.makeText(getContext(),"Plan Guardado",Toast.LENGTH_SHORT).show();
            }catch(Exception e){
                Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getContext(),"No se guardo nada porque no se escribio nada",Toast.LENGTH_LONG).show();
        }
    }
}
