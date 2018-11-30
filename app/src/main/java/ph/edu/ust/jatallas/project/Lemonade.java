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

public class Lemonade extends AppCompatActivity {

    ListView listView;
    AdapterLemonadeListView adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<ModelLemonade> arrayList = new ArrayList<ModelLemonade>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lemonade);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("LEMONADE ");

        title = new String[]{
                "Chemistea",
                "Dakasi",
                "Gong Cha",
                "Macao Imperial Tea",
                "Naughtea Boy",
                "Obladi Oblada",
                "Starbucks",
                "Toribox" };
        description = new String[]{
                "Location: 1st flr. Fusebox Bldg. 1254 Asturias St. Sampaloc, Manila, 1015 Metro Manila",
                "Location: 1177 Dapitan St, Sampaloc, Manila, 1008 Metro Manila",
                "Location: 2nd Floor, Food Court, The One Grand Centre, Espana",
                "Location: Pacific Suites, 1218 Santander St, Sampaloc, Manila, 1008 Metro Manila",
                "Location: 915, P. Noval Street, España Boulevard, Padre Noval St, Sampaloc, Manila, Metro Manila",
                "Location: 1109, red, manor bldg, g.m. tolentino st., sampaloc, 1008 Kalakhang Maynila",
                "Location: UST Multi-Deck Carpark, Father Roque Ruaño Dr, Sampaloc, Manila, 1008 Metro Manila",
                "Location: iTower Building, 939 Padre Noval St, Sampaloc, Maynila, Kalakhang Maynila"};
        icon = new int[]{
                R.drawable.lemonchemistea ,
                R.drawable.lemondakasi,
                R.drawable.lemongong,
                R.drawable.lemonmacao,
                R.drawable.lemonnaughtea,
                R.drawable.lemonobladi,
                R.drawable.lemonsb,
                R.drawable.lemontoribox,};

        listView = findViewById(R.id.listView);

        for (int i = 0; i<title.length; i++){
            ModelLemonade modelLemonade = new ModelLemonade(title[i], description[i],icon[i] );
            //bind strings in array
            arrayList.add(modelLemonade);
        }

        //pass results to AdapterLemonadeListView
        adapter = new AdapterLemonadeListView(this, arrayList);

        //bind adapter in list view
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menulemonade, menu);

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
