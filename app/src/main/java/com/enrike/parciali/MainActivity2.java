package com.enrike.parciali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView resultado;
    Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        int a =extras.getInt("a");
        int b =extras.getInt("b");
        int c = extras.getInt("c");
        double x1 = extras.getDouble("x1");
        double x2 = extras.getDouble("x2");

        resultado = findViewById(R.id.mostrar);
        menu = findViewById(R.id.volver);
        resultado.setText("Para la función con valores:\na= "+a+" \nb= "+b+"\nc= "+c+"\nX1= "+x1+"\nX2= "+x2);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent principal = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(principal);
                finish();
            }
        });

    }
}