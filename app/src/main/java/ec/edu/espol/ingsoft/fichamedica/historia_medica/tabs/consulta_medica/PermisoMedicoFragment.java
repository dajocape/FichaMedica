package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import ec.edu.espol.ingsoft.fichamedica.R;


public class PermisoMedicoFragment extends Fragment {

    Switch switch_generar;
    EditText text_permiso_medico;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.permiso_medico_fragment, container, false);

        switch_generar = view.findViewById(R.id.switchGenerarPermiso);
        text_permiso_medico = view.findViewById(R.id.editText13);

        switch_generar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (switch_generar.isChecked()) text_permiso_medico.setEnabled(true);
                else text_permiso_medico.setEnabled(false);
            }
        });
        return view;
    }
}
