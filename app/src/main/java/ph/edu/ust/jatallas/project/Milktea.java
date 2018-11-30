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

public class Milktea extends AppCompatActivity {

    ListView listView;
    AdapterMilkteaListView adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<ModelMilktea> arrayList = new ArrayList<ModelMilktea>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milktea);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("MILKTEA ");

        title = new String[]{
                "Gong Cha UST The One",
                "D'Cream P.Noval",
                "Moonleaf Espana",
                "I love Milktea Sampaloc",
                "Bon Appetea Espana",
                "Chemistea Cafe",
                "Naughtea Boy",
                "SimpleLine",
                "ZenTea",
                "Happy Cup",
                "Dakasi",
                "Macao Imperial Tea",
                "Amor Bakery",
        };
        description = new String[]{
                "Location: Food Court, Second Floor, The One Grand Centre, España",
                "Location: P. Noval Street, Near Espana Boulevard, Sampaloc, Manila",
                "Location: G/F, St Thomas Square, España Blvd, 397, Manila, 1015 Metro Manila",
                "Location: Padre Noval Street, Near UST Campus, Sampaloc, Manila",
                "Location: 838 P. Campa Street, Sampaloc, Manila",
                "Location: 1st flr. Fusebox Bldg. 1254 Asturias St. Sampaloc, Manila, 1015 Metro Manila",
                "Location: 915, P. Noval Street, España Boulevard, Padre Noval St, Sampaloc, Manila, Metro Manila",
                "Location: 1355 Dapitan Street, Sampaloc, Manila",
                "Location: 1750, Unit 1G of Dapitan Regency Bldg, Dapitan St, Sampaloc, Manila, 1008 Metro Manila",
                "Location: 1015 P.Noval Street Sampaloc Manila",
                "Location: 1177 Dapitan St, Sampaloc, Manila, 1008 Metro Manila",
                "Location: Pacific Suites, 1218 Santander St, Sampaloc, Manila, 1008 Metro Manila",
                "Location: 8010 Espana Corner Tolentino Street, Sampaloc, Manila",};
        icon = new int[]{
                R.drawable.milkgongcha ,
                R.drawable.milkdcream,
                R.drawable.milkmoonleaf,
                R.drawable.milkilmilktea,
                R.drawable.milkbonappetea,
                R.drawable.milk_chemistea ,
                R.drawable.milk_naughtea,
                R.drawable.milk_simple,
                R.drawable.milk_zen,
                R.drawable.milk_happy,
                R.drawable.milk_dak,
                R.drawable.milk_macao,
                R.drawable.milk_amor,
        };

        listView = findViewById(R.id.listView);

        for (int i = 0; i<title.length; i++){
            ModelMilktea modelMilktea = new ModelMilktea(title[i], description[i],icon[i] );
            //bind strings in array
            arrayList.add(modelMilktea);
        }

        //pass results to AdapterMilkteaListView
        adapter = new AdapterMilkteaListView(this, arrayList);

        //bind adapter in list view
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumilktea, menu);

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
