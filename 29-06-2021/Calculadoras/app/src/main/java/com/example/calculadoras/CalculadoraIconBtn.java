package com.example.calculadoras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraIconBtn extends AppCompatActivity {

    EditText input1, input2;
    ImageButton volverBtn, masBtn, menosBtn, timesBtn, divideBtn;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_icon_btn);
        input1 = findViewById(R.id.Icon_et1);
        input2 = findViewById(R.id.Icon_et2);
        masBtn = findViewById(R.id.Icon_sumaBtn);
        menosBtn = findViewById(R.id.Icon_restarBtn);
        timesBtn = findViewById(R.id.Icon_multiBtn);
        divideBtn = findViewById(R.id.Icon_diviBtn);
        resultado = findViewById(R.id.Icon_resultado);
    }
    private int leer (EditText numero){
        try{
            return Integer.parseInt(numero.getText().toString());
        }catch(Exception err){
            return 0;
        }
    }
    public void sumar(View V){
        int num1 = leer(input1);
        int num2 = leer(input2);
        int sum = num1 + num2;
        resultado.setText("Suma: " + sum);
    }
    public void restar(View V){
        int num1 = leer(input1);
        int num2 = leer(input2);
        int res = num1 - num2;
        resultado.setText("Resta: " + res);
    }
    public void multiplicar(View V){
        int num1 = leer(input1);
        int num2 = leer(input2);
        int mult = num1 * num2;
        resultado.setText("Multiplicación: " + mult);
    }
    public void dividir(View V) {
        int num1 = leer(input1);
        int num2 = leer(input2);
        if( num2 == 0){
            Toast.makeText(this,"No se puede dividir por 0", Toast.LENGTH_LONG).show();
        }else{
            double divide = ((double) num1) / num2;
            resultado.setText("División: " + divide);
        }
    }
    public void volver(View V){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}