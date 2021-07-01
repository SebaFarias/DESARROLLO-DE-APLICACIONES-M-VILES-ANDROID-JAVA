package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Buscar extends AppCompatActivity {

    EditText etCodigo;
    TextView tvNombre, tvPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        etCodigo = findViewById(R.id.etCodigo_modificar);
        tvNombre = findViewById(R.id.tvNombreEncontrado_modificar);
        tvPrecio = findViewById(R.id.tvPrecioEncontrado_modificar);
    }
    public void volver ( View V ) {
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
    }
    public void buscar ( View V ) {
        AdminBD admin = new AdminBD(this, "Productos", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = etCodigo.getText().toString();

        if(codigo.isEmpty()){
            Toast.makeText(this, getString(R.string.missing_code),Toast.LENGTH_LONG).show();
        }else{
            Cursor registro = base.rawQuery("select nombre, precio from producto where codigo ="+codigo,null);
            if(registro.moveToFirst()){
                tvNombre.setText(registro.getString(0));
                tvPrecio.setText(registro.getString(1));
                registro.close();
                base.close();
            }else{
                Toast.makeText(this,getString(R.string.not_found),Toast.LENGTH_LONG).show();
            }
        }
    }
}