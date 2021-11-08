package com.example.gatosebas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.gatosebas.databinding.ActivityMainBinding;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding b;

    private final Drawable circulo = getDrawable(R.drawable.circulo);
    private final Drawable cruz = getDrawable(R.drawable.cruz);
    private final Drawable vacio = getDrawable(R.drawable.vacio);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

    }

}