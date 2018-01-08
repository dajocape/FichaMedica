package ec.edu.espol.ingsoft.fichamedica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;

public class DiagnosticoNuevoActivity extends AppCompatActivity {

    ListView visualizadorLista;
    AutoCompleteTextView buscador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico_nuevo);

        Enfermedad enfermedades_data[] =new Enfermedad[]{
                new Enfermedad("Viruela","C01"),
                new Enfermedad("Gripe","C02"),
                new Enfermedad("Diarrea","C03"),
                new Enfermedad("Infeccion","C04"),
                new Enfermedad("Hepatitis","C05"),
                new Enfermedad("Rubiola","C06"),
                new Enfermedad("Diabetis","C07"),
                new Enfermedad("Tos","C08"),
                new Enfermedad("Sarpullido","C09"),
                new Enfermedad("Demencia","C10")
        };

        EnfermedadesAdapter adapter = new EnfermedadesAdapter(this,R.layout.listview_item_row_enfermedad,enfermedades_data);

        visualizadorLista = (ListView) findViewById(R.id.lista);

        View header = (View)getLayoutInflater().inflate(R.layout.listview_header_row_enfermedad,null);
        visualizadorLista.addHeaderView(header);
        visualizadorLista.setAdapter(adapter);


        buscador = (AutoCompleteTextView) findViewById(R.id.search);


        visualizadorLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView v =(TextView)view.findViewById(R.id.tvNombre);
                buscador.setText(v.getText());
            }
        });
    }
}
