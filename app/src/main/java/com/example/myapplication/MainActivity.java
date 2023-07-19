package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText un = (EditText) findViewById(R.id.seuser);
        EditText pswd = (EditText) findViewById(R.id.sepass);
        Button signup = (Button) findViewById(R.id.sbt);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = un.getText().toString();
                String password = pswd.getText().toString();
                if (user.length() == 0) {
                    un.setError("Username is empty");
                    un.requestFocus();
                } else if (password.length() == 0) {
                    pswd.setError("password is empty");
                    pswd.requestFocus();
                } else {
                    if (!isValidpassword(password)) {
                        Toast.makeText(MainActivity.this, "Password doesnot match with pattern", Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        intent.putExtra("username",user);
                        intent.putExtra("password",password);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    Pattern lowercase=Pattern.compile("^.*[a-z].*$");
    Pattern uppercase=Pattern.compile("^.*[A-Z].*$");
    Pattern number=Pattern.compile("^.*[0-9].*$");
    Pattern specialc=Pattern.compile("^.*[^a-zA-Z0-9].*$");
    public Boolean isValidpassword(String password)
    {
        if(password.length()<8)
        {
            return false;
        }
        if(!lowercase.matcher(password).matches())
        {
            return false;
        }
        if(!uppercase.matcher(password).matches())
        {
            return false;
        }
        if(!number.matcher(password).matches())
        {
            return false;
        }
        if(!specialc.matcher(password).matches())
        {
            return false;
        }
        return true;
    }
}