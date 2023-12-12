package com.example.worldnews.viewModelConnector;

import android.os.Handler;
import android.util.Patterns;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.example.worldnews.R;
import android.content.Context;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import java.util.regex.Pattern;
import android.graphics.Color;


public class AnimateFunctionaliy {
    
    public static void IntroAnimation(Context context, View v1, View v2, Class<?> any) {
        Animation zoomout = AnimationUtils.loadAnimation(context.getApplicationContext(), R.anim.brand_animation);
        v1.setAnimation(zoomout);
        v2.setAnimation(zoomout);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AnimateFunctionaliy.switchBetweenActivities(context, any,false);
            }
        }, 3000);
    }
    public static void switchBetweenActivities(Context context, Class<?> any, boolean backButton){
        Intent inte = new Intent(context.getApplicationContext(),  any);
        if(!backButton){
            inte.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            inte.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        context.startActivity(inte);
    }
    public static String getValue(EditText view){
        return view.getText().toString();
    }
    public static Boolean checkValue(EditText field, String type) {
        String value = getValue(field);
        if (value.isEmpty()) {
            field.setError("please file out this box");
            return false;
        } else {
            if (type.equalsIgnoreCase("email")) {
                if(!Patterns.EMAIL_ADDRESS.matcher(value).matches()){
                    field.setError("this must be "+ type +" type");
                    return false;
                } else {
                    if (checkDatabase(value)) {
                        field.setError("this Email is Already Exist");
                        return false;
                    }
                }
            }else if(type.equalsIgnoreCase("username")){
                Pattern pattern = Pattern.compile("^[A-Za-z]\\w{5,29}$");
                if(!pattern.matcher(value).matches()){
                    field.setError("This must be at least 6 letter\nfirst caracter must be lowercase\nfist lette must be character not number");
                    return false;
                }
                return true;

            }else if(type.equalsIgnoreCase("password")){
                Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{7,20}$");
                if(!pattern.matcher(value).matches()){
                    field.setError("This must be at least 7 letter\nThis must contain at least 1 lowercase character\nmust be contain at least 1 number\nmust contain at least on upercase character");
                    return false;
                }
            }
            return true;
        }
    }
    public static void InsertUser(Context context, Class<?> any){
        AnimateFunctionaliy.switchBetweenActivities(context, any, false);
    }
    // this function to check if the email is already in the database.
    // will add this features in the future.
    public static Boolean checkDatabase(String email){
        return false;
    }
    // this function for animate the navigation buttons and text.
    public static void animateButton(View view, TextView text, int background, String color){
        view.setBackgroundResource(background);
        text.setTextColor(Color.parseColor(color));
    }
}
