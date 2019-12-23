package com.yadavsourabh4035.gmail.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class SplashScreen extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private ProgressDialog progressDialog;
    private Context context;
    private int userid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        sharedPreferences = getSharedPreferences("BasicAppDetails", MODE_PRIVATE);
        SessionManagement sessionManagement = new SessionManagement(this);
        Map<String, String> userDetails = sessionManagement.getLoggedInUserDetails();

        /*
        Checks for saved details.
        If
            User is already registered then he is sent directly to main activity.
        Else
            He directed to the sign up screen for account creation.
         */

        if(sessionManagement.isUserExists()){

            String email = userDetails.get("email");

            if(isNetworkAvailable()) {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
            else
            {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        }

        else{
            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreen.this, LoginScreen.class);
                    startActivity(intent);
                    finish();
                }
            },3000);
        }
    }

    private String getDate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);



        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //System.out.println("Today's Date => " + df);
        String s = df.format(c);
        System.out.println("Today's Date => " + s);


        return df.format(c);
    }




    private boolean isNetworkAvailable() {
        boolean connected;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;
        return  connected;
    }
}