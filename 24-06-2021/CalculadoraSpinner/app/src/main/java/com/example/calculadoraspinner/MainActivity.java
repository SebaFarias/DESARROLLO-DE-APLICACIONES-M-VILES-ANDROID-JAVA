package com.example.calculadoraspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private Spinner sp1;
    private EditText edit1, edit2;
    private TextView tv1;
    private final String[] operaciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp1 = findViewById(R.id.spinner);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        tv1 = findViewById(R.id.textView);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,operaciones);
        sp1.setAdapter(adaptador);
    }
    private int leer(EditText numero){
        try{
            return Integer.parseInt(numero.getText().toString());
        }catch(Exception err){
            return 0;
        }
    }
    public void limpiar(View V){
        edit1.setText(null);
        edit2.setText(null);
        tv1.setText(getString(R.string.tv1));
    }
    public void operar( View V ){

        String op = sp1.getSelectedItem().toString();
        int num1 = leer(edit1);
        int num2 = leer(edit2);

        if(op == "Sumar"){
            int sum = num1 + num2;
            tv1.setText("La suma es: " + sum);
        }else if(op == "Restar"){
            int res = num1 - num2;
            tv1.setText("La resta es: " + res);
        }else if(op == "Multiplicar"){
            int multi = num1 * num2;
            tv1.setText("La multiplicacion es: " + multi);
        }else if(op == "Dividir"){
            if(num2 == 0){
                Toast.makeText(this,"No se puede dividir por 0", Toast.LENGTH_LONG).show();
            }else{
                double divi = ((double) num1) / num2;
                tv1.setText("La división es: " + divi);
            }
        }
    }

}