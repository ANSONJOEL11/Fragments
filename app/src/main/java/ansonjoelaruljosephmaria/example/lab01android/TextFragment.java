package ansonjoelaruljosephmaria.example.lab01android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment {
    TextView monthL,monthN;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.text_fragment, container, false);
        monthL= (TextView) view.findViewById(R.id.MonthL);
        monthN= (TextView)view.findViewById(R.id.MonthN);


        return view;

    }
    public void change(String txt, String txt1){
        monthL.setText(txt);
        monthN.setText(txt1);

    }
}