package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v4.app.Fragment;

import ec.edu.espol.ingsoft.fichamedica.R;

/**
 * Created by neyck on 1/16/2018.
 */

public class ConsultaMedicaMenuFragment extends Fragment {

    private Button btn_signos_vitales;
    private Button btn_revision_medica;
    private Button btn_examen_fisico;
    private Button btn_diagnostico;
    private Button btn_prescripcion;
    private Button btn_permisos;
    private Button btn_subir_archivo;

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
        View view = inflater.inflate(R.layout.consulta_medica_menu_fragment, container, false);

        btn_signos_vitales = view.findViewById(R.id.btn_signos_vitales);
        btn_revision_medica = view.findViewById(R.id.btn_revision_medica);
        btn_examen_fisico = view.findViewById(R.id.btn_examen_fisico);
        btn_diagnostico = view.findViewById(R.id.btn_diagnostico);
        btn_prescripcion = view.findViewById(R.id.btn_prescripcion);
        btn_permisos = view.findViewById(R.id.btn_permisos);
        btn_subir_archivo = view.findViewById(R.id.btn_subir_archivo);

        btn_signos_vitales.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCallback.onItemSelected(1);
            }
        });

        btn_revision_medica.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCallback.onItemSelected(2);
            }
        });

        btn_examen_fisico.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCallback.onItemSelected(3);
            }
        });

        btn_diagnostico.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCallback.onItemSelected(4);
            }
        });

        btn_prescripcion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCallback.onItemSelected(5);
            }
        });

        btn_permisos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCallback.onItemSelected(6);
            }
        });

        btn_subir_archivo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCallback.onItemSelected(7);
            }
        });
        return view;
    }

}
