package ec.edu.espol.ingsoft.fichamedica.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ec.edu.espol.ingsoft.fichamedica.util.ConexionSQLiteHelper;
import ec.edu.espol.ingsoft.fichamedica.adapter.DiagnosticosAdapter;
import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.Diagnostico;
import ec.edu.espol.ingsoft.fichamedica.util.Utilidades;

public class DiagnosticoActivity extends AppCompatActivity {

    ListView visualizadorLista;
    ArrayList<Diagnostico> diagnosticosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico);

        llenarListaDiagnosticos();

        DiagnosticosAdapter adapter = new DiagnosticosAdapter(this,R.layout.listview_item_row_diagnosticos,diagnosticosList);

        visualizadorLista = (ListView) findViewById(R.id.lista);
        visualizadorLista.setAdapter(adapter);

    }

    public void irDiagnosticoNuevo(View view) {
        Intent intent = new Intent(this, DiagnosticoNuevoActivity.class);
        startActivity(intent);
    }

    private void llenarListaDiagnosticos() {
       diagnosticosList = (ArrayList<Diagnostico>) Diagnostico.listAll(Diagnostico.class);

    }
}
