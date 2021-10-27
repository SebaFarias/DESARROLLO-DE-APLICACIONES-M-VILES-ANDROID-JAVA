package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input1, input2;
    ImageButton masBtn, menosBtn, timesBtn, divideBtn;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        masBtn = findViewById(R.id.masBtn);
        menosBtn = findViewById(R.id.menosBtn);
        timesBtn = findViewById(R.id.timesBtn);
        divideBtn = findViewById(R.id.divideBtn);
        resultado = findViewById(R.id.resultado);
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
        resultado.setText("El resultado es : " + sum);
    }
    public void restar(View V){
      int num1 = leer(input1);
      int num2 = leer(input2);
        int res = num1 - num2;
        resultado.setText("El resultado es : " + res);
    }
    public void multiplicar(View V){
      int num1 = leer(input1);
      int num2 = leer(input2);
        int mult = num1 * num2;
        resultado.setText("El resultado es : " + mult);
    }
    public void dividir(View V) {
      int num1 = leer(input1);
      int num2 = leer(input2);
        if( num2 == 0){
            Toast.makeText(this,"No se puede dividir por 0", Toast.LENGTH_LONG).show();
        }else{
            double divide = ((double) num1) / num2;
            resultado.setText("El resultado es : " + divide);
        }
    }
}