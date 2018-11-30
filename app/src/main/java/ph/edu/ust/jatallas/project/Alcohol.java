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

public class Alcohol extends AppCompatActivity {

    ListView listView;
    AdapterAlcoholListView adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<ModelAlcohol> arrayList = new ArrayList<ModelAlcohol>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcohol);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ALCOHOL ");

        title = new String[]{"Acustica Bistro & Lounge",
                "The Pit",
                "Four Monkeys Bar & Kitchen",
                "Kwadra Bar and Billiards",
                "Tapsi",
                "Wit Avenue Cafe and Bar",
                "Cubix Boardgame Cafe and Bar",
                "The Hidden Geek Bistro",
                "Jacko's Bistro",
                "Fusebox"
        };
        description = new String[]{"Location: Second Floor, Didache Building, 1508 España Boulevard, Sampaloc, Manila",
                "Location: Dapitan Asturias Street, Sampaloc, Manila",
                "Location: 1228 Santander Corner Dapitan Street, Sampaloc, Manila",
                "Location: 858 Extremadura St, Sampaloc, Manila, 1008 Metro Manila",
                "Location: Sampaloc Asturias St., Sampaloc Manila",
                "Location: 1106 M. Dela Fuente Street Manila City",
                "Location: Second Floor, Fusebox Food Park, 1414 Asturias Corner Laong Laan Street, Sampaloc, Manila",
                "Location: Room 104, Ground Floor, Dioresa Plaza Building, Dapitan Street, Sampaloc, Manila",
                "Location: Ground Floor, Divine Grace Suites, P. Noval Street Corner Dapitan Street, Sampaloc, Manila",
                "Location: Laong Laan Rd, Santa Cruz, Manila, 1008 Metro Manila"};
        icon = new int[]{R.drawable.alcoholacustica,
                R.drawable.alcoholthepit,
                R.drawable.alcoholfourmonkeys,
                R.drawable.alcoholkwadra,
                R.drawable.alcoholtapsi,
                R.drawable.alcoholwit,
                R.drawable.alcoholcubix,
                R.drawable.alcoholhidden,
                R.drawable.alcoholjackos,
                R.drawable.alcoholfusebox};

        listView = findViewById(R.id.listView);

        for (int i = 0; i<title.length; i++){
            ModelAlcohol modelAlcohol = new ModelAlcohol(title[i], description[i],icon[i] );
            //bind strings in array
            arrayList.add(modelAlcohol);
        }

        //pass results to AdapterAlcoholListView
        adapter = new AdapterAlcoholListView(this, arrayList);

        //bind adapter in list view
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menualcohol, menu);

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
