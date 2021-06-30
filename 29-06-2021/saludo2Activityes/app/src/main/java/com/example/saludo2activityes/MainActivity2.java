package com.example.saludo2activityes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView saludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        saludo = findViewById(R.id.tvSaludo);
        String nombre = getIntent().getStringExtra("nombre");
        saludo.setText(getString(R.string.saludo)+" " +nombre+"!");
    }

    public void volver(View V){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}