package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.temp_ver_signosvitales;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.SignosVitales;

public class TempVerSignosVitalesTabFragment extends Fragment {

    private static final String TAG = "VerSignosVitalesTabFragment";

    ListView lstViewSignosVitales;
    List<SignosVitales> listaSignosVitales;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ver_signos_vitales_fragment, container, false);

        lstViewSignosVitales = view.findViewById(R.id.lst_signos_vitales);
        cargarSignos();

        return view;
    }

    public void cargarSignos(){
        listaSignosVitales = SignosVitales.listAll(SignosVitales.class);

        String[] signosVitales = new String[listaSignosVitales.size()];
        for (int i=0;i<listaSignosVitales.size();i++){
            SignosVitales signo = listaSignosVitales.get(i);
            signosVitales[i]= "Id: " + signo.getId() + "\nPresion arterial: " + signo.getPresion_arterial() + "\nFrecuencia Cardiaca: " +signo.getFrecuencia_cardiaca()
                    + "\nFrecuencia Respiratoria: " + signo.getFrecuencia_respiratoria() + "\nTalla: " + signo.getTalla() + "\nPeso: " + signo.getPeso()
                    + "\nIMC: " + signo.getIMC() + "\nTemperatura: " + signo.getTemperatura();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,signosVitales);
        lstViewSignosVitales.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        cargarSignos();
    }
}