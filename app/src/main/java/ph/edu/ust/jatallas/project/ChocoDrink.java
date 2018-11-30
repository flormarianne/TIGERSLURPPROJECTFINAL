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

public class ChocoDrink extends AppCompatActivity {

    ListView listView;
    AdapterChocodrinkListView adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<ModelChocodrink> arrayList = new ArrayList<ModelChocodrink>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choco_drink);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("CHOCO DRINK ");

        title = new String[]{"Farron Cafe",
                "Starbucks",
                "Amo Yamie Crib Espana",
                "Krispy Kreme",
                "I love Milktea",
                "Moonleaf Tea Shop",
                "Pancake House",
                "Jollibee UST The One",
                "Dormina Espressia",
                "Naughtea Boy"};
        description = new String[]{"Location: Dormus Building, Espana Boulevard, Sampaloc, Manila",
                "Location: Ground Floor, UST Multi-deck Parking, UST Campus, Sampaloc, Manila",
                "Location: DB Building, 1250 España Blvd, Sampaloc, Manila, 1008 Metro Manila",
                "Location: Ground Floor, UST Multi-deck Parking, UST Campus, Sampaloc, Manila",
                "Location: Sampaloc Antonio St., Sampaloc Manila",
                "Location: G/F, St Thomas Square, España Blvd, 397, Manila, 1015 Metro Manila",
                "Location: G/F UST, Multi-deck Parking, Lacson Ave, Sampaloc, Manila",
                "Location: Ground Floor, The One Building, España Boulevard Corner M.F. Jhocson Street, Sampaloc, Manila",
                "Location: 1021 Tolentino St, Sampaloc, Manila, 1008 Metro Manila",
                "Location: 915, P. Noval Street, España Boulevard, Padre Noval St, Sampaloc, Manila, 1008 Metro Manila"
        };
        icon = new int[]{R.drawable.chocofarron ,
                R.drawable.chocosb,
                R.drawable.chocoamoyamie,
                R.drawable.chocokrispy,
                R.drawable.chocoilm,
                R.drawable.chocomoonleaf ,
                R.drawable.chocopancake,
                R.drawable.chocojollibee,
                R.drawable.chocodormina,
                R.drawable.choconaughty};

        listView = findViewById(R.id.listView);

        for (int i = 0; i<title.length; i++){
            ModelChocodrink modelChocodrink = new ModelChocodrink(title[i], description[i],icon[i] );
            //bind strings in array
            arrayList.add(modelChocodrink);
        }

        //pass results to AdapterChocodrinkListView
        adapter = new AdapterChocodrinkListView(this, arrayList);

        //bind adapter in list view
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuchocodrink, menu);

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
