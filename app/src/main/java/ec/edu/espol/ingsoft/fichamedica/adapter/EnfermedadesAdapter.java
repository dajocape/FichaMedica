package ec.edu.espol.ingsoft.fichamedica.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ec.edu.espol.ingsoft.fichamedica.R;
import ec.edu.espol.ingsoft.fichamedica.model.Enfermedad;

/**
 * Created by jorge on 7/1/2018.
 */

public class EnfermedadesAdapter extends ArrayAdapter<Enfermedad> {

    Context context;
    int layoutResourceId;
    ArrayList<Enfermedad> data=null;

    public EnfermedadesAdapter(Context context, int layaoutResouceId, ArrayList<Enfermedad> data) {
        super(context,layaoutResouceId,data);

        this.context=context;
        this.layoutResourceId=layaoutResouceId;
        this.data=data;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row =convertView;
        EnfermedadHolder holder = null;

        if (row==null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row=inflater.inflate(layoutResourceId,parent,false);
            holder = new EnfermedadHolder();
            holder.nombre = (TextView)row.findViewById(R.id.tvNombre);
            holder.codigo = (TextView)row.findViewById(R.id.tvCodigo);
            row.setTag(holder);


        }else{
            holder=(EnfermedadHolder)row.getTag();
        }

//        Enfermedad enfermedades = data.get(position);
//        holder.nombre.setText(enfermedades.nombre);
//        holder.codigo.setText(enfermedades.codigo);

        return row;
    }

    static class EnfermedadHolder{
        TextView nombre;
        TextView codigo;

    }
}
