package com.example.saludo2activityes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = findViewById(R.id.etNombre);
    }

    public void saludar(View V){
        String nombre = etNombre.getText().toString();
        if(nombre.isEmpty()){
            Toast.makeText(this, "Necesito tu nombre", Toast.LENGTH_SHORT).show();
        }else {
            Intent i = new Intent(this, MainActivity2.class);
            i.putExtra("nombre", nombre);
            startActivity(i);
        }
    }
}