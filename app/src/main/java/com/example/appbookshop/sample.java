package com.example.appbookshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class sample extends AppCompatActivity {
        ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        imageView=(ImageView)findViewById(R.id.imageView990);
        byte[] image ;
        image=getIntent().getByteArrayExtra("image");
        Bitmap bitmap= BitmapFactory.decodeByteArray(image,0,image.length);
        imageView.setImageBitmap(bitmap);



    }
}