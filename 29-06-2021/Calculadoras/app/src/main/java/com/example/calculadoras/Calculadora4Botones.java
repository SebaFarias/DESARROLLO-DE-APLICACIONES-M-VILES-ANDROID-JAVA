package com.example.calculadoras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculadora4Botones extends AppCompatActivity {

    private EditText et1, et2;
    private Button limpiarBtn, sumarBtn, restarBtn, multiBtn, diviBtn;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora4_botones);
        et1 = findViewById(R.id.Check_et1);
        et2 = findViewById(R.id.Check_et2);
        limpiarBtn = findViewById(R.id.limpiarBtn);
        sumarBtn = findViewById(R.id.sumarBtn);
        restarBtn = findViewById(R.id.restarBtn);
        multiBtn = findViewById(R.id.multiBtn);
        diviBtn = findViewById(R.id.diviBtn);
        tvResultado = findViewById(R.id.tvResultado);

    }
    private int leer(EditText numero){
        try{
            return Integer.parseInt(numero.getText().toString());
        }catch (Exception err){
            Toast.makeText(this,err.getMessage(),Toast.LENGTH_SHORT).show();
            return 0;
        }
    }
    public void limpiar( View v ){
        et1.setText(null);
        et2.setText(null);
        tvResultado.setText(getString(R.string.resultado_default));
    }
    public void sumar( View v ){
        int val1 = leer(et1);
        int val2 = leer(et2);
        int sum = val1 + val2;
        tvResultado.setText("Suma: " + sum);
    }
    public void restar( View v ){
        int val1 = leer(et1);
        int val2 = leer(et2);
        int res = val1 - val2;
        tvResultado.setText("Resta: " + res);
    }
    public void multiplicar( View v ){
        int val1 = leer(et1);
        int val2 = leer(et2);
        int multi = val1 * val2;
        tvResultado.setText("Multiplicación: " + multi);
    }
    public void dividir( View v ){
        int val1 = leer(et1);
        int val2 = leer(et2);
        if(0==val2){
            Toast.makeText(this,"No se puede dividir por 0",Toast.LENGTH_LONG).show();
            tvResultado.setText(getString(R.string.resultado_default));
        }else{
            double div = ((double)val1) / val2;
            tvResultado.setText("División: " + div);
        }
    }
    public void volver(View V){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}