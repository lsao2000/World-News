package com.example.worldnews.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.worldnews.R;
import com.example.worldnews.viewModelConnector.AnimateFunctionaliy;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    private Button register;
    private TextView skip, login;
    private EditText email, username, password, password2;
    private Boolean validEmail, validUsername, validPassword, validPassword2;
    private String emailText, useranmeText, pwdText, pwdRText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        register = findViewById(R.id.signup);
        skip = findViewById(R.id.skip);
        login = findViewById(R.id.login);
        email = findViewById(R.id.Email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        password2 = findViewById(R.id.repeatPassword);
        
        skip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AnimateFunctionaliy.switchBetweenActivities(SignUp.this, MainActivity.class, false);
            }
        });
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AnimateFunctionaliy.switchBetweenActivities(SignUp.this, Login.class, false);
            }
        });
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                validEmail = AnimateFunctionaliy.checkValue(email, "email");
                Toast.makeText(SignUp.this, email.getText().toString(), Toast.LENGTH_LONG).show();
                validUsername = AnimateFunctionaliy.checkValue(username, "username");
                validPassword = AnimateFunctionaliy.checkValue(password, "password");
                validPassword2 = AnimateFunctionaliy.getValue(password2).equals(AnimateFunctionaliy.getValue(password));
                if(validPassword && validUsername && validEmail && validPassword2){
                    AnimateFunctionaliy.InsertUser(SignUp.this, MainActivity.class);
                }

            }
        });
    }
    

}
