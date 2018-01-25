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
import ec.edu.espol.ingsoft.fichamedica.model.PlanCuidadosEnfermeria;

public class PlanCuidadosEnfermeriaContentFragment extends Fragment {
    String idEmpleado;
    private static final String TAG = "SignosVitalesContentFragment";
    EditText txt_plan_cuidados;
    Button btn_guardar;
    List<PlanCuidadosEnfermeria> planCuidadosEnfermeriaList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plan_de_cuidados_enfermeria_content_fragment, container, false);
        idEmpleado = getArguments().getString("idEmpleado");
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
        try{
            planCuidadosEnfermeriaList = PlanCuidadosEnfermeria.find(PlanCuidadosEnfermeria.class, "ID_EMPLEADO = ?",idEmpleado);
        }catch (Exception e){
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

        if(!planCuidadosEnfermeriaList.isEmpty()) {
            txt_plan_cuidados.setText(planCuidadosEnfermeriaList.get(0).getContenido());
        }
    }

    public void writePlanCuidadosEnfermeria(){
        String texto = txt_plan_cuidados.getText().toString();

        PlanCuidadosEnfermeria nuevo_plan = new PlanCuidadosEnfermeria();
        nuevo_plan.setIdEmpleado(idEmpleado);
        nuevo_plan.setContenido(texto);
        nuevo_plan.save();
        Toast.makeText(getContext(),"Plan de enfermeria guardado",Toast.LENGTH_LONG).show();
    }
}
