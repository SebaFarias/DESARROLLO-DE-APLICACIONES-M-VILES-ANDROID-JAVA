package com.example.inventario;

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

    public void crear(View V){
        Intent crearView = new Intent(this, Crear.class );
        startActivity( crearView );
    }
    public void buscar ( View V ) {
        Intent buscarView = new Intent(this, Buscar.class );
        startActivity( buscarView );
    }
    public void modificar ( View V ) {
        Intent modificarView = new Intent(this, Modificar.class );
        startActivity( modificarView );
    }
    public void eliminar ( View V ) {
        Intent eliminarView = new Intent( this, Eliminar.class );
        startActivity( eliminarView );
    }
}