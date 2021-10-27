package com.example.usardb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etCodigo, etNombre, etPrecio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCodigo = findViewById(R.id.etCodigo);
        etNombre = findViewById(R.id.etNombre);
        etPrecio = findViewById(R.id.etPrecio);
    }
    public void limpiar( View V ){
        etCodigo.setText(null);
        etNombre.setText(null);
        etPrecio.setText(null);
    }
    public void crear( View V ) {

        AdminDB admin = new AdminDB(this, "Productos", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigoProducto = etCodigo.getText().toString();
        String nombreProducto = etNombre.getText().toString();
        String precioProducto = etPrecio.getText().toString();

        if(!codigoProducto.isEmpty() && !nombreProducto.isEmpty() && !precioProducto.isEmpty()){

            ContentValues nuevo = new ContentValues();
            nuevo.put("codigo",codigoProducto);
            nuevo.put("nombre",nombreProducto);
            nuevo.put("precio",precioProducto);
            base.insert("producto", null, nuevo);
            base.close();
            limpiar(V);

            Toast.makeText(this, "Producto agregado Correctamente", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
        }

    }
    public void buscar( View V ) {

        AdminDB admin = new AdminDB(this, "Productos", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigoProducto = etCodigo.getText().toString();

        if(!codigoProducto.isEmpty()){

            Cursor fila = base.rawQuery("select nombre,precio from producto where codigo="+codigoProducto,null);
            if(fila.moveToFirst()){
                etNombre.setText(fila.getString(0));
                etPrecio.setText((fila.getString(1)));
                fila.close();
                base.close();

            }else{
                Toast.makeText(this, "No existe un producto con código "+codigoProducto, Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "Ingrese un código de Producto para buscar", Toast.LENGTH_LONG).show();
        }
    }
    public void modificar( View V){

        AdminDB admin = new AdminDB( this, "Productos", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigoProducto = etCodigo.getText().toString();
        String nombreProducto = etNombre.getText().toString();
        String precioProducto = etPrecio.getText().toString();

        if(codigoProducto.isEmpty() || nombreProducto.isEmpty() || precioProducto.isEmpty()){
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
        }else{
            ContentValues actualizado = new ContentValues();
            actualizado.put("codigo",codigoProducto);
            actualizado.put("nombre",nombreProducto);
            actualizado.put("precio",precioProducto);
            base.update("producto",actualizado,"codigo =" + codigoProducto, null);
            base.close();
            Toast.makeText(this,"Produco modificado correctamente", Toast.LENGTH_LONG).show();
        }
    }
    public void eliminar( View V){

        AdminDB admin = new AdminDB( this, "Productos", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigoProducto = etCodigo.getText().toString();
        if(codigoProducto.isEmpty()){
            Toast.makeText(this, "Ingrese el código del producto que quiere eliminar", Toast.LENGTH_LONG).show();
        }else{
            base.delete("producto","codigo="+codigoProducto,null);
            base.close();
            limpiar(V);
            Toast.makeText(this, "Producto eliminado correctamente", Toast.LENGTH_LONG).show();
        }

    }
}