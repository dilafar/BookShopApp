package com.example.appbookshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appbookshop.databinding.ActivityUserLoginBinding;

public class UserLoginActivity extends AppCompatActivity {
        ActivityUserLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUserLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper6 dbHelper6 = new DBHelper6(this);

        binding.register12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserLoginActivity.this,UserRegisterActivity.class);
                startActivity(intent);
            }
        });

        binding.login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = binding.uLogin2.getText().toString();
                String password = binding.uPassword22.getText().toString();
                Boolean res = dbHelper6.checkuser(uname,password);
                if(res==true)
                {
                    if(uname.equals("Admin") && password.equals("admin")){
                        Toast.makeText(UserLoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UserLoginActivity.this,Dashboard1.class);
                        intent.putExtra("name",uname);
                        startActivity(intent);
                    }else{
                        Toast.makeText(UserLoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UserLoginActivity.this,Dashboard2.class);
                        intent.putExtra("name",uname);
                        startActivity(intent);
                    }

                }else{
                    Toast.makeText(UserLoginActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}