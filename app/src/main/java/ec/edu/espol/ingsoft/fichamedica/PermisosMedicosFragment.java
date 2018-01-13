package ec.edu.espol.ingsoft.fichamedica;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;


public class PermisosMedicosFragment extends AppCompatActivity {
    Switch switch_generar;
    EditText text_permiso_medico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permisos_medicos_fragment);

        switch_generar = (Switch) findViewById(R.id.switchGenerarPermiso);
        text_permiso_medico = (EditText) findViewById(R.id.editText13);
        switch_generar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switch_generar.isChecked()) text_permiso_medico.setEnabled(true);
                else text_permiso_medico.setEnabled(false);
            }
        });
    }
}
