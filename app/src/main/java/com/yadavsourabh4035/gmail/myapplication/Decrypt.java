package com.yadavsourabh4035.gmail.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Decrypt extends AppCompatActivity {
    private EditText encrypttodecrypt,encryptionkey,decryptedtext;
    private Button decrypbtn;
    private LinearLayout dtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);
        encrypttodecrypt=findViewById(R.id.encrypttodecrypt);
        encryptionkey=findViewById(R.id.encryptionkey);
        decryptedtext=findViewById(R.id.decryptedtext);
        dtext=findViewById(R.id.dtext);
        decrypbtn=findViewById(R.id.decrypbtn);
        decrypbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("utto clicked");
                String text=encrypttodecrypt.getText().toString();
                char [] charArray=text.toCharArray();
                String Key1=encryptionkey.getText().toString();
                char [] keyArray=Key1.toCharArray();
                int p;
                String output="";
                int keyint=0;
                for(char h:keyArray)
                {
                    keyint+=(int) h;
                }
                for (char c:charArray)
                {
                    int z=c;
                    p=inverse(z);














                    for (long i=0;i<keyint;i++) {

                        p = inverse(p);
                    }
                    output+=(char) p;





                }


                System.out.println(output);

                decryptedtext.setText(output);
                dtext.setVisibility(View.VISIBLE);

            }
        });
    }



    int inverse(int n)
    {
        System.out.println("I the fuctio");
        int inv = 0;


        for (; n!=0; n = (n >>1))
            inv ^= n;

        return inv;
    }
}
