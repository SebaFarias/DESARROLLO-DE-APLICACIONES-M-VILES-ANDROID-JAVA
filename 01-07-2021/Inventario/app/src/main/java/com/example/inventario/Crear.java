package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Crear extends AppCompatActivity {

    EditText etCodigo, etNombre, etPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        etCodigo = findViewById(R.id.etCodigo_crear);
        etNombre = findViewById(R.id.etNombre_crear);
        etPrecio = findViewById(R.id.etPrecio_crear);
    }
    public void volver ( View V ){
        Intent inicio = new Intent( this, MainActivity.class);
        startActivity(inicio);
    }
    public void limpiar ( View V ) {
        etCodigo.setText(null);
        etNombre.setText(null);
        etPrecio.setText(null);
    }
    public void crear ( View V ) {
        AdminBD admin = new AdminBD(this, "Productos", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = etCodigo.getText().toString();
        String nombre = etNombre.getText().toString();
        String precio = etPrecio.getText().toString();

        if( codigo.isEmpty() || nombre.isEmpty() || precio.isEmpty() ){
            Toast.makeText(this, getString(R.string.campos_incompletos), Toast.LENGTH_LONG).show();
        }else{
            try{
                ContentValues nuevo = new ContentValues();
                nuevo.put("codigo",codigo);
                nuevo.put("nombre",nombre);
                nuevo.put("precio",precio);
                base.insert("producto",null,nuevo);
                base.close();
                limpiar(V);
                Toast.makeText(this,getString(R.string.creado),Toast.LENGTH_LONG).show();
            }catch(Exception err){
                String errorMessage = err.getMessage();
                Toast.makeText(this,errorMessage,Toast.LENGTH_SHORT).show();
            }
        }
    }
}