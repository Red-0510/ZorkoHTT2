package com.example.zorkohtt2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OtpActivity extends AppCompatActivity {

    String phoneNumber="+919999999911";
    String verificationCode;
    EditText otpInput;
    Button nxtBtn;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        otpInput = findViewById(R.id.et_otp_1);
        nxtBtn = findViewById(R.id.button);
        SendOtp(phoneNumber,false);

    }

    void SendOtp(String phoneNumber,boolean isResend){
        SetInProgress(true);
        PhoneAuthOptions.Builder builer =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // (optional) Activity for callback binding
                        // If no activity is passed, reCAPTCHA verification can not be used.
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                SignIn(phoneAuthCredential);
                                SetInProgress((false));

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(getApplicationContext(),"verification failed",Toast.LENGTH_LONG).show();
                                SetInProgress((false));

                            }

                            @Override
                            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(s, forceResendingToken);
                                verificationCode = s;
                                SetInProgress((false));
                            }
                        });       // OnVerificationStateChangedCallbacks
        PhoneAuthProvider.verifyPhoneNumber(builer.build());
    }

    private void SignIn(PhoneAuthCredential phoneAuthCredential) {

    }

    void SetInProgress(boolean inProgress){
        if(inProgress){
            nxtBtn.setVisibility(View.GONE);
        }
        else {
            nxtBtn.setVisibility(View.VISIBLE);
        }
    }
}