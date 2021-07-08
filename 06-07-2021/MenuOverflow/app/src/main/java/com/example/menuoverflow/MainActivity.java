package com.example.menuoverflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuoverflow,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int itemId = item.getItemId();
        if(itemId == R.id.op1){
            Toast.makeText(this,"Seleccionaste la opción 1",Toast.LENGTH_SHORT).show();
        }else if(itemId == R.id.op2){
            Toast.makeText(this,"Seleccionaste la opción 2",Toast.LENGTH_SHORT).show();
        }else if(itemId == R.id.op3){
            Toast.makeText(this, "Seleccionaste la opción 3",Toast.LENGTH_SHORT).show();
        }else if(itemId == R.id.op4){
            Toast.makeText(this, "Seleccionaste la opción 4",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}