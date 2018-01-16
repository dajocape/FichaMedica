package ec.edu.espol.ingsoft.fichamedica.historia_medica;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ec.edu.espol.ingsoft.fichamedica.util.NonScrollableViewPager;
import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.util.SectionsPageAdapter;
import ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica.ConsultaMedicaFragment;
import ec.edu.espol.ingsoft.fichamedica.FichaMedicaFragment;
import ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica.PermisoMedicoFragment;

public class HistoriaMedicaActivity extends AppCompatActivity {

    private static final String TAG = "HistoriaMedicaActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    private NonScrollableViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia_medica);
        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FichaMedicaFragment(), "Ficha Medica");
        adapter.addFragment(new ConsultaMedicaFragment(), "Consulta Medica");
        //adapter.addFragment(new PermisoMedicoFragment(), "Permisos Medicos");
        adapter.addFragment(new ReporteMedicoFragment(), "Reporte Medico");
        viewPager.setAdapter(adapter);
    }
}