package com.enrike.parciali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText va, vb, vc;
    Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargar();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val1 = va.getText().toString();
                String val2 = vb.getText().toString();
                String val3 = vc.getText().toString();

                if (val1.length()==0 || val2.length()==0 || val3.length()==0){
                    Toast.makeText(getApplicationContext(),"Ingrese todos los valores", Toast.LENGTH_SHORT).show();
                }else{
                    int a = Integer.parseInt(val1);
                    int b = Integer.parseInt(val2);
                    int c = Integer.parseInt(val3);
                    double x1, x2, delta;
                    if (a==0){
                        Toast.makeText(getApplicationContext(),"El valor de a no puede ser 0", Toast.LENGTH_SHORT).show();
                    }else{

                        delta = Math.pow(b, 2) - 4*a*c;
                        if (delta<0){
                            Toast.makeText(getApplicationContext(),"La ecuación no tiene ninguna solución para X", Toast.LENGTH_LONG).show();
                        }else {
                            x1 = (-b+(Math.pow(delta, 0.5)))/2*a;
                            x2 = (-b-(Math.pow(delta, 0.5)))/2*a;

                            Intent ventana2 = new Intent(getApplicationContext(), MainActivity2.class);
                            ventana2.putExtra("a", a);
                            ventana2.putExtra("b", b);
                            ventana2.putExtra("c", c);
                            ventana2.putExtra("x1", x1);
                            ventana2.putExtra("x2", x2);
                            startActivity(ventana2);
                            finish();
                        }
                    }

                }
            }
        });

    }

    public void cargar(){
        va = findViewById(R.id.valora);
        vb = findViewById(R.id.valorb);
        vc = findViewById(R.id.valorc);
        calc = findViewById(R.id.calcular);
    }

}