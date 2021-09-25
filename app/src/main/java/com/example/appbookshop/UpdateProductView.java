package com.example.appbookshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.appbookshop.databinding.ActivityUpdateProductViewBinding;

public class UpdateProductView extends AppCompatActivity {
        ActivityUpdateProductViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateProductViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DBHelper3 dbHelper3 = new DBHelper3(this);
        int id= getIntent().getIntExtra("id",0);
        Cursor cursor=dbHelper3.getitemyById(id);
        int image =cursor.getInt(1);

        binding.category50.setText(cursor.getString(2));
        binding.productname50.setText(cursor.getString(3));
        binding.discription50.setText(cursor.getString(4));
        binding.avqty50.setText(String.format("%d",cursor.getInt(5)));
        binding.price50.setText(String.format("%d",cursor.getInt(6)));
        binding.offer50.setText(String.format("%d",cursor.getInt(7)));

        binding.updateitem50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean isupdated = dbHelper3.updateitem(
                        image,
                        binding.category50.getText().toString(),
                        binding.productname50.getText().toString(),
                        binding.discription50.getText().toString(),
                        Integer.parseInt(binding.avqty50.getText().toString()),
                        Integer.parseInt(binding.price50.getText().toString()),
                        Integer.parseInt(binding.offer50.getText().toString()),
                        id
                );
                if(isupdated){
                    Toast.makeText(UpdateProductView.this,"Updated",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateProductView.this,AdminProductView.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(UpdateProductView.this,"Error",Toast.LENGTH_SHORT).show();

                }
            }
        });

        binding.view50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateProductView.this, AdminProductView.class);


                startActivity(intent);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Update Product  ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Logout:
                Toast.makeText(this,"Logout",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateProductView.this,UserLoginActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}