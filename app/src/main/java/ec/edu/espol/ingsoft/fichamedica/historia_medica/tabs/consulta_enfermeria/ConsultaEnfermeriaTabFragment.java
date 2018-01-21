package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_enfermeria;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica.Fragment_diagnostico;
import ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica.RevisionMedicaContentFragment;

public class ConsultaEnfermeriaTabFragment extends Fragment implements ConsultaEnfermeriaMenuFragment.OnItemSelectedListener {

    private static final String TAG = "ConsultaEnfermeriaTabFragment";

    private static boolean inicializado = false;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.consulta_medica_tab_fragment, container, false);

        if (savedInstanceState == null && !inicializado) {

            // Create a new Fragment to be placed in the activity layout
            ConsultaEnfermeriaMenuFragment sidemenuFragment = new ConsultaEnfermeriaMenuFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            // sidemenuFragment.setArguments(getIntent().getExtras());

            // Agregar la primera vista "Signos Vitales" por defecto
            SignosVitalesEnfermeriaContentFragment signosVitalesFragment = new SignosVitalesEnfermeriaContentFragment();

            // Agregar el fragmento de contenido al FrameLayout 'content_container'
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(R.id.sidemenu_container, sidemenuFragment);
            transaction.replace(R.id.content_container, signosVitalesFragment);
            transaction.commit();

            inicializado = true;

        }

        return view;
    }

    @Override
    public void onItemSelected(int type) {
        Fragment fragment = null;

        if (type == 1) {
            fragment = new SignosVitalesEnfermeriaContentFragment();
        } else if (type == 2) {
            fragment = new MotivoConsultaEnfermeriaContentFragment();
        } else if (type == 3) {
//            fragment = new ExamenFisicoContentFragment();
        } else if (type == 4) {
            fragment = new PlanCuidadosEnfermeriaContentFragment();
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
        inicializado = false;
        super.onStop();
    }
}