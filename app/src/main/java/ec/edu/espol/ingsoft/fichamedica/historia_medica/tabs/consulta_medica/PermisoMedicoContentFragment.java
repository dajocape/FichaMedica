package ec.edu.espol.ingsoft.fichamedica.historia_medica.tabs.consulta_medica;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.PermisoMedico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PermisoMedicoContentFragment extends Fragment {
    String idEmpleado;
    Switch switch_generar;
    Calendar calendar;
    Date fecha_ini, fecha_fin;
    EditText txtFechaDesde, txtFechaHasta, txtObservacion;
    AutoCompleteTextView acNombreCie10, acCodigoCie10;
    TextView tv_dias;
    int dia, mes, anio;
    Button btn_guardar;
    List<PermisoMedico> permisoMedicoList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.permiso_medico_content_fragment, container, false);
        idEmpleado = getArguments().getString("idEmpleado");
        //Toast.makeText(getContext(),idEmpleado,Toast.LENGTH_SHORT).show();
        calendar = Calendar.getInstance();

        fecha_ini = null;
        fecha_fin = null;

        String[] nombresCie10 = {"Tifus", "Fiebre amarilla", "Varicela", "Tumor maligno del labio",
                "Enfermedad de Hodgkin", "Tumor benigno del tejido blando del peritoneo y del retroperitoneo",
                "Anemia debida a trastornos enzimáticos", "Inmunodeficiencia variable común", "Diabetes mellitus insulinodependiente",
                "Esquizofrenia"};
        String[] codigosCie10 = {"A75", "A95", "B01", "C00", "C81", "D20", "D55", "D83", "E10", "F20"};

        switch_generar = view.findViewById(R.id.switchGenerarPermiso);
        txtFechaDesde = view.findViewById(R.id.txt_fecha_desde);
        txtFechaHasta = view.findViewById(R.id.txt_fecha_hasta);
        acNombreCie10 = view.findViewById(R.id.ac_nombre_cie10);
        acCodigoCie10 = view.findViewById(R.id.ac_codigo_cie10);
        btn_guardar = view.findViewById(R.id.btn_guardar);
        txtObservacion = view.findViewById(R.id.txt_observacion);
        tv_dias = view.findViewById(R.id.tv_numero_dias);

        switch_generar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switch_generar.isChecked()) {
                    txtFechaDesde.setEnabled(true);
                    txtFechaHasta.setEnabled(true);
                    acNombreCie10.setEnabled(true);
                    acCodigoCie10.setEnabled(true);
                } else {
                    txtFechaDesde.setEnabled(false);
                    txtFechaHasta.setEnabled(false);
                    acNombreCie10.setEnabled(false);
                    acCodigoCie10.setEnabled(false);
                }
            }
        });

        dia = calendar.get(Calendar.DAY_OF_MONTH);
        mes = calendar.get(Calendar.MONTH);
        anio = calendar.get(Calendar.YEAR);

        inicializarAutocompletado(nombresCie10, codigosCie10);

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

        calcNumDias();

        cargarPermisoMedico();

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermisoMedico permiso = new PermisoMedico();

                permiso.setFechaInicio(txtFechaDesde.getText().toString());
                permiso.setFechaFin(txtFechaHasta.getText().toString());
                permiso.setEnfermedadNombre(acNombreCie10.getText().toString());
                permiso.setEnfermedadCodigo(acCodigoCie10.getText().toString());
                permiso.setObservacion(txtObservacion.getText().toString());
                permiso.setDias(Integer.parseInt(tv_dias.getText().toString()));
                permiso.setIdEmpleado(idEmpleado);
                permiso.save();

                Toast.makeText(getContext(),"Datos Guardados exitosamente",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void inicializarAutocompletado(final String[] nombresCie10, final String[] codigosCie10) {
        ArrayAdapter<String> adaptador;

        adaptador = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, nombresCie10);
        final AutoCompleteTextView tv_nombre_cie10 = acNombreCie10;
        tv_nombre_cie10.setAdapter(adaptador);

        adaptador = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, codigosCie10);
        final AutoCompleteTextView tv_codigo_cie10 = acCodigoCie10;
        tv_codigo_cie10.setAdapter(adaptador);

        tv_nombre_cie10.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nombre = (String) parent.getItemAtPosition(position);
                int pos = -1;
                for (int i = 0; i < nombresCie10.length; i++) {
                    if (nombre.equalsIgnoreCase(nombresCie10[i])) {
                        pos = i;
                        break;
                    }
                }
                String codigo = codigosCie10[pos];
                tv_codigo_cie10.setText(codigo);
            }
        });

        tv_codigo_cie10.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo = (String) parent.getItemAtPosition(position);
                int pos = -1;
                for (int i = 0; i < codigosCie10.length; i++) {
                    if (codigo.equalsIgnoreCase(codigosCie10[i])) {
                        pos = i;
                        break;
                    }
                }
                String nombre = nombresCie10[pos];
                tv_nombre_cie10.setText(nombre);
            }
        });

    }

    public void DateDialogInicio() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    date = simpleDateFormat.parse("" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                txtFechaDesde.setText(simpleDateFormat.format(date));

                calcNumDias();
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
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    date = simpleDateFormat.parse("" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                txtFechaHasta.setText(simpleDateFormat.format(date));

                calcNumDias();
            }
        };
        DatePickerDialog dpDialog = new DatePickerDialog(getContext(), listener, anio, mes, dia);
        dpDialog.show();
    }

    private void calcNumDias() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String string_fecha_ini = txtFechaDesde.getText().toString();
        String string_fecha_fin = txtFechaHasta.getText().toString();

        if (!string_fecha_ini.equals("") && !string_fecha_fin.equals("")) {

            try {
                fecha_ini = simpleDateFormat.parse(string_fecha_ini);
                fecha_fin = simpleDateFormat.parse(string_fecha_fin);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            long dias_mili = Math.abs(fecha_fin.getTime() - fecha_ini.getTime());
            long numDias = TimeUnit.DAYS.convert(dias_mili, TimeUnit.MILLISECONDS);

            tv_dias.setText(Long.toString(numDias + 1));
        }

    }

    public void cargarPermisoMedico(){
        try{
            permisoMedicoList = PermisoMedico.find(PermisoMedico.class, "ID_EMPLEADO = ?",idEmpleado);
        }catch (Exception e){
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

        if(!permisoMedicoList.isEmpty()) {
            txtFechaDesde.setText(permisoMedicoList.get(permisoMedicoList.size()-1).getFechaInicio());
            txtFechaHasta.setText(permisoMedicoList.get(permisoMedicoList.size()-1).getFechaFin());
            txtObservacion.setText(permisoMedicoList.get(permisoMedicoList.size()-1).getObservacion());
            tv_dias.setText(permisoMedicoList.get(permisoMedicoList.size()-1).getDias());
            acCodigoCie10.setText(permisoMedicoList.get(permisoMedicoList.size()-1).getEnfermedadCodigo());
            acNombreCie10.setText(permisoMedicoList.get(permisoMedicoList.size()-1).getEnfermedadNombre());
        }
    }

    @Override
    public void onResume() {
        calcNumDias();
        super.onResume();
    }
}