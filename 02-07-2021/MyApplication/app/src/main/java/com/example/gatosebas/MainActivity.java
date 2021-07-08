package com.example.gatosebas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

    ImageButton btn11, btn12, btn13, btn21, btn22, btn23, btn31, btn32, btn33;
    private final Drawable circulo = getDrawable(R.drawable.circulo);
    private final Drawable cruz = getDrawable(R.drawable.cruz);
    private final Drawable vacio = getDrawable(R.drawable.vacio);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn13 = findViewById(R.id.btn13);
        btn21 = findViewById(R.id.btn21);
        btn22 = findViewById(R.id.btn22);
        btn23 = findViewById(R.id.btn23);
        btn31 = findViewById(R.id.btn31);
        btn32 = findViewById(R.id.btn32);
        btn33 = findViewById(R.id.btn33);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void cambiarCelda (View V, ImageButton celda, Drawable imagen) {
        celda.setBackground(imagen);
    }
    public void limpiarTablero(View V) {
        cambiarCelda( V, btn11, vacio);
        cambiarCelda( V, btn12, vacio);
        cambiarCelda( V, btn13, vacio);
        cambiarCelda( V, btn21, vacio);
        cambiarCelda( V, btn22, vacio);
        cambiarCelda( V, btn23, vacio);
        cambiarCelda( V, btn31, vacio);
        cambiarCelda( V, btn32, vacio);
        cambiarCelda( V, btn33, vacio);
    }

}