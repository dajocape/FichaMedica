package ec.edu.espol.ingsoft.fichamedica;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ec.edu.espol.ingsoft.fichamedica.utilidades.Utilidades;

public class DiagnosticoNuevoActivity extends AppCompatActivity {

    ListView visualizadorLista;
    AutoCompleteTextView buscador;
    ArrayList<Enfermedad> enfermedadesList;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico_nuevo);

        conn = new ConexionSQLiteHelper(this,"bd_historial_medico",null,1);

        llenarListaEnfermedades();

        EnfermedadesAdapter adapter = new EnfermedadesAdapter(this,R.layout.listview_item_row_enfermedad,enfermedadesList);

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

    private void llenarListaEnfermedades() {

        SQLiteDatabase db=conn.getReadableDatabase();

        Enfermedad enfermedad=null;

        enfermedadesList = new ArrayList<Enfermedad>();

        //select * from Usuarios

        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_ENFERMEDAD,null);

        while(cursor.moveToNext()){
            enfermedad= new Enfermedad();
            enfermedad.setNombre(cursor.getString(0));
            enfermedad.setCodigo(cursor.getString(1));

            enfermedadesList.add(enfermedad);
        }


    }
}
