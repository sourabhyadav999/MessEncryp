package com.yadavsourabh4035.gmail.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Encrypt extends AppCompatActivity {
    private EditText encrypttext;
    private EditText encryptedtext;
    private Button encryptbtn;
    private UserDetailDatabaseHelper userDetailDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);
        userDetailDatabaseHelper=new UserDetailDatabaseHelper(getApplicationContext());
        encrypttext=findViewById(R.id.encrypttext);
        encryptedtext=findViewById(R.id.encryptedtext);
        encryptbtn=findViewById(R.id.encryptbtn);
        encryptbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDetails.countUpdate();
                String key= "";
                String read = encrypttext.getText().toString();
                String output="Encrypted Message:--";
                char [] charArray=read.toCharArray();
                int p;
                System.out.println(userDetailDatabaseHelper.getUserDetails().size());


                System.out.println( userDetailDatabaseHelper.getUserDetails().get(0).getKey());
                if (userDetailDatabaseHelper.getUserDetails().size() != 0) {


                    key += userDetailDatabaseHelper.getUserDetails().get(0).getKey();

                }
                char [] keyArray=key.toCharArray();
                int keyint=0;
                for(char h:keyArray)
                {
                    keyint+=(int) h;
                }
                keyint+=userDetails.getCount();
                key+=String.valueOf(userDetails.getCount());

                System.out.println( keyint);


                for (char c:charArray)
                {
                    int z=c;
                     p=bintogray(z);














                    for (long i=0;i<keyint;i++) {

                        p = bintogray(p);
                    }
                    output+=(char) p;





                }

                output+="\n Encryption key :-"+key+"\nWarning!!!!---- Please Share this key only with the person you intend to send this message. ";

                encryptedtext.setText(output);
                encryptedtext.setVisibility(View.VISIBLE);

            }


        });
    }
    private  int bintogray( int n)
    {

        return (n ^(n >> 1)) ;
    }



}
