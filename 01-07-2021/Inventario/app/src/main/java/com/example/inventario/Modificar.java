package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Modificar extends AppCompatActivity {

    EditText etCodigo, etNombre, etPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        etCodigo = findViewById(R.id.etCodigo_modificar);
        etNombre = findViewById(R.id.etNombre_modificar);
        etPrecio = findViewById(R.id.etPrecio_modificar);
    }
    public void volver ( View V ) {
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
    }
    public void ver ( View V ) {
        AdminBD admin = new AdminBD(this, "Productos", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = etCodigo.getText().toString();
        if(codigo.isEmpty()){
            Toast.makeText(this, getString(R.string.missing_code),Toast.LENGTH_LONG).show();
        }else{
            Cursor line = base.rawQuery("select nombre, precio from producto where codigo =" + codigo,null);
            if(line.moveToFirst()){
                etNombre.setText(line.getString(0));
                etPrecio.setText(line.getString(1));
                line.close();
                base.close();
            }else{
                Toast.makeText(this, getString(R.string.not_found),Toast.LENGTH_LONG).show();
            }
        }
    }
    public void modificar ( View V ) {
        AdminBD admin = new AdminBD(this, "Productos", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = etCodigo.getText().toString();
        String nombre = etNombre.getText().toString();
        String precio = etPrecio.getText().toString();

        if(codigo.isEmpty() || nombre.isEmpty() || precio.isEmpty()){
            Toast.makeText(this,getString(R.string.campos_incompletos), Toast.LENGTH_LONG).show();
        }else{
            try{
                ContentValues modificado = new ContentValues();
                modificado.put("codigo",codigo);
                modificado.put("nombre",nombre);
                modificado.put("precio",precio);
                int count = base.update("producto",modificado,"codigo ="+codigo,null);
                base.close();
                if(count == 1) {
                    Toast.makeText(this, getString(R.string.modificado), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, getString(R.string.not_found),Toast.LENGTH_LONG).show();
                }
            }catch(Exception err){
                String errorMessage = err.getMessage();
                Toast.makeText(this, errorMessage,Toast.LENGTH_LONG).show();
            }
        }
    }
}