package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import ec.edu.espol.ingsoft.fichamedica.model.Diagnostico;
import ec.edu.espol.ingsoft.fichamedica.adapter.EnfermedadesAdapter;
import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.Enfermedad;

public class DiagnosticoNuevoContentFragment extends Fragment {

    private static final String TAG = "DiagnosticoNuevoContentFragment";

    ListView visualizadorLista;
    AutoCompleteTextView buscador;
    RadioButton pres,def;
    Button guardar;

    ArrayList<Enfermedad> enfermedadesList;
    String enfermedad;
    String codigo;
    String tipoEnfermedad;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.diagnostico_nuevo_fragment, container, false);

        pres = (RadioButton)view.findViewById(R.id.rbPres);
        def  = (RadioButton)view.findViewById(R.id.rbDef);
        guardar=(Button)view.findViewById(R.id.btnRegistrarDiagnostico);

        llenarListaEnfermedades();

        EnfermedadesAdapter adapter = new EnfermedadesAdapter(view.getContext(),R.layout.listview_item_row_enfermedad,enfermedadesList);

        visualizadorLista = (ListView) view.findViewById(R.id.lista);

        visualizadorLista.setAdapter(adapter);

        buscador = (AutoCompleteTextView) view.findViewById(R.id.search);

        visualizadorLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView name =(TextView)view.findViewById(R.id.tvNombre);//Esto se saca del activity item row Enfermedad
                TextView code =(TextView)view.findViewById(R.id.tvCodigo);//Esto se saca del activity item row Enfermedad

                if(name!=null & code!=null){
                    buscador.setText(name.getText());
                    enfermedad = name.getText().toString();
                    codigo = code.getText().toString();
                }

            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                registrarDiagnostico();
            }
        });
        return view;
    }

    public void irDiagnostico(View view) {
        Intent intent = new Intent(view.getContext(), DiagnosticoContentFragment.class); //Esto da error
        startActivity(intent);

    }

    public void registrarDiagnostico(){
        if (pres.isChecked()){
            tipoEnfermedad = pres.getText().toString();
            writeDiagnostico();
        }else if(def.isChecked()){
            tipoEnfermedad = def.getText().toString();
            writeDiagnostico();
        }else{
            //Toast.makeText(getApplicationContext(),"Debe seleccionar un tipo de Enfermedad",Toast.LENGTH_SHORT).show();
        }
    }

    private void writeDiagnostico(){
        Diagnostico nuevo_diagnostico = new Diagnostico();
        nuevo_diagnostico.setEnfermedad(enfermedad);
        nuevo_diagnostico.setCodigo(codigo);
        nuevo_diagnostico.setTipoEnfermedad(tipoEnfermedad);

        try{
            nuevo_diagnostico.save();
            //Toast.makeText(getApplicationContext(),"Diagnostico Guardado",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            //Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void llenarListaEnfermedades() {
        enfermedadesList = (ArrayList<Enfermedad>) Enfermedad.listAll(Enfermedad.class);
    }
}
