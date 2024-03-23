package com.example.zorkohtt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zorkohtt2.api.RetrofitClient;
import com.example.zorkohtt2.models.LoginResponse;
import com.example.zorkohtt2.models.Mob;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sign_Activity extends AppCompatActivity {
    EditText name;
    EditText phone;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        setContentView(R.layout.activity_sign);
        phone = findViewById(R.id.editTextphone);
//        name = findViewById(R.id.editTextPersonName);
        button = findViewById(R.id.createaccbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNum = phone.getText().toString();
                phoneNum = phoneNum.trim();
                if(phoneNum.length()<10){
                    Toast.makeText(Sign_Activity.this, "Please Enter a valid Phone number", Toast.LENGTH_SHORT).show();
                }
                else {

                   Intent intent = new Intent(Sign_Activity.this,OtpActivity.class);
                   intent.putExtra("phonenumber",phoneNum);
                   startActivity(intent);
                }
            }
        });
    }
}