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
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.appbookshop.databinding.ActivityUpdateDeliveryStatusBinding;

public class UpdateDeliveryStatus extends AppCompatActivity {
        ActivityUpdateDeliveryStatusBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateDeliveryStatusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper7 dbHelper7=new DBHelper7(this);

        int id2 = getIntent().getIntExtra("id2",0);
        binding.did990.setText(String.format("%d",id2));

        RadioButton r1 = findViewById(R.id.radioButton990);
        RadioButton r2 = findViewById(R.id.radioButton2990);
        String radio;



        if(r1.isChecked()){
            radio = r1.getText().toString();
        }else{
            radio = r2.getText().toString();
        }

        binding.update990.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isupdated = dbHelper7.Updatedeliverystatus(
                        radio,
                        id2
                );
                if(isupdated){
                    Toast.makeText(UpdateDeliveryStatus.this, "Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateDeliveryStatus.this,DeliveryStatusView.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(UpdateDeliveryStatus.this, "Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Update Delivery Status  ");
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
                Intent intent = new Intent(UpdateDeliveryStatus.this,UserLoginActivity.class);
                startActivity(intent);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}