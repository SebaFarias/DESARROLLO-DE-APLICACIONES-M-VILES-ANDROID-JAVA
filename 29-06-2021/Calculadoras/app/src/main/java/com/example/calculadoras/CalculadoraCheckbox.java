package com.example.calculadoras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraCheckbox extends AppCompatActivity {

    private EditText et1, et2;
    private CheckBox sumaCheck, restaCheck, multiCheck, diviCheck;
    private TextView sumaResultado, restaResultado, multiResultado, diviResultado;
    public Button calcularButton, volverButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_checkbox);
        et1 = findViewById(R.id.Check_et1);
        et2 = findViewById(R.id.Check_et2);
        sumaCheck = findViewById(R.id.sumaCheck);
        restaCheck = findViewById(R.id.restaCheck);
        multiCheck = findViewById(R.id.multiCheck);
        diviCheck = findViewById(R.id.diviCheck);
        sumaResultado = findViewById(R.id.sumaResultado);
        restaResultado = findViewById(R.id.restaResultado);
        multiResultado = findViewById(R.id.multiResultado);
        diviResultado = findViewById(R.id.diviResultado);
        calcularButton = findViewById(R.id.volverBtn);
        volverButton = findViewById(R.id.Check_volverBtn);
    }
    private int leer(EditText numero){
        try{
            return Integer.parseInt(numero.getText().toString());
        }catch(Exception err){
            return 0;
        }
    }
    public void calcular(View V){
        int num1 = leer(et1);
        int num2 = leer(et2);
        if(sumaCheck.isChecked()){
            int sum = num1 + num2;
            sumaResultado.setText("Suma: " + sum);
        }
        if(restaCheck.isChecked()){
            int res = num1 - num2;
            restaResultado.setText("Resta: " + res);
        }
        if(multiCheck.isChecked()){
            int multi = num1 * num2;
            multiResultado.setText("Multi: " + multi);
        }
        if(diviCheck.isChecked()){
            if(num2 == 0){
                Toast.makeText(this,"No se puede dividir por 0", Toast.LENGTH_LONG).show();
            }
            else{
                double divi = ((double) num1) / num2;
                diviResultado.setText("Divi: " + divi);
            }
        }
    }
    public void volver( View V){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}