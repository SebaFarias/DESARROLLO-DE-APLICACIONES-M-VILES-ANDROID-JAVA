package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Buscar extends AppCompatActivity {

    EditText etCodigo;
    TextView tvNombre, tvPrecio;
    Spinner sp1;
    ArrayList<Producto> listaProductos;
    ArrayList<String> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        etCodigo = findViewById(R.id.etCodigo_modificar);
        tvNombre = findViewById(R.id.tvNombreEncontrado_modificar);
        tvPrecio = findViewById(R.id.tvPrecioEncontrado_modificar);
        sp1 = findViewById(R.id.spinner_buscar);
        listaProductos = new ArrayList<Producto>();
        listaProductos.add(new Producto(567,"Perro",948.35));
        consultarListaProductos();
        sp1.setAdapter(getAdapter());
    }
    public void volver ( View V ) {
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
    }

    public Producto consultarProducto ( String codigo ) {
        if(codigo.isEmpty()){ return null; }

        AdminBD admin = new AdminBD(this, "Productos", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        Cursor producto = base.rawQuery("select nombre, precio from producto where codigo ="+codigo, null);
        if(producto.moveToFirst()){
            int codigoP = Integer.parseInt(codigo);
            Producto p1 = new Producto(codigoP, producto.getString(0),producto.getDouble(1));
            producto.close();
            base.close();
            return p1;
        }else{return null;}
    }

    public void buscar ( View V ) {

        Boolean selected = sp1.isSelected();
        String codigo;

        if(selected){
            String item = sp1.getSelectedItem().toString();
            codigo = item.substring(0,item.indexOf("-")-1);
        }else{
            codigo = etCodigo.getText().toString();
        }
        if(codigo.isEmpty()){
            Toast.makeText(this, getString(R.string.missing_code),Toast.LENGTH_LONG).show();
        }else{
            Producto productoEncontrado = consultarProducto(codigo);
            if(productoEncontrado != null){
                tvNombre.setText(productoEncontrado.getNombre());
                tvPrecio.setText(""+productoEncontrado.getPrecio());
            }else{
                Toast.makeText(this,getString(R.string.not_found),Toast.LENGTH_LONG).show();
            }
        }
    }

    public void consultarListaProductos(){
       AdminBD admin = new AdminBD(this,"Productos",null,1);
       SQLiteDatabase base = admin.getWritableDatabase();
       Cursor fila = base.rawQuery("select * from producto",null);
       while(fila.moveToFirst()){
           Toast.makeText(this, fila.getString(1), Toast.LENGTH_SHORT).show();
       }
       fila.close();
       base.close();
    }

    public String[] obtenerProductos(){
        String lista[] = new String[listaProductos.size()];

        for(int i = 0; i<this.listaProductos.size();i++){
            String data = listaProductos.get(i).getCodigo() + " - " + listaProductos.get(i).getNombre();
            lista[i] = data;
        }

        return lista;
    }

    public ArrayAdapter<String> getAdapter(){
        String lista [] = obtenerProductos();
        ArrayAdapter<String> adapter = new ArrayAdapter<> (this, android.R.layout.simple_spinner_item,lista);
        return adapter;
    }
}