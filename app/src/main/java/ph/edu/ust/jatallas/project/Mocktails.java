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

public class Mocktails extends AppCompatActivity {

    ListView listView;
    AdapterMocktailsListView adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<ModelMocktails> arrayList = new ArrayList<ModelMocktails>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mocktails);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("MOCKTAILS ");

        title = new String[]{"Obladi Oblada",
                 };
        description = new String[]{
                "Location: 1109, red, manor bldg, g.m. tolentino st., sampaloc, 1008 Kalakhang Maynila"
        };
        icon = new int[]{R.drawable.lemonobladi ,
               };

        listView = findViewById(R.id.listView);

        for (int i = 0; i<title.length; i++){
            ModelMocktails modelMocktails = new ModelMocktails(title[i], description[i],icon[i] );
            //bind strings in array
            arrayList.add(modelMocktails);
        }

        //pass results to AdapterMocktailsListView
        adapter = new AdapterMocktailsListView(this, arrayList);

        //bind adapter in list view
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumocktails, menu);

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
