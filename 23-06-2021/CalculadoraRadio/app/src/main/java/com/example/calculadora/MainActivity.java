package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText input1, input2;
    private Button calcular;
    private RadioButton sumaRadio, restaRadio, multiRadio, divideRadio;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        calcular = findViewById(R.id.calcularBtn);
        sumaRadio = findViewById(R.id.sumaRadio);
        restaRadio = findViewById(R.id.restaRadio);
        multiRadio = findViewById(R.id.multiRadio);
        divideRadio = findViewById(R.id.divideRadio);
        resultado = findViewById(R.id.resultado);
    }
    private int leer( EditText numero){
        try{
            return Integer.parseInt(numero.getText().toString());
        }catch(Exception err){
            return 0;
        }
    }
    public void calcular(View V){
        int num1 = leer(input1);
        int num2 = leer(input2);
        if(sumaRadio.isChecked()){
            int sum = num1 + num2;
            resultado.setText("Suma: " + sum);
        }if(restaRadio.isChecked()){
            int resta = num1 - num2;
            resultado.setText("Resta: " + resta);
        }if(multiRadio.isChecked()){
            int multi = num1 * num2;
            resultado.setText("Multiplicación: " + multi);
        }if(divideRadio.isChecked()){
            if(num2 == 0){
                Toast.makeText(this, "No se puede dividir por 0", Toast.LENGTH_LONG).show();
            }else{
                double divide = ((double)num1) / num2;
                resultado.setText("División :" + divide);
            }
        }
    }
}