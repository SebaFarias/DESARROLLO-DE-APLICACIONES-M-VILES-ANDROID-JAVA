package com.example.calcuadora4botones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    TextView tvResultado;
    Button sumarBtn, restarBtn, multiBtn, diviBtn, limpiarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tvResultado = findViewById(R.id.tvResultado);
        sumarBtn = findViewById(R.id.sumarBtn);
        restarBtn = findViewById(R.id.restarBtn);
        multiBtn = findViewById(R.id.multiBtn);
        diviBtn = findViewById(R.id.diviBtn);
        limpiarBtn = findViewById(R.id.limpiarBtn);
    }
    private int leer(EditText number){
        try{
            return Integer.parseInt(number.getText().toString());
        }catch(Exception error){
            return 0;
        }
    }
    public void sumar(View V){
        int val1 = leer(et1);
        int val2 = leer(et2);
        int sum = val1 + val2;
        tvResultado.setText("Suma: " + sum);
    }
    public void restar(View V){
        int val1 = leer(et1);
        int val2 = leer(et2);
        int res = val1 - val2;
        tvResultado.setText("Resta: " + res);
    }
    public void multiplicar(View V){
        int val1 = leer(et1);
        int val2 = leer(et2);
        int multi = val1 * val2;
        tvResultado.setText("Multiplicación: " + multi);
    }
    public void dividir(View V){
        int val1 = leer(et1);
        int val2 = leer(et2);
        if( 0 == val2){
            tvResultado.setText("No se puede dividir por cero");
        }else{
            double divi = ((double)val1) / val2;
            tvResultado.setText("División: " + divi);
        }
    }
    public void limpiar(View V){
        et1.setText(null);
        et2.setText(null);
        tvResultado.setText(getString(R.string.resultado_default));
    }
}