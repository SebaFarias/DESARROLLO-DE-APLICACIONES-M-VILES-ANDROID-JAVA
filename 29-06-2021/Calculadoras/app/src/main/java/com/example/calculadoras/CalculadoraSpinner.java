package com.example.calculadoras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraSpinner extends AppCompatActivity {

    private Spinner sp1;
    private EditText edit1, edit2;
    private TextView tv1;
    private final String[] operaciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_spinner);
        sp1 = findViewById(R.id.spinner);
        edit1 = findViewById(R.id.Spinner_et1);
        edit2 = findViewById(R.id.Spinner_et2);
        tv1 = findViewById(R.id.Spinner_tvResultado);

        ArrayAdapter <String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,operaciones);
        sp1.setAdapter(adaptador);
    }
    private int leer(EditText numero){
        try{
            return Integer.parseInt(numero.getText().toString());
        }catch(Exception err){
            return 0;
        }
    }
    public void operar(View V){
        String op = sp1.getSelectedItem().toString();
        int num1 = leer(edit1);
        int num2 = leer(edit2);
        switch(op){
            case "Sumar":
                int sum = num1 + num2;
                tv1.setText("Suma: " + sum);
                break;
            case "Restar":
                int res = num1 - num2;
                tv1.setText("Resta: " + res);
                break;
            case "Multiplicar":
                int multi = num1 * num2;
                tv1.setText("Multiplicación: " + multi);
                break;
            case "Dividir" :
                if(0 == num2){
                    Toast.makeText(this, "No se puede dividir por 0",Toast.LENGTH_LONG).show();
                }else{
                    double divi = ((double) num1) / num2;
                    tv1.setText("División: " + divi);
                }
                break;
            default:
                Toast.makeText(this, "Escoge una Operación",Toast.LENGTH_LONG).show();

        }
    }
    public void volver(View V){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void limpiar(View V){
        edit1.setText(null);
        edit2.setText(null);
        tv1.setText(getString(R.string.resultado_default));
    }
}