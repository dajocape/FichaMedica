package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.reporte_medico;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ec.edu.espol.ingsoft.fichamedica.R;

public class ReporteMedicoTabFragment extends Fragment {

    private static final String TAG = "ReporteMedicoTabFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater .inflate(R.layout.reporte_medico_tab_fragment,container,false);

        return view;
    }
}
