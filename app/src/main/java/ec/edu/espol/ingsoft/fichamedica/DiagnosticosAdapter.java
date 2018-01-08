package ec.edu.espol.ingsoft.fichamedica;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by jorge on 7/1/2018.
 */

public class DiagnosticosAdapter extends ArrayAdapter<Diagnostico> {

    Context context;
    int layoutResourceId;
    Diagnostico data[] =null;

    public DiagnosticosAdapter(Context context, int layaoutResouceId, Diagnostico[] data) {
        super(context,layaoutResouceId,data);

        this.context=context;
        this.layoutResourceId=layaoutResouceId;
        this.data=data;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row =convertView;
        DiagnosticoHolder holder = null;

        if (row==null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row=inflater.inflate(layoutResourceId,parent,false);
            holder = new DiagnosticoHolder();
            holder.enfermedad = (TextView)row.findViewById(R.id.tvEnfermedad);
            holder.codigo = (TextView)row.findViewById(R.id.tvCodigo);
            holder.tipoEnfermedad = (TextView)row.findViewById(R.id.tvTipoEnfermedad);
            row.setTag(holder);


        }else{
            holder=(DiagnosticoHolder)row.getTag();
        }

        Diagnostico diagnosticos = data[position];
        holder.enfermedad.setText(diagnosticos.enfermedad);
        holder.codigo.setText(diagnosticos.codigo);
        holder.tipoEnfermedad.setText(diagnosticos.tipoEnfermedad);

        return row;
    }

    static class DiagnosticoHolder{
        TextView enfermedad;
        TextView codigo;
        TextView tipoEnfermedad;
    }
}
