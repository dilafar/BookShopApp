package com.example.appbookshop;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.appbookshop.databinding.ActivityPaymentBinding;

import java.time.LocalDate;

public class PaymentActivity extends AppCompatActivity {
    ActivityPaymentBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper8 dbHelper8 = new DBHelper8(this);
        final String uname = getIntent().getStringExtra("lname");
        final String pay = getIntent().getStringExtra("pay");
        final String date = java.time.LocalDate.now().toString();

        binding.confirm202.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isinserted = dbHelper8.insertpayment(
                        binding.cardname202.getText().toString(),
                        binding.cardnumber202.getText().toString(),
                        binding.edate202.getText().toString(),
                        binding.ccv202.getText().toString(),
                        uname,
                        pay,
                        date

                );

                if(isinserted){
                            Toast.makeText(PaymentActivity.this,"Success",Toast.LENGTH_SHORT).show();
                }else{
                            Toast.makeText(PaymentActivity.this,"Error",Toast.LENGTH_SHORT).show();
                }

            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
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
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}