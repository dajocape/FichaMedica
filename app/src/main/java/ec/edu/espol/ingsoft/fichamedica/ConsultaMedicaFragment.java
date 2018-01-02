package ec.edu.espol.ingsoft.fichamedica;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ConsultaMedicaFragment extends Fragment {

    private static final String TAG = "ConsultaMedicaFragment";

    private Button btn_guardar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater .inflate(R.layout.consulta_medica_fragment,container,false);

        btn_guardar = (Button) view.findViewById(R.id.btn_guardar);

        btn_guardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Testing", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
