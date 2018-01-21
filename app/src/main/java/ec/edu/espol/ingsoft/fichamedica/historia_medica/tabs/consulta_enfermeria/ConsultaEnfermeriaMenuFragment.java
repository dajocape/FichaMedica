package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_enfermeria;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ec.edu.espol.ingsoft.fichamedica.R;

/**
 * Created by neyck on 1/16/2018.
 */

public class ConsultaEnfermeriaMenuFragment extends Fragment {

    private static final String TAG = "ConsultaEnfermeriaMenuFragment";

    private Button btn_signos_vitales;
    private Button btn_motivo_consulta;
    private Button btn_diagnostico;
    private Button btn_plan_cuidados;

    OnItemSelectedListener mCallback;

    public interface OnItemSelectedListener {
        public void onItemSelected(int type);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Se asegura que la actividad/fragmento contenedora implemente la interface de callback
        // Caso contrario lanza una excepcion.
        try {
            mCallback = (OnItemSelectedListener) getParentFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnArticleSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.consulta_enfermeria_menu_fragment, container, false);

        btn_signos_vitales = view.findViewById(R.id.btn_signos_vitales);
        btn_motivo_consulta = view.findViewById(R.id.btn_motivo_consulta);
        btn_diagnostico = view.findViewById(R.id.btn_diagnostico);
        btn_plan_cuidados = view.findViewById(R.id.btn_plan_cuidados);

        btn_signos_vitales.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCallback.onItemSelected(1);
            }
        });

        btn_motivo_consulta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCallback.onItemSelected(2);
            }
        });

        btn_diagnostico.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCallback.onItemSelected(3);
            }
        });

        btn_plan_cuidados.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCallback.onItemSelected(4);
            }
        });

        return view;
    }

}
