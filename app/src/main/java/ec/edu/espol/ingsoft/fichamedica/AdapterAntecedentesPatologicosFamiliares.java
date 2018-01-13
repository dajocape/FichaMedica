package ec.edu.espol.ingsoft.fichamedica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterAntecedentesPatologicosFamiliares extends BaseAdapter{
    private Context context;
    private ArrayList<EntidadAntecedentesPatologicosFamiliares> listItems;

    public AdapterAntecedentesPatologicosFamiliares(Context context, ArrayList<EntidadAntecedentesPatologicosFamiliares> listItems){
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount(){
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        EntidadAntecedentesPatologicosFamiliares Item = (EntidadAntecedentesPatologicosFamiliares) getItem(position);

        converView = LayoutInflater.from(context).inflate(R.layout.items_para_antecedentes_patologicos_familiares,null);
        TextView tvParentescoPaciente = (TextView) converView.findViewById(R.id.tvParentescoPaciente);
        TextView tvEnfermedadParientePaciente = (TextView) converView.findViewById(R.id.tvEnfermedadParientePaciente);

        tvParentescoPaciente.setText(Item.getParentescoPaciente());
        tvEnfermedadParientePaciente.setText(Item.getEnfermedadPariente());

        return converView;
    }
}
