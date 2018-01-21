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
import ec.edu.espol.ingsoft.fichamedica.model.AntecedentesPatologicosPersonales;

public class AntecedentesPatologicosPersonalesAdapter extends ArrayAdapter<AntecedentesPatologicosPersonales> {
    private Context context;
    int layoutResourceId;
    ArrayList<AntecedentesPatologicosPersonales> listItems=null;

    public AntecedentesPatologicosPersonalesAdapter(Context context, int layoutResourceId, ArrayList<AntecedentesPatologicosPersonales> listItems){
        super(context,layoutResourceId,listItems);
        this.context = context;
        this.layoutResourceId=layoutResourceId;
        this.listItems = listItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        AntecedentesPatologicosPersonalesHolder holder = null;

        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row=inflater.inflate(layoutResourceId,parent,false);
            holder = new AntecedentesPatologicosPersonalesHolder();
            holder.patologia = (TextView) row.findViewById(R.id.tvParentescoPatologia);
            holder.detallePatologia = (TextView)row.findViewById(R.id.tvEnfermedadDetallePatologia);
            row.setTag(holder);
        } else {
            holder = (AntecedentesPatologicosPersonalesHolder) row.getTag();
        }

        AntecedentesPatologicosPersonales antecedentesPersonales = listItems.get(position);
        holder.patologia.setText(antecedentesPersonales.getPatologia());
        holder.detallePatologia.setText(antecedentesPersonales.getDetallePatologia());

        return row;
    }

    static class AntecedentesPatologicosPersonalesHolder{
        TextView patologia;
        TextView detallePatologia;
    }
}
