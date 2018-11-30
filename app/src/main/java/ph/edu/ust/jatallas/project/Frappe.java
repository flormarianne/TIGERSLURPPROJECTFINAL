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

public class Frappe extends AppCompatActivity {

    ListView listView;
    AdapterFrappeListView adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<ModelFrappe> arrayList = new ArrayList<ModelFrappe>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frappe);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("FRAPPE ");

        title = new String[]{"Starbucks",
                "Seattle's Best",
                "Farron Cafe",
                "Amo Yamie Crib",
                "Chun Chon",
                "Dormina Espressia",
                "S.M.Y Noshery",
                "Naughtea Boy",
                "Macao Imperial Tea",
                "Coffee Avenue",
                "iChill Theater Cafe",
                "Amor Bakery"};
        description = new String[]{
                "Location: UST Multi-Deck Carpark, Father Roque Ruaño Dr, Sampaloc, Manila, 1008 Metro Manila",
                "Location: UST - QPAv, in front of Roque Ruano Building",
                "Location: UST - AMV building second floor, D2B",
                "Location: DB Building, 1250 España Blvd, Sampaloc, Manila, 1008 Metro Manila",
                "Location: 1139 GM Tolentino, Casa Ysabel Building, Sampaloc, Manila",
                "Location: 1021 Tolentino St, Sampaloc, Manila, 1008 Metro Manila",
                "Location: University Tower II, 863 Galicia Street Corner España Boulevard, Sampaloc, Manila",
                "Location: 915, P. Noval Street, España Boulevard, Padre Noval St, Sampaloc, Manila, Metro Manila",
                "Location: Pacific Suites, 1218 Santander St, Sampaloc, Manila, 1008 Metro Manila",
                "Location: Second Floor, The ONE Torre de Santo Tomas, MF Jhocson Street, Sampaloc, Manila",
                "Location: 1125 Dos Castillas Street, Sampaloc, Manila",
                "Location: 8010 Espana Corner Tolentino Street, Sampaloc, Manila"
        };
        icon = new int[]{
                R.drawable.frappe_startbucks ,
                R.drawable.frappe_seattle,
                R.drawable.frappe_farron,
                R.drawable.frappe_amoyamie,
                R.drawable.frappe_chunchon,
                R.drawable.frappe_dormina ,
                R.drawable.frappe_smy,
                R.drawable.frappe_naughtea,
                R.drawable.frappe_macao,
                R.drawable.frappe_avenue,
                R.drawable.frappe_ichill,
                R.drawable.frappe_amor,};

        listView = findViewById(R.id.listView);

        for (int i = 0; i<title.length; i++){
            ModelFrappe modelFrappe = new ModelFrappe(title[i], description[i],icon[i] );
            //bind strings in array
            arrayList.add(modelFrappe);
        }

        //pass results to AdapterFrappeListView
        adapter = new AdapterFrappeListView(this, arrayList);

        //bind adapter in list view
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menufrappe, menu);

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
