package ansonjoelaruljosephmaria.example.lab01android;

//import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuFragment extends ListFragment {
    String[] MonthL = new String[] { "Level 1","Level 2","Level 3","Level 4" };
    String[] MonthN = new String[]{"Immediate Gratification: Pleasure and minimize pain","Comparative/Personal Achievement: Ego Centeredness, better than, gain advantage","Contributive: Do good beyond self, Make an optimal positive difference for others","Ultimate Good: Participate in giving and receiving ultimate meaning, goodness, ideals and love."};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.list_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, MonthL);
        setListAdapter(adapter);

        return view;

    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        TextFragment txt = (TextFragment)getFragmentManager().findFragmentById(R.id.fragment2);
        txt.change(MonthN[position],MonthL[position]);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}