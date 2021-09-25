package com.example.appbookshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.appbookshop.databinding.ActivityUpdateAccountBinding;

public class UpdateAccountActivity extends AppCompatActivity {
        ActivityUpdateAccountBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper6 dbHelper6=new DBHelper6(this);

        int id = getIntent().getIntExtra("id",0);
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");
        String password = getIntent().getStringExtra("password");

        binding.updatefullName.setText(name);
        binding.updateEmail.setText(email);
        binding.updatecnumber.setText(phone);
        binding.updatePassword2.setText(password);

        binding.update60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               boolean isupdated = dbHelper6.Updateuser(
                        binding.updatefullName.getText().toString(),
                        binding.updateEmail.getText().toString(),
                        binding.updatecnumber.getText().toString(),
                        binding.updatePassword2.getText().toString(),
                        id
                );
               if(isupdated){
                   Toast.makeText(UpdateAccountActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(UpdateAccountActivity.this,UserLoginActivity.class);
                   startActivity(intent);
               }else{
                   Toast.makeText(UpdateAccountActivity.this, "Fail", Toast.LENGTH_SHORT).show();
               }

            }
        });

        binding.cancel60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateAccountActivity.this,Dashboard2.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Update Account  ");
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
                Intent intent = new Intent(UpdateAccountActivity.this,UserLoginActivity.class);
                startActivity(intent);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}