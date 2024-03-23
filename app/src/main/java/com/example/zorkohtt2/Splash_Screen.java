package com.example.zorkohtt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();

        // Runnable to display the splash screen for 2 seconds and then navigate to the next activity
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Navigate to your main activity (replace with your actual activity class)
                Intent intent = new Intent(Splash_Screen.this, Sign_Activity.class);
                startActivity(intent);
                finish();
            }
        };

        // Post the runnable with a delay of 2 seconds
        handler.postDelayed(runnable, 2500); // 2000 milliseconds = 2 seconds
    }

}