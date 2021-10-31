package com.example.sebagato;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sebagato.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        b.reiniciarBtn.setOnClickListener( v -> {

        });
    }
}