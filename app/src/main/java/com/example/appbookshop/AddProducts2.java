package com.example.appbookshop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appbookshop.databinding.ActivityAddProducts2Binding;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddProducts2 extends AppCompatActivity {
    ActivityAddProducts2Binding binding;

     Uri mImageUri;
     ImageView mImageView;
     static final int PICK_IMAGE_REQUEST = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityAddProducts2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper3 dbHelper3 = new DBHelper3(this);

        String cname2=getIntent().getStringExtra("cname2");
        binding.productname40.setText(cname2);

        binding.addbutton40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isinserted = dbHelper3.insertitem(
                        R.drawable.new3,
                        binding.category40.getText().toString(),
                        binding.productname40.getText().toString(),
                        binding.discription40.getText().toString(),
                        Integer.parseInt(binding.avqty40.getText().toString()),
                        Integer.parseInt(binding.price40.getText().toString()),
                        Integer.parseInt(binding.offer40.getText().toString())
                );
                if(isinserted){
                    Toast.makeText(AddProducts2.this,"Success",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AddProducts2.this,"Error",Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.view40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddProducts2.this, AdminProductView.class);


                startActivity(intent);
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);



        Button btn = findViewById(R.id.button40);




        btn.setOnClickListener(new View.OnClickListener(){
                                                  public void onClick(View v){
                                                      openFileChooser();
                                                  }
                                              }

        );



    }
    private  byte[] imageviewtoByte(ImageView imageView){
        Bitmap bitmap=((BitmapDrawable)imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Logout:
                Toast.makeText(this,"Logout",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            mImageView.setImageBitmap(bitmap);
        }
    }
}