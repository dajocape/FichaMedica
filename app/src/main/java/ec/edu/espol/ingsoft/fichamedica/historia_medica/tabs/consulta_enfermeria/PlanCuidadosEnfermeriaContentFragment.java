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

public class PlanCuidadosEnfermeriaContentFragment extends Fragment {
    String idEmpleado;
    private static final String TAG = "SignosVitalesContentFragment";
    EditText txt_plan_cuidados;
    Button btn_guardar;
    List<ConsultaEnfermeria> consultaEnfermeriaList;

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
            consultaEnfermeriaList = ConsultaEnfermeria.findWithQuery(ConsultaEnfermeria.class,"Select * from CONSULTA_ENFERMERIA where ID_EMPLEADO = ?;",idEmpleado);
        }catch (Exception e){
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

        if(!consultaEnfermeriaList.isEmpty()) {
            txt_plan_cuidados.setText(consultaEnfermeriaList.get(0).getPlan_cuidados());
        }
    }

    public void writePlanCuidadosEnfermeria(){
        String texto = txt_plan_cuidados.getText().toString();
        ConsultaEnfermeria consulta;

        try{
            consultaEnfermeriaList = ConsultaEnfermeria.findWithQuery(ConsultaEnfermeria.class,"Select * from CONSULTA_ENFERMERIA where ID_EMPLEADO = ?;",idEmpleado);
            if(consultaEnfermeriaList.isEmpty()){
                consulta = new ConsultaEnfermeria();
                consulta.setIdEmpleado(idEmpleado);
                consulta.setPlan_cuidados(texto);
                consulta.save();
            }else{
                consulta = consultaEnfermeriaList.get(0);
                consulta.setPlan_cuidados(texto);
                consulta.save();
            }
        }catch (Exception e){
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
