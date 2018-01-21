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
import ec.edu.espol.ingsoft.fichamedica.model.AntecedentesPatologicosFamiliares;

public class AntecedentesPatologicosFamiliaresAdapter extends ArrayAdapter<AntecedentesPatologicosFamiliares>{
    private Context context;
    int layoutResourceId;
    ArrayList<AntecedentesPatologicosFamiliares> listItems=null;

    public AntecedentesPatologicosFamiliaresAdapter(Context context, int layoutResourceId, ArrayList<AntecedentesPatologicosFamiliares> listItems){
        super(context,layoutResourceId,listItems);
        this.context = context;
        this.layoutResourceId=layoutResourceId;
        this.listItems = listItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        AntecedentesPatologicosFamiliaresHolder  holder = null;

        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row=inflater.inflate(layoutResourceId,parent,false);
            holder = new AntecedentesPatologicosFamiliaresHolder();
            holder.parentezcoPaciente = (TextView) row.findViewById(R.id.tvParentescoPatologia);
            holder.enfermedadPariente = (TextView)row.findViewById(R.id.tvEnfermedadDetallePatologia);
            row.setTag(holder);
        } else {
            holder = (AntecedentesPatologicosFamiliaresHolder)row.getTag();
        }

        AntecedentesPatologicosFamiliares antecedentesFamiliares = listItems.get(position);
        holder.parentezcoPaciente.setText(antecedentesFamiliares.getParentescoPaciente());
        holder.enfermedadPariente.setText(antecedentesFamiliares.getEnfermedadPariente());

        return row;
    }

    static class AntecedentesPatologicosFamiliaresHolder{
        TextView parentezcoPaciente;
        TextView enfermedadPariente;
    }
}
