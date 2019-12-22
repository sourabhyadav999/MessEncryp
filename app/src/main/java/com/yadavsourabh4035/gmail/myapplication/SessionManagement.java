package com.yadavsourabh4035.gmail.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class SessionManagement {
  private Context context;
  private SharedPreferences sharedPreferences;
  private SharedPreferences.Editor editor;

  public SessionManagement(Context context){
    this.context = context;
  }

  public boolean isUserExists(){
    sharedPreferences = context.getSharedPreferences("LoginCredentials",Context.MODE_PRIVATE);
    return sharedPreferences.getBoolean("isLoggedIn", false);
  }

  public Map<String, String> getLoggedInUserDetails(){
    sharedPreferences = context.getSharedPreferences("LoginCredentials",Context.MODE_PRIVATE);

    String email = sharedPreferences.getString("email", "");
    String key = sharedPreferences.getString("key", "");

    Map<String, String> userDetails = new HashMap<>();

    assert email != null;
    userDetails.put("email", email);
    userDetails.put("key", key);

    return userDetails;
  }

  public boolean addUser( String email,  boolean isLoggedIn,String key){
    sharedPreferences = context.getSharedPreferences("LoginCredentials",Context.MODE_PRIVATE);
    editor = sharedPreferences.edit();

    editor.putString("email", email);
    editor.putString("key", key);


    editor.putBoolean("isLoggedIn", isLoggedIn);
    return editor.commit();
  }

}