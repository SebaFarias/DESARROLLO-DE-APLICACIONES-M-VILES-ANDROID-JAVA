package com.example.controlswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch s1, s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1 = findViewById(R.id.switch1);
        s2 = findViewById(R.id.switch2);
    }
    public void saludar(View V){
        if(s1.isChecked()){
            Toast.makeText(this,"Hola, Como estás?",Toast.LENGTH_LONG).show();
        }
    }
    public void despedida(View V){
        if(s2.isChecked()){
            Toast.makeText(this,"Adios, que te vaya bien!",Toast.LENGTH_LONG).show();
        }
    }
}