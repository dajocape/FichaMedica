package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ec.edu.espol.ingsoft.fichamedica.R;

public class RevisionMedicaFragment extends Fragment {

    private static final String TAG = "RevisionMedicaFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.revision_medica_fragment, container, false);

        return view;
    }
}