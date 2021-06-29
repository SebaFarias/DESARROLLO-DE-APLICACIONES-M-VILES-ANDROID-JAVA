package com.example.calculadoracheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private CheckBox sumaCheck, restaCheck, multiCheck, diviCheck;
    private TextView sumaResultado, restaResultado, multiResultado, diviResultado;
    public Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        sumaCheck = findViewById(R.id.sumaCheck);
        sumaResultado = findViewById(R.id.sumaResultado);
        restaCheck = findViewById(R.id.restaCheck);
        restaResultado = findViewById(R.id.restaResultado);
        multiCheck = findViewById(R.id.multiCheck);
        multiResultado = findViewById(R.id.multiResultado);
        diviCheck = findViewById(R.id.diviCheck);
        diviResultado = findViewById(R.id.diviResultado);
        calcularButton = findViewById(R.id.calcularButton);
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
            int sum = num1 + num2 ;
            sumaResultado.setText("Suma: "+sum);
        }
        if(restaCheck.isChecked()){
            int res = num1 - num2;
            restaResultado.setText("Resta: "+res);
        }
        if(multiCheck.isChecked()){
            int multi = num1 * num2;
            multiResultado.setText("Multi: "+multi);
        }
        if(diviCheck.isChecked()){
            if(0 == num2){
                Toast.makeText(this, "No se puede dividir por 0",Toast.LENGTH_LONG).show();
            }else{
                double divi = ((double) num1) / num2;
                diviResultado.setText("Divi: "+divi);
            }

        }
    }
}