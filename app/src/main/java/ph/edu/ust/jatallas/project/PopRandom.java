package ph.edu.ust.jatallas.project;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class PopRandom extends Activity {
    Button close;
    TextView randomdrink;
    String options[] = {"Milktea", "Alcohol", "Choco Drink", "Cofee or Tea", "Frappe", "Fruit Juice", "Lemonade", "Mocktails", "Smoothies", "Soda" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_random);

        randomdrink = (TextView)findViewById(R.id.randomdrink);

        Random randGen = new Random();
        final int rando = randGen.nextInt(10);
        randomdrink.setText(options[rando] + "!");


        close = (Button)findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        DisplayMetrics dn = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dn);

        int width = dn.widthPixels;
        int height = dn.heightPixels;

        getWindow().setLayout((int)(width*.6), (int)(height*.5));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);
    }
}
