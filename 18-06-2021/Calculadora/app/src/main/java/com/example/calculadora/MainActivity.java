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
    public void sumar(View V){
        int num1 = Integer.parseInt(input1.getText().toString());
        int num2 = Integer.parseInt(input2.getText().toString());
        int sum = num1 + num2;
        resultado.setText("El resultado es : " + sum);
    }
    public void restar(View V){
        int num1 = Integer.parseInt(input1.getText().toString());
        int num2 = Integer.parseInt(input2.getText().toString());
        int res = num1 - num2;
        resultado.setText("El resultado es : " + res);
    }
    public void multiplicar(View V){
        int num1 = Integer.parseInt(input1.getText().toString());
        int num2 = Integer.parseInt(input2.getText().toString());
        int mult = num1 * num2;
        resultado.setText("El resultado es : " + mult);
    }
    public void dividir(View V) {
        int num1 = Integer.parseInt(input1.getText().toString());
        int num2 = Integer.parseInt(input2.getText().toString());
        if( num2 == 0){
            resultado.setText("Error: División por 0.");
        }else{
            int divide = num1 / num2;
            resultado.setText("El resultado es : " + divide);
        }
    }
}