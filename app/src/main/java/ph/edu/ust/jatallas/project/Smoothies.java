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

public class Smoothies extends AppCompatActivity {

    ListView listView;
    AdapterSmoothiesListView adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<ModelSmoothies> arrayList = new ArrayList<ModelSmoothies>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smoothies);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("SMOOTHIES ");

        title = new String[]{
                "Naughtea Boy",
                "Amo Yamie Crib",
                "Chun Chon",
                "Dormina Espressia",
                "S.M.Y Noshery",
                "Fruitas",
                "Juice Avenue",
                "Cafe Tomas",
                "Chill Theater Cafe",
                "Amor Bakery",
                "Zagu",
        };
        description = new String[]{
                "Location: 915, P. Noval Street, España Boulevard, Padre Noval St, Sampaloc, Manila, Metro Manila",
                "Location: DB Building, 1250 España Blvd, Sampaloc, Manila, 1008 Metro Manila",
                "Location: 1139 GM Tolentino, Casa Ysabel Building, Sampaloc, Manila",
                "Location: 1021 Tolentino St, Sampaloc, Manila, 1008 Metro Manila",
                "Location: University Tower II, 863 Galicia Street Corner España Boulevard, Sampaloc, Manila",
                "Location: Food Court, 2nd Floor, The One Grand Centre, Espana",
                "Location: UST - D2B, 2nd Floor AMV Building",
                "Location: Mezzanine Floor, Annie’s Place, 1015 P. Noval Street, Sampaloc, Manila",
                "Location: 1125 Dos Castillas Street, Sampaloc, Manila",
                "Location: 8010 Espana Corner Tolentino Street, Sampaloc, Manila",
                "Location: Tolentino Street Corner Barlin Street, Sampaloc, Manila"
        };
        icon = new int[]{
                R.drawable.smooth_naughtea,
                R.drawable.smooth_amoyamie,
                R.drawable.smooth_chunchon,
                R.drawable.smoth_dorminaa,
                R.drawable.smooth_smy,
                R.drawable.smooth_fruitas ,
                R.drawable.smooth_avenue,
                R.drawable.smooth_tomas,
                R.drawable.smooth_ichill,
                R.drawable.smooth_amor,
                R.drawable.smooth_zagu
        };

        listView = findViewById(R.id.listView);

        for (int i = 0; i<title.length; i++){
            ModelSmoothies modelSmoothies = new ModelSmoothies(title[i], description[i],icon[i] );
            //bind strings in array
            arrayList.add(modelSmoothies);
        }

        //pass results to AdapterSmoothiesListView
        adapter = new AdapterSmoothiesListView(this, arrayList);

        //bind adapter in list view
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menusmoothies, menu);

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
