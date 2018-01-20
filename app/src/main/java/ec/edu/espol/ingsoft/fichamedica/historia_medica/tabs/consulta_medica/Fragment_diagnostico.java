package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import ec.edu.espol.ingsoft.fichamedica.adapter.DiagnosticosAdapter;
import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.Diagnostico;

public class Fragment_diagnostico extends Fragment {

    private static final String TAG = "Fragment_diagnostico";

    ListView visualizadorLista;
    ArrayList<Diagnostico> diagnosticosList;
    Button btnIrDiagnosticoNuevo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diagnostico, container, false);

        llenarListaDiagnosticos();

        DiagnosticosAdapter adapter = new DiagnosticosAdapter(view.getContext(),R.layout.listview_item_row_diagnosticos,diagnosticosList);

        btnIrDiagnosticoNuevo = (Button)view.findViewById(R.id.botonIngreso);
        visualizadorLista = (ListView) view.findViewById(R.id.lista);
        visualizadorLista.setAdapter(adapter);

        btnIrDiagnosticoNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crea el nuevo fragmento y la transacción.
                Fragment nuevoFragmento = new Fragment_diagnosticoNuevo();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_container, nuevoFragmento);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.addToBackStack(null);
                // Commit a la transacción
                transaction.commit();
            }
        });
        return view;
    }

    private void llenarListaDiagnosticos() {
        diagnosticosList = (ArrayList<Diagnostico>) Diagnostico.listAll(Diagnostico.class);
    }
}
