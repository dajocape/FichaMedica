package com.ingsof.diagnostico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class diagnostico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico);
    }

    public void ingresarDiagnostico(View view) {
        Intent intent = new Intent(this, diagnosticoNuevoIngreso.class);
        startActivity(intent);
    }
}
