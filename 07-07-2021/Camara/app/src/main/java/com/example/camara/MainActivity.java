package com.example.camara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv1;
    static final int REQUEST_TAKE_PHOTO = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1 = findViewById(R.id.iv1);
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void tomarFoto( View V ) {
        Intent photoIntent = new Intent();
        photoIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        registerForActivityResult(,takePhoto());
        startActivityForResult(photoIntent,REQUEST_TAKE_PHOTO);
    }
    public void takePhoto(){

    }
     @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data ) {
         super.onActivityResult(requestCode, resultCode, data);
         if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
             Bundle b = data.getExtras();
             Bitmap image = (Bitmap) b.get("data");
             iv1.setImageBitmap(image);
         }
     }
}