package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

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
    public void calcular(View V){
        int num1 = Integer.parseInt(input1.getText().toString());
        int num2 = Integer.parseInt(input2.getText().toString());
        if(sumaRadio.isChecked()){
            int sum = num1 + num2;
            mostrarResultado(V,sum);
        }if(restaRadio.isChecked()){
            int resta = num1 - num2;
            mostrarResultado(V,resta);
        }if(multiRadio.isChecked()){
            int multi = num1 * num2;
            mostrarResultado(V,multi);
        }if(divideRadio.isChecked()){
            if(num2 == 0){
                resultado.setText("Error: División por 0.");
            }else{
                double divide = num1 / num2;
                resultado.setText("El resultado es :" + divide);
            }
        }
    }
    private void mostrarResultado( View V, int res){
        resultado.setText( "El resultado es: " + res);
    }
}