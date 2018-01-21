package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import ec.edu.espol.ingsoft.fichamedica.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PermisoMedicoContentFragment extends Fragment {

    Switch switch_generar;
    Calendar calendar;
    EditText txtFechaDesde, txtFechaHasta;
    AutoCompleteTextView acNombreCie10;
    //Spinner spNombreCie10;
    int dia, mes, anio;
    //ArrayList<Enfermedad> enfermedadesList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.permiso_medico_content_fragment, container, false);

        calendar= Calendar.getInstance();
        //enfermedadesList = (ArrayList<Enfermedad>) Enfermedad.listAll(Enfermedad.class);
        String[] nombresCie10 = {"Cáncer","Gripe","Viruela","Sarampión","Dengue"};
        //spNombreCie10 = view.findViewById(R.id.sp_nombre_cie10);

        switch_generar = view.findViewById(R.id.switchGenerarPermiso);
        txtFechaDesde = view.findViewById(R.id.txt_fecha_desde);
        txtFechaHasta = view.findViewById(R.id.txt_fecha_hasta);
        acNombreCie10=view.findViewById(R.id.ac_nombre_cie10);

        dia=calendar.get(Calendar.DAY_OF_MONTH);
        mes=calendar.get(Calendar.MONTH);
        anio=calendar.get(Calendar.YEAR);

        switch_generar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switch_generar.isChecked()){
                    txtFechaDesde.setEnabled(true);
                    txtFechaHasta.setEnabled(true);
                    acNombreCie10.setEnabled(true);
                }
                else{
                    txtFechaDesde.setEnabled(false);
                    txtFechaHasta.setEnabled(false);
                    acNombreCie10.setEnabled(false);
                }
//                if (switch_generar.isChecked()) text_permiso_medico.setEnabled(true);
//                else text_permiso_medico.setEnabled(false);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, nombresCie10);
        AutoCompleteTextView textView = (AutoCompleteTextView) acNombreCie10;
        textView.setAdapter(adapter);

        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spNombreCie10.setAdapter(adapter);

        txtFechaDesde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateDialogInicio();
            }
        });
        txtFechaHasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateDialogFin();
            }
        });

        return view;
    }

    public void DateDialogInicio() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date = simpleDateFormat.parse("" + year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                txtFechaDesde.setText(simpleDateFormat.format(date));

            }
        };
        DatePickerDialog dpDialog = new DatePickerDialog(getContext(), listener, anio, mes, dia);
        dpDialog.show();
    }

    public void DateDialogFin() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date = simpleDateFormat.parse("" + year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                txtFechaHasta.setText(simpleDateFormat.format(date));
            }
        };
        DatePickerDialog dpDialog = new DatePickerDialog(getContext(), listener, anio, mes, dia);
        dpDialog.show();
    }

}
