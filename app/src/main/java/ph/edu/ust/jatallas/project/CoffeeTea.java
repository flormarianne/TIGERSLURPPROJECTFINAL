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

public class CoffeeTea extends AppCompatActivity {

    ListView listView;
    AdapterCoffeeTeaListView adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<ModelCoffeeTea> arrayList = new ArrayList<ModelCoffeeTea>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_tea);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("COFFEE OR TEA ");

        title = new String[]{"Starbucks",
                "Seattle's Best",
                "Macao Imperial Tea",
                "Dormina Espressia",
                "Coffee Avenue",
                "Amo Yamie Crib",
                "Mcdonald's",
                "D'Cream",
                "Gong Cha",
                "SimpleLine",
                "Cafe UK",
                "iChill Theater Cafe",
                "Amor Bakery"};
        description = new String[]{
                "Location: UST Multi-Deck Carpark, Father Roque Ruaño Dr, Sampaloc, Manila, 1008 Metro Manila",
                "Location: UST - QPAv, in front of Roque Ruano Building",
                "Location: Pacific Suites, 1218 Santander St, Sampaloc, Manila, 1008 Metro Manilaa",
                "Location: 1021 Tolentino St, Sampaloc, Manila, 1008 Metro Manila",
                "Location: Second Floor, The ONE Torre de Santo Tomas, MF Jhocson Street, Sampaloc, Manila",
                "Location: DB Building, 1250 España Blvd, Sampaloc, Manila, 1008 Metro Manila",
                "Location: UST Multi-Deck Carpark",
                "Location: P.Noval Street near Espana Blvd. Sampaloc Manila",
                "Location: 2nd Floor, Food Court, The One Grand Centre, Espana",
                "Location: 1355 Dapitan Street, Sampaloc, Manila",
                "Location: 1507 Dapitan Corner Gelinos Street, Sampaloc, Manila",
                "Location: 1125 Dos Castillas Street, Sampaloc, Manila",
                "Location: 8010 Espana Corner Tolentino Street, Sampaloc, Manila"};
        icon = new int[]{R.drawable.coffee_startbucks ,
                R.drawable.coffee_sea,
                R.drawable.coffee_macao,
                R.drawable.coffee_dormina,
                R.drawable.coffee_avenue,
                R.drawable.coffee_amoyamie ,
                R.drawable.coffee_mcdo,
                R.drawable.coffee_dcream,
                R.drawable.coffee_gong,
                R.drawable.coffee_simple,
                R.drawable.coffee_cafeuk,
                R.drawable.coffee_ichill,
                R.drawable.coffee_amor,
        };

        listView = findViewById(R.id.listView);

        for (int i = 0; i<title.length; i++){
            ModelCoffeeTea modelCoffeeTea = new ModelCoffeeTea(title[i], description[i],icon[i] );
            //bind strings in array
            arrayList.add(modelCoffeeTea);
        }

        //pass results to AdapterCoffeeTeaListView
        adapter = new AdapterCoffeeTeaListView(this, arrayList);

        //bind adapter in list view
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menucoffeetea, menu);

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
