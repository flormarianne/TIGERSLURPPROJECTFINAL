package ph.edu.ust.jatallas.project;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.Spinner;

public class Welcomepage extends AppCompatActivity{

    Button random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);

        random = (Button)findViewById(R.id.random);


        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(getApplicationContext(), PopRandom.class);
                startActivity(i);

            }
        });


        Button milk = (Button) findViewById(R.id.milktea);
        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent milk = new Intent(getApplicationContext(), Milktea.class);
                startActivity(milk);
            }
        });

        Button lemon = (Button) findViewById(R.id.lemon);
        lemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lemon = new Intent(getApplicationContext(), Lemonade.class);
                startActivity(lemon);
            }
        });

        Button fruit = (Button) findViewById(R.id.fruit);
        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fruit = new Intent(getApplicationContext(), FruitJuice.class);
                startActivity(fruit);
            }
        });

        Button frappe = (Button) findViewById(R.id.frappe);
        frappe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent frappe = new Intent(getApplicationContext(), Frappe.class);
                startActivity(frappe);
            }
        });

        Button alcohol = (Button) findViewById(R.id.alcohol);
        alcohol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alcohol = new Intent(getApplicationContext(), Alcohol.class);
                startActivity(alcohol);
            }
        });

        Button choco = (Button) findViewById(R.id.choco);
        choco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent choco = new Intent(getApplicationContext(), ChocoDrink.class);
                startActivity(choco);
            }
        });

        Button coffee = (Button) findViewById(R.id.cotea);
        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent coffee = new Intent(getApplicationContext(), CoffeeTea.class);
                startActivity(coffee);
            }
        });

        Button smooth = (Button) findViewById(R.id.smooth);
        smooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smooth= new Intent(getApplicationContext(), Smoothies.class);
                startActivity(smooth);
            }
        });

        Button mock = (Button) findViewById(R.id.mock);
        mock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mock = new Intent(getApplicationContext(), Mocktails.class);
                startActivity(mock);
            }
        });

        Button soda = (Button) findViewById(R.id.soda);
        soda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent soda = new Intent(getApplicationContext(), Soda.class);
                startActivity(soda);
            }
        });

        Button admin = (Button) findViewById(R.id.admin);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent admin = new Intent(getApplicationContext(), Login.class);
                startActivity(admin);
            }
        });
    }
}
