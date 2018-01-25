package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_enfermeria;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ec.edu.espol.ingsoft.fichamedica.R;

public class ConsultaEnfermeriaTabFragment extends Fragment implements ConsultaEnfermeriaMenuFragment.OnItemSelectedListener {
    String idEmpleado;
    Bundle bun;
    private static final String TAG = "ConsultaEnfermeriaTabFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.consulta_medica_tab_fragment, container, false);
        idEmpleado = getArguments().getString("idEmpleado");
        bun = new Bundle();
        bun.putString("idEmpleado",idEmpleado);

        // Create a new Fragment to be placed in the activity layout
        ConsultaEnfermeriaMenuFragment sidemenuFragment = new ConsultaEnfermeriaMenuFragment();

        // In case this activity was started with special instructions from an
        // Intent, pass the Intent's extras to the fragment as arguments
        // sidemenuFragment.setArguments(getIntent().getExtras());

        // Agregar la primera vista "Signos Vitales" por defecto
        //SignosVitalesEnfermeriaContentFragment signosVitalesFragment = new SignosVitalesEnfermeriaContentFragment();

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
            fragment = new SignosVitalesEnfermeriaContentFragment();
            fragment.setArguments(bun);
        } else if (type == 2) {
            fragment = new MotivoConsultaEnfermeriaContentFragment();
            fragment.setArguments(bun);
        } else if (type == 3) {
            fragment = new DiagnosticoEnfermeriaContentFragment();
            fragment.setArguments(bun);
        } else if (type == 4) {
            fragment = new PlanCuidadosEnfermeriaContentFragment();
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
}