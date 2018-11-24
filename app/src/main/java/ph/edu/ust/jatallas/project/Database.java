package ph.edu.ust.jatallas.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Database extends AppCompatActivity {

    DatabaseHelper myDb;
    private EditText nameEditText;
    private EditText locationEditText;
    private EditText rangeEditText;
    String name, location, range ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        Button out = (Button) findViewById(R.id.logout);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent out = new Intent(getApplicationContext(), Login.class);
                startActivity(out);
            }
        });

        Button addBtn = findViewById(R.id.add);
        nameEditText = findViewById(R.id.stall);
        locationEditText = findViewById(R.id.location);
        rangeEditText = findViewById(R.id.pricee);

        myDb = new DatabaseHelper(this);

        name = nameEditText.getText().toString();
        location = locationEditText.getText().toString();
        range = rangeEditText.getText().toString();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameEditText.getText().toString();
                location = locationEditText.getText().toString();
                range = rangeEditText.getText().toString();

                AddData(name, location, range);
                nameEditText.setText("");
                locationEditText.setText("");
                rangeEditText.setText("");
            }
        });
    }

    public void AddData(String name, String username, String password) {
        boolean insertData = myDb.addData(name, username, password);

        if (insertData) {
            toastMessage("Data successfully inserted.");
        }
    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}
