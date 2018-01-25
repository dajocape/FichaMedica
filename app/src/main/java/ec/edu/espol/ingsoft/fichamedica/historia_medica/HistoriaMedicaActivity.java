package ec.edu.espol.ingsoft.fichamedica.historia_medica;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_enfermeria.ConsultaEnfermeriaTabFragment;
import ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.ficha_medica.FichaMedicaTabFragment;
import ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.permisos_medicos.PermisosMedicosTabFragment;
import ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.reporte_medico.ReporteMedicoTabFragment;
import ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.temp_ver_signosvitales.TempVerSignosVitalesTabFragment;
import ec.edu.espol.ingsoft.fichamedica.model.Empleado;
import ec.edu.espol.ingsoft.fichamedica.model.Enfermedad;
import ec.edu.espol.ingsoft.fichamedica.util.EnfermedadesSQL;
import ec.edu.espol.ingsoft.fichamedica.util.NonScrollableViewPager;
import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.util.SectionsPageAdapter;
import ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica.ConsultaMedicaTabFragment;

public class HistoriaMedicaActivity extends AppCompatActivity {

    public Empleado empleado;

    private static final String TAG = "HistoriaMedicaActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    private NonScrollableViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia_medica);
        Log.d(TAG, "onCreate: Starting.");
        llenarEnfermedades();

        //crearEmpleado("0963518975");
        //empleado = buscarEmpleado("0963518975");

        crearEmpleado("0987456321");
        empleado = buscarEmpleado("0987456321");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public Empleado buscarEmpleado(String cedulaEmpleado){
        List<Empleado> empleado = Empleado.find(Empleado.class, "cedula = ?",cedulaEmpleado);

        if(!empleado.isEmpty()){
            return empleado.get(0);
        }else{
            return null;
        }
    }

    public void crearEmpleado(String cedula){//Funcion temporal para crear un empleado vacio en la base de datos, luego modificar.
        Empleado nuevo_empleado = new Empleado();
        nuevo_empleado.setCedula(cedula);
        try{
            nuevo_empleado.save();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void llenarEnfermedades(){
        List<Enfermedad> enfermedades = Enfermedad.find(Enfermedad.class, "CODIGO = ?","A00");

        if(enfermedades.isEmpty()){
            try{
                Toast.makeText(getApplicationContext(),"Llenando Enfermedades",Toast.LENGTH_LONG).show();
                Enfermedad.executeQuery(EnfermedadesSQL.REGISTRO_ENFERMEDADES);
            }catch(Exception e){
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
    }

    private void setupViewPager(ViewPager viewPager){
        ConsultaMedicaTabFragment consulta = new ConsultaMedicaTabFragment();
        Bundle bun = new Bundle();
        bun.putString("idEmpleado",empleado.getCedula());
        consulta.setArguments(bun);

        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FichaMedicaTabFragment(), "Ficha Medica");
        adapter.addFragment(consulta, "Consulta Medica");
        adapter.addFragment(new ConsultaEnfermeriaTabFragment(), "Consulta Enfermeria");
        adapter.addFragment(new PermisosMedicosTabFragment(), "Permisos Medicos");
        adapter.addFragment(new ReporteMedicoTabFragment(), "Reporte Medico");
        adapter.addFragment(new TempVerSignosVitalesTabFragment(), "Ver Signos Vitales");
        viewPager.setAdapter(adapter);
    }
}