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

public class FruitJuice extends AppCompatActivity {

    ListView listView;
    AdapterFruitJuiceListView adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<ModelFruitJuice> arrayList = new ArrayList<ModelFruitJuice>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_juice);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("FRUIT JUICE ");

        title = new String[]{
                "Chemistea Cafe",
                "Naughtea Boy",
                "Fruitas",
                "Juice Avenue",
                "Dakasi",
                "S.M.Y Noshery",
                "Seattle's Best",
                "Amo Yamie Crib",
                "Gong Cha",
                "Dormina Espressia",
                "Macao Imperial Tea",
        };
        description = new String[]{
                "Location: 1st flr. Fusebox Bldg. 1254 Asturias St. Sampaloc, Manila, 1015 Metro Manila",
                "Location: 915, P. Noval Street, España Boulevard, Padre Noval St, Sampaloc, Manila, Metro Manila",
                "Location: Food Court, 2nd Floor, The One Grand Centre, Espana",
                "Location: UST - D2B, 2nd Floor AMV Building",
                "Location: 1177 Dapitan St, Sampaloc, Manila, 1008 Metro Manila",
                "Location: University Tower II, 863 Galicia Street Corner España Boulevard, Sampaloc, Manila",
                "Location: UST - QPAv, in front of Roque Ruano Building",
                "Location: DB Building, 1250 España Blvd, Sampaloc, Manila, 1008 Metro Manila",
                "Location: 2nd Floor, Food Court, The One Grand Centre, Espana",
                "Location: 1021 Tolentino St, Sampaloc, Manila, 1008 Metro Manila",
                "Location: Pacific Suites, 1218 Santander St, Sampaloc, Manila, 1008 Metro Manila",
        };
        icon = new int[]{
                R.drawable.fruit_chemistea ,
                R.drawable.fruit_naughtea,
                R.drawable.fruit_fruitas,
                R.drawable.fruit_avenue,
                R.drawable.fruit_dakasi,
                R.drawable.fruit_smy ,
                R.drawable.fruit_sea,
                R.drawable.fruit_amoyamie,
                R.drawable.fruit_gong,
                R.drawable.fruit_dormina,
                R.drawable.fruit_macao
        };

        listView = findViewById(R.id.listView);

        for (int i = 0; i<title.length; i++){
            ModelFruitJuice modelFruitJuice = new ModelFruitJuice(title[i], description[i],icon[i] );
            //bind strings in array
            arrayList.add(modelFruitJuice);
        }

        //pass results to AdapterFruitJuiceListView
        adapter = new AdapterFruitJuiceListView(this, arrayList);

        //bind adapter in list view
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menufruitjuice, menu);

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
