package ec.edu.espol.ingsoft.fichamedica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class DiagnosticoActivity extends AppCompatActivity {

    ListView visualizadorLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico);

        Diagnostico diagnosticos_data[] = new Diagnostico[]{
                new Diagnostico("Gripe","C01","RES"),
                new Diagnostico("Fiebre","C03","RES"),
                new Diagnostico("Cancer","C02","RES"),
                new Diagnostico("Polio","C05","DEF"),
                new Diagnostico("Osteoporosis","C06","RES"),
                new Diagnostico("Varicela","C08","RES"),
                new Diagnostico("Estupides","C09","DEF")

        };

        DiagnosticosAdapter adapter = new DiagnosticosAdapter(this,R.layout.listview_item_row_diagnosticos,diagnosticos_data);

        visualizadorLista = (ListView) findViewById(R.id.lista);
        visualizadorLista.setAdapter(adapter);

    }

    public void ingresarDiagnostico(View view) {
        Intent intent = new Intent(this, DiagnosticoNuevoActivity.class);
        startActivity(intent);
    }
}
