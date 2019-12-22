package com.yadavsourabh4035.gmail.myapplication;

/* This class creates a local db named userdetails for storing the user details(id,name,email,phone) at the time of signup  */

public class UserDetailTable {
  public static final String TABLE_NAME = "userdetails";

  public static final String COLUMN_KEY = "key";

  public static final String COLUMN_EMAIL = "email";


  private String key;

  private String email;


  public static final String CREATE_TABLE =
          "CREATE TABLE " + TABLE_NAME + "("
                  + COLUMN_KEY + " TEXT PRIMARY KEY ,"

                  + COLUMN_EMAIL + " TEXT"

                  + ")";

  public UserDetailTable() {
  }

  public UserDetailTable(String key, String email) {
    this.key = key;

    this.email = email;

  }



  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public String toString() {
    return "UserDetailTable{" +
            "key=" + key +

            ", email='" + email + '\'' +

            '}';
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }
}