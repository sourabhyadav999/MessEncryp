package com.yadavsourabh4035.gmail.myapplication;

public class userDetails {
    private static String key;
    private static  int count=0;

    public static String getKey() {
        return key;
    }

    public static void setKey(String key) {
        userDetails.key = key;
    }

    public static void countUpdate() {
        userDetails.count++;

    }



    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        userDetails.count = count;
    }
}
