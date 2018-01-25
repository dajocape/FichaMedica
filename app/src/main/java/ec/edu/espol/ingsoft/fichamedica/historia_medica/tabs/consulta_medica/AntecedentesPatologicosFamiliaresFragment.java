package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.adapter.AntecedentesPatologicosFamiliaresAdapter;
import ec.edu.espol.ingsoft.fichamedica.model.AntecedentesPatologicosFamiliares;

/**
 * Created by Renato on 20/01/2018.
 */

public class AntecedentesPatologicosFamiliaresFragment extends Fragment {
    String idEmpleado;
    private static final String TAG = "AntecedentesPatologicosFamiliaresFragment";
    private ListView lvMiListaAntecedentesFamiliares;
    private AntecedentesPatologicosFamiliaresAdapter adaptador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.antecedentes_patologicos_familiares_content_fragment, container, false);
        idEmpleado = getArguments().getString("idEmpleado");
        //Toast.makeText(getContext(),idEmpleado,Toast.LENGTH_SHORT).show();

        lvMiListaAntecedentesFamiliares = (ListView) view.findViewById(R.id.lvMiListaAntecedentesPatologicosFamiliares);
        adaptador = new AntecedentesPatologicosFamiliaresAdapter(view.getContext(), R.layout.antecedentes_patologicos_familiarespersonales_items,getArrayItems());
        lvMiListaAntecedentesFamiliares.setAdapter(adaptador);
        return view;
    }

    private ArrayList<AntecedentesPatologicosFamiliares> getArrayItems(){
        ArrayList<AntecedentesPatologicosFamiliares> listItems = new ArrayList<>();
        listItems.add(new AntecedentesPatologicosFamiliares("","Padre","Hipertenso"));
        listItems.add(new AntecedentesPatologicosFamiliares("","Madre","Hipertenso"));
        listItems.add(new AntecedentesPatologicosFamiliares("","Abuelo","Cancer"));
        listItems.add(new AntecedentesPatologicosFamiliares("","Abuela","Cancer"));
        return listItems;
    }

}
