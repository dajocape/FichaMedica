package ec.edu.espol.ingsoft.fichamedica;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ec.edu.espol.ingsoft.fichamedica.utilidades.Utilidades;

/**
 * Created by jorge on 13/1/2018.
 */

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_ENFERMEDAD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {//Version antigua y nueva de la base de datos
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ENFERMEDAD);
        onCreate(db);
    }
}
