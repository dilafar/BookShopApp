package com.example.appbookshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.appbookshop.databinding.ActivityViewuserAccountBinding;

public class ViewuserAccountActivity extends AppCompatActivity {
    ActivityViewuserAccountBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityViewuserAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper6 dbHelper6=new DBHelper6(this);



        String uname=getIntent().getStringExtra("uname");


        Cursor cursor = dbHelper6.getData(uname);
        int id=cursor.getInt(0);
        String password = cursor.getString(4);

        binding.id60.setText(String.format("%d",cursor.getInt(0)));
        binding.name60.setText(cursor.getString(1));
        binding.email60.setText(cursor.getString(2));
        binding.phone60.setText(cursor.getString(3));

        binding.edit60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewuserAccountActivity.this,UpdateAccountActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("name",cursor.getString(1));
                intent.putExtra("email",cursor.getString(2));
                intent.putExtra("phone",cursor.getString(3));
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });

        binding.delete60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(ViewuserAccountActivity.this)
                        .setTitle("Delete")
                        .setIcon(R.drawable.ic_warning_24)
                        .setMessage("Are you sure you want to delete ? ")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(dbHelper6.deleteuser(String.format("%d",id))>0){
                                    Toast.makeText(ViewuserAccountActivity.this, "deleted", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(ViewuserAccountActivity.this,UserLoginActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(ViewuserAccountActivity.this,"Error",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();

            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("User Account  ");
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
                Intent intent = new Intent(ViewuserAccountActivity.this,UserLoginActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}