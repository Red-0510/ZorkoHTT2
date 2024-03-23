package com.example.zorkohtt2;

import static android.content.ContentValues.TAG;

import static com.google.firebase.FirebaseApp.initializeApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zorkohtt2.api.RetrofitClient;
import com.example.zorkohtt2.models.LoginResponse;
import com.example.zorkohtt2.models.Mob;
import com.example.zorkohtt2.models.MobOtp;
import com.example.zorkohtt2.models.Otpverify;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONStringer;

import java.util.concurrent.TimeUnit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button button ;
    String verificationId;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
        setContentView(R.layout.activity_otp);
        e1=findViewById(R.id.et_otp_1);
//
        String otpCode = e1.getText().toString();
        Intent intent = getIntent();
        String phoneNum = intent.getStringExtra("phonenumber");
        Toast.makeText(this, phoneNum, Toast.LENGTH_SHORT).show();


        Mob mobile = new Mob();
        mobile.setMoblieNumber(phoneNum);
        Call<LoginResponse> call =  RetrofitClient.getInstance().getAPI()
                .userOtp(mobile);

        String sendPhone= phoneNum;
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable throwable) {
                Toast.makeText(OtpActivity.this, throwable.toString(), Toast.LENGTH_SHORT).show();
            }
        });


//
        button = findViewById(R.id.button);  // from xml



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MobOtp mobile = new MobOtp();
                mobile.setMobileNum(phoneNum);
                mobile.setOtp(otpCode);
                Call<Otpverify> call =  RetrofitClient.getInstance().getAPI()
                        .otpVerify(mobile);


                call.enqueue(new Callback<Otpverify>() {
                    @Override
                    public void onResponse(Call<Otpverify> call, Response<Otpverify> response) {
                        if (response.body() != null) {
                            String jsonString = new Gson().toJson(response.body());

                            // Parse JSON string to JsonObject
//                            try{
                            JsonObject jsonObject = new Gson().fromJson(jsonString, JsonObject.class);
//
                            JsonObject jd = jsonObject.getAsJsonObject("data");
                            String token = String.valueOf(jd.get("token"));
//
                            Toast.makeText(OtpActivity.this, token, Toast.LENGTH_LONG).show();


                            //stProceed with parsing
//                            JsonObject post = new JsonObject().get(response.body().toString()).getAsJsonObject();
                            if (token != null) {
                                SharedPreferences sharedPreferences = getSharedPreferences("authToken", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("authToken", token);
                                startActivity(new Intent(OtpActivity.this, MainActivity.class));
//                            } else {
//                                Toast.makeText(OtpActivity.this, "Wrong Otp", Toast.LENGTH_SHORT).show();
//                            }
                            }
                        }
                            else {
                            // Handle empty response case

                        }
//

                    }

                    @Override
                    public void onFailure(Call<Otpverify> call, Throwable throwable) {
                        Toast.makeText(OtpActivity.this, throwable.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//
////        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
////        if(currentUser!=null){
//            startActivity(new Intent(OtpActivity.this, MainActivity.class));
//        }
//    }
}