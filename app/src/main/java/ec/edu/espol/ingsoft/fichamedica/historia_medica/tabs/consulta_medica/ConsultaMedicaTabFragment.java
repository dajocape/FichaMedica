package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ec.edu.espol.ingsoft.fichamedica.R;

public class ConsultaMedicaTabFragment extends Fragment implements ConsultaMedicaMenuFragment.OnItemSelectedListener {
    String idEmpleado;
    Bundle bun;
    private static final String TAG = "ConsultaMedicaTabFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.consulta_medica_tab_fragment, container, false);
        idEmpleado = getArguments().getString("idEmpleado");
        Toast.makeText(getContext(),"Cedula: "+idEmpleado,Toast.LENGTH_SHORT).show();
        bun = new Bundle();
        bun.putString("idEmpleado",idEmpleado);

        // Create a new Fragment to be placed in the activity layout
        ConsultaMedicaMenuFragment sidemenuFragment = new ConsultaMedicaMenuFragment();

        // Agregar la primera vista "Signos Vitales" por defecto
        //SignosVitalesContentFragment signosVitalesFragment = new SignosVitalesContentFragment();
        //sidemenuFragment.setArguments(bun);

        // Agregar el fragmento de contenido al FrameLayout 'content_container'
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.sidemenu_container, sidemenuFragment);
        //transaction.replace(R.id.content_container, signosVitalesFragment);
        transaction.commit();

        return view;
    }

    @Override
    public void onItemSelected(int type) {
        Fragment fragment = null;

        if (type == 1) {
            fragment = new SignosVitalesContentFragment();
            fragment.setArguments(bun);
        } else if (type == 2) {
            fragment = new RevisionMedicaContentFragment();
            fragment.setArguments(bun);
        } else if (type == 3) {
            fragment = new ExamenFisicoContentFragment();
            fragment.setArguments(bun);
        } else if (type == 4) {
            fragment = new DiagnosticoContentFragment();
            fragment.setArguments(bun);
        } else if (type == 5) {
            fragment = new PrescripcionContentFragment();
            fragment.setArguments(bun);
        } else if (type == 6) {
            fragment = new PermisoMedicoContentFragment();
            fragment.setArguments(bun);
        } else if (type == 7) {
            fragment = new AnexarContentFragment();
            fragment.setArguments(bun);
        } else if (type == 8) {
            fragment = new AntecedentesPatologicosPersonalesFragment();
            fragment.setArguments(bun);
        } else if (type == 9) {
            fragment = new AntecedentesPatologicosFamiliaresFragment();
            fragment.setArguments(bun);
        } else {
            return;
        }

        if (fragment != null) {
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_container, fragment);
            transaction.addToBackStack(null);
            // Hacer commit a la transacción
            transaction.commit();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


}