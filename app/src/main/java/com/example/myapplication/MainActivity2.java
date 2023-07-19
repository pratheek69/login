package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

    public class MainActivity2 extends AppCompatActivity {

        EditText usr,pswd1;
        Button login;
        TextView txt;
        int counter =3;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            usr = (EditText) findViewById(R.id.leuser);
            pswd1 = (EditText) findViewById(R.id.lepass);
            login = (Button) findViewById(R.id.lbt);
            txt = (TextView) findViewById(R.id.textView4);
            String reusername = getIntent().getStringExtra("username");
            String repassword = getIntent().getStringExtra("password");
            login.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view){
                    String username1 =usr.getText().toString();
                    String password1 = pswd1.getText().toString();
                    if(reusername.equals(username1) && repassword.equals(password1))
                    {
                        Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                        startActivity(intent);
                        txt.setVisibility(View.VISIBLE);
                        txt.setBackgroundColor(Color.RED);
                        counter--;
                        txt.setText(Integer.toString(counter));
                    }
                    else
                    {
                        Toast.makeText(MainActivity2.this,"invalid credentials",
                                Toast.LENGTH_LONG).show();
                        txt.setVisibility(View.VISIBLE);
                        txt.setBackgroundColor(Color.RED);
                        counter--;
                        txt.setText(Integer.toString(counter));}
                    if(counter==0)
                    {
                        Toast.makeText(MainActivity2.this,"Failed login attempts",
                                Toast.LENGTH_LONG).show();
                        login.setEnabled(false);
                    }
                }
            });
        }
    }
