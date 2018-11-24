package ph.edu.ust.jatallas.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText uname;
    private EditText pword;
    private TextView attempt;
    private Button login;
    SharedPreferences sharedPreferences;
    private CheckBox remember;
    private static final String PREF_NAME = "prefs";
    int counter = 5;
    String username = "";
    String password = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uname = (EditText) findViewById(R.id.username);
        pword = (EditText) findViewById(R.id.password);
        attempt = (TextView) findViewById(R.id.info);
        login = (Button) findViewById(R.id.loginb);
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        remember = findViewById(R.id.remember);

        displayData();


        Button home = (Button) findViewById(R.id.returnHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(getApplicationContext(), Welcomepage.class);
                startActivity(home);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(uname.getText().toString(), pword.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPass){
        if(userName.equals("admin") && userPass.equals("1234")){
            if(remember.isChecked()){
                saveCredentials();
            }
            Intent intent = new Intent(Login.this, Database.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(Login.this, "Username and password is incorrect.", Toast.LENGTH_SHORT).show();
            counter--;


            if(counter == 0){
                login.setEnabled(false);
            }
        }
    }

    private void saveCredentials(){
        username = uname.getText().toString().trim();
        password = pword.getText().toString().trim();
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = sharedPref.edit();

        edit.putString("username", username);
        edit.putString("password", password);
        edit.commit();

    }

    private void displayData(){
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        String username = sharedPref.getString("username", "");
        String password = sharedPref.getString("password", "");

        uname.setText(username);
        pword.setText(password);
    }



    }

