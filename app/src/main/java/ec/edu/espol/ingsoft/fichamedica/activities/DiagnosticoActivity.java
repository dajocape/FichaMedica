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

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico);

        conn = new ConexionSQLiteHelper(this,Utilidades.NOMBRE_BASE,null,1);

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
        SQLiteDatabase db=conn.getReadableDatabase();

        Diagnostico diagnostico = null;

        diagnosticosList = new ArrayList<Diagnostico>();

        try{
            //select * from Diagnosticos
            Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_DIAGNOSTICO,null);

            while(cursor.moveToNext()){
                diagnostico= new Diagnostico();
                diagnostico.setEnfermedad(cursor.getString(0));
                diagnostico.setCodigo(cursor.getString(1));
                diagnostico.setTipoEnfermedad(cursor.getString(2));
                diagnosticosList.add(diagnostico);
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();

        }



    }
}
