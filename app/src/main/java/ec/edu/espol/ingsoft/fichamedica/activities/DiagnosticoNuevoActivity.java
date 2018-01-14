package ec.edu.espol.ingsoft.fichamedica.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ec.edu.espol.ingsoft.fichamedica.utilidades.ConexionSQLiteHelper;
import ec.edu.espol.ingsoft.fichamedica.adapters.EnfermedadesAdapter;
import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.entidades.Enfermedad;
import ec.edu.espol.ingsoft.fichamedica.utilidades.Utilidades;

public class DiagnosticoNuevoActivity extends AppCompatActivity {

    ListView visualizadorLista;
    AutoCompleteTextView buscador;
    ArrayList<Enfermedad> enfermedadesList;

    RadioButton pres,def;

    String enfermedad,codigo,tipoEnfermedad;

    ConexionSQLiteHelper conn;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico_nuevo);

        pres = (RadioButton)findViewById(R.id.rbPres);
        def  = (RadioButton)findViewById(R.id.rbDef);
        guardar=(Button)findViewById(R.id.btnRegistrarDiagnostico);

        conn = new ConexionSQLiteHelper(this,Utilidades.NOMBRE_BASE,null,1);

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
                TextView name =(TextView)view.findViewById(R.id.tvNombre);//Esto se saca del activity item row Enfermedad
                TextView code =(TextView)view.findViewById(R.id.tvCodigo);//Esto se saca del activity item row Enfermedad
                buscador.setText(name.getText());
                enfermedad = name.getText().toString();
                codigo = code.getText().toString();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"Diagnostico Guardado",Toast.LENGTH_SHORT).show();
                registrarDiagnostico();
                irDiagnostico(v);
            }
        });
    }

    public void irDiagnostico(View view) {
        Intent intent = new Intent(this, DiagnosticoActivity.class);
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
            Toast.makeText(getApplicationContext(),"Debe seleccionar un tipo de Enfermedad",Toast.LENGTH_SHORT).show();
        }
    }

    private void writeDiagnostico(){

        SQLiteDatabase db= conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.DIAGNOSTICO_CAMPO_ENFERMEDAD,enfermedad);
        values.put(Utilidades.DIAGNOSTICO_CAMPO_CODIGO,codigo);
        values.put(Utilidades.DIAGNOSTICO_CAMPO_TIPO_ENFERMEDAD,tipoEnfermedad);

        db.insert(Utilidades.TABLA_DIAGNOSTICO, null,values);

        db.close();

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
