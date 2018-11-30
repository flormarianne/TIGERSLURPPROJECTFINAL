package ph.edu.ust.jatallas.project;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.app.SearchManager;
import android.support.v7.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import java.util.ArrayList;

public class Soda extends AppCompatActivity {

    ListView listView;
    AdapterSodaListView adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<ModelSoda> arrayList = new ArrayList<ModelSoda>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soda);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("SODA ");

        title = new String[]{
                "Jollibee Dapitan",
                "McDonald's UST",
                "Sbarro",
                "KFC",
                "Bonchon Chicken UST",
                "Krispy Kreme",
                "Subway",
                "7-Eleven",
                "Ministop",
                "Yellow Cab"};
        description = new String[]{
                "Location: 1523 Dapitan St, Sampaloc, Manila, 1015 Metro Manila",
                "Location: UST Multi-Deck Carpark, León María Guerrero Dr, Sampaloc, Manila, 1800 Metro Manila",
                "Location: Ground Floor, UST Multi-deck Parking, UST Campus, Sampaloc, Manila",
                "Location: Ground Floor, UST Multi-deck Parking, UST Campus, Sampaloc, Manila",
                "Location: Second Floor, UST Multi-deck Parking, UST Campus, Sampaloc, Manila",
                "Location: Ground Floor, UST Multi-deck Parking, UST Campus, Sampaloc, Manila",
                "Location: Space 8, Multi-Deck Parking Building, Level 1, España Blvd, Sampaloc, Manila, 1008 Metro Manila",
                "Location: 1521 Dapitan St, Sampaloc, Manila, 1015 Metro Manila",
                "Location: 1015 Padre Noval St, Sampaloc, Manila, 1008 Metro Manila",
                "Location: 1122 Lacson Ave, Sampaloc, Manila, 1008 Metro Manila"
        };
        icon = new int[]{
                R.drawable.sodajollibee ,
                R.drawable.sodamcdodo,
                R.drawable.sodasbarro,
                R.drawable.sodakfc,
                R.drawable.sodabonchom,
                R.drawable.sodakk,
                R.drawable.sodasubway,
                R.drawable.sodase,
                R.drawable.sodamini,
                R.drawable.sodayc};

        listView = findViewById(R.id.listView);

        for (int i = 0; i<title.length; i++){
            ModelSoda modelSoda = new ModelSoda(title[i], description[i],icon[i] );
            //bind strings in array
            arrayList.add(modelSoda);
        }

        //pass results to AdapterSodaListView
        adapter = new AdapterSodaListView(this, arrayList);

        //bind adapter in list view
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menusoda, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)) {
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(s);
                }

                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
