package ec.edu.espol.ingsoft.fichamedica;

/**
 * Created by Renato on 09/01/2018.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class AntecedentesPatologicosFamiliares extends AppCompatActivity{

    private ListView lvMiListaAntecedentesFamiliares;
    private AdapterAntecedentesPatologicosFamiliares adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.antecedentes_patologicos_familiares);

        lvMiListaAntecedentesFamiliares = (ListView) findViewById(R.id.lvMiListaAntecedentesPatologicosFamiliares);
        adaptador = new AdapterAntecedentesPatologicosFamiliares(this, getArrayItems());
        lvMiListaAntecedentesFamiliares.setAdapter(adaptador);
    }

    private ArrayList<EntidadAntecedentesPatologicosFamiliares> getArrayItems(){
        ArrayList<EntidadAntecedentesPatologicosFamiliares> listItems = new ArrayList<>();
        listItems.add(new EntidadAntecedentesPatologicosFamiliares("Padre","Hipertenso"));
        listItems.add(new EntidadAntecedentesPatologicosFamiliares("Madre","Hipertenso"));
        listItems.add(new EntidadAntecedentesPatologicosFamiliares("Abuelo","Cancer"));
        listItems.add(new EntidadAntecedentesPatologicosFamiliares("Abuela","Cancer"));
        return listItems;
    }
}
