package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ec.edu.espol.ingsoft.fichamedica.R;

public class ConsultaMedicaTabFragment extends Fragment implements ConsultaMedicaMenuFragment.OnItemSelectedListener {

    private static final String TAG = "ConsultaMedicaTabFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.consulta_medica_tab_fragment, container, false);

        if (savedInstanceState == null) {

            // Create a new Fragment to be placed in the activity layout
            ConsultaMedicaMenuFragment sidemenuFragment = new ConsultaMedicaMenuFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            // sidemenuFragment.setArguments(getIntent().getExtras());

            // Agregar la primera vista "Signos Vitales" por defecto
            SignosVitalesContentFragment signosVitalesFragment = new SignosVitalesContentFragment();

            // Agregar el fragmento de contenido al FrameLayout 'content_container'
            getChildFragmentManager().beginTransaction()
                    .add(R.id.sidemenu_container, sidemenuFragment)
                    .add(R.id.content_container, signosVitalesFragment)
                    .commit();
        }

        return view;
    }

    @Override
    public void onItemSelected(int type) {
        Fragment fragment = null;

        if (type == 1) {
            fragment = new SignosVitalesContentFragment();
        } else if (type == 2) {
            fragment = new RevisionMedicaContentFragment();
        } else if (type == 3) {
            fragment = new ExamenFisicoContentFragment();
        }else if (type ==4) {
            fragment = new Fragment_diagnostico();
        }else if (type == 5) {
            fragment = new Fragment_prescripcion();
        } else if (type == 6) {
            fragment = new PermisoMedicoContentFragment();
        } else {
            return;
        }

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.content_container, fragment);
        transaction.addToBackStack(null);

        // Hacer commit a la transacción
        transaction.commit();
    }
}