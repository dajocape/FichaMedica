package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.adapter.AntecedentesPatologicosPersonalesAdapter;
import ec.edu.espol.ingsoft.fichamedica.model.AntecedentesPatologicosPersonales;

/**
 * Created by Renato on 21/01/2018.
 */

public class AntecedentesPatologicosPersonalesFragment extends android.support.v4.app.Fragment {
    String idEmpleado;
    private static final String TAG = "AntecedentesPatologicosPersonalesFragment";
    private ListView lvMiListaAntecedentesPersonales;
    private AntecedentesPatologicosPersonalesAdapter adaptador;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.antecedentes_patologicos_personales_content_fragment, container, false);
        idEmpleado = getArguments().getString("idEmpleado");
        //Toast.makeText(getContext(),idEmpleado,Toast.LENGTH_SHORT).show();

        lvMiListaAntecedentesPersonales = (ListView) view.findViewById(R.id.lvMiListaAntecedentesPatologicosPersonales);
        adaptador = new AntecedentesPatologicosPersonalesAdapter(view.getContext(), R.layout.antecedentes_patologicos_familiarespersonales_items,getArrayItems());
        lvMiListaAntecedentesPersonales.setAdapter(adaptador);
        return view;
    }

    private ArrayList<AntecedentesPatologicosPersonales> getArrayItems(){
        ArrayList<AntecedentesPatologicosPersonales> listItems = new ArrayList<>();
        listItems.add(new AntecedentesPatologicosPersonales("","Sistema Nervioso", "El sistema nervioso"));
        listItems.add(new AntecedentesPatologicosPersonales("","Renales", "Calculos Renales en el rinon izquierdo"));
        listItems.add(new AntecedentesPatologicosPersonales("","Musculares", "Distension muscular en ...")); return listItems;
    }
}
