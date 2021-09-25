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

import com.example.appbookshop.databinding.ActivityUpdateCategoryCategory2Binding;

public class UpdateCategoryCategory2 extends AppCompatActivity {
        ActivityUpdateCategoryCategory2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateCategoryCategory2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final  DBHelper4 dbHelper4=new DBHelper4(this);
        int id=getIntent().getIntExtra("id",0);
        Cursor cursor=dbHelper4.getCategoryById(id);

        binding.updateCategory2.setText(cursor.getString(1));

        binding.submitcategory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isupdated = dbHelper4.updateCategory(
                        id,
                        binding.updateCategory2.getText().toString()
                );
                if(isupdated){
                    Toast.makeText(UpdateCategoryCategory2.this,"Updated",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateCategoryCategory2.this,CategoryActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(UpdateCategoryCategory2.this,"Error",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Update Category  ");
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
                Intent intent = new Intent(UpdateCategoryCategory2.this,UserLoginActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}