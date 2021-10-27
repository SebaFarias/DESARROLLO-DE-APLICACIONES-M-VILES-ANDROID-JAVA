package com.example.calculadoras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void simple( View V ) {
        Intent simple = new Intent(this, Calculadora4Botones.class);
        startActivity(simple);
    }
    public void imageBtns( View V ) {
        Intent imageBtns = new Intent(this, CalculadoraIconBtn.class);
        startActivity(imageBtns);
    }
    public void checkBoxes( View V ) {
        Intent checkBoxes = new Intent( this, CalculadoraCheckbox.class);
        startActivity(checkBoxes);
    }
    public void radioBtns ( View V) {
        Intent radioBtns = new Intent(this, CalculadoraRadio.class);
        startActivity(radioBtns);
    }
    public void spinner ( View V) {
        Intent spinner = new Intent(this, CalculadoraSpinner.class);
        startActivity(spinner);
    }
}