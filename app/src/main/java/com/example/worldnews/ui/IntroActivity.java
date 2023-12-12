package com.example.worldnews.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.worldnews.R;
import com.example.worldnews.viewModelConnector.AnimateFunctionaliy;

import android.widget.TextView;


public class IntroActivity extends AppCompatActivity {
    private TextView fbrand, sbrand, developer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        fbrand = findViewById(R.id.fbrand);
        sbrand = findViewById(R.id.sbrand);
        AnimateFunctionaliy.IntroAnimation(IntroActivity.this, fbrand, sbrand, SignUp.class);
    }
}
