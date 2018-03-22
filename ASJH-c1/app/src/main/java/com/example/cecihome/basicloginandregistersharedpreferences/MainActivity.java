package com.example.cecihome.basicloginandregistersharedpreferences;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class MainActivity extends AppCompatActivity{

    EditText etName;
    EditText etPassword;
    TextView tvLogin;
    CardView cvLogin;
    TextView tvRegister;
    TextView tvError;
    String error;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        tvLogin = findViewById(R.id.tvLogin);
        cvLogin = findViewById(R.id.cvRegister);
        tvRegister = findViewById(R.id.tvRegister);
        tvError = findViewById(R.id.tvError);

        cvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etName.getText().toString();
                String password = etPassword.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String userDetails = preferences.getString(user + password + "data", "Username or Password is Incorrect.");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display", userDetails);
                //editor.putString("Test", "this is a test for preferences");
                editor.commit();

                if(!inputValidator(userDetails))
                {
                    tvError.setText(error);
                }
                else {
                    Intent displayScreen = new Intent(MainActivity.this, MenuCards.class);
                    startActivity(displayScreen);

                    etName.setText("");
                    etPassword.setText("");
                    tvError.setText("");
                }
            }
        });


        cvLogin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE)
                {
                    cvLogin.setCardBackgroundColor(Color.parseColor("#ffffff"));
                    //cvLogin.setRadius(25);
                    //cvLogin.setElevation(10);
                    tvLogin.setTextColor(Color.parseColor("#000000"));
                }

                if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL)
                {
                    cvLogin.setCardBackgroundColor(Color.parseColor("#ffc107"));
                    //cvLogin.setRadius(25);
                    //cvLogin.setElevation(10);
                    tvLogin.setTextColor(Color.parseColor("#ffffff"));
                }


                return false;
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerScreen = new Intent(MainActivity.this, Register.class);
                startActivity(registerScreen);
                etName.setText("");
                etPassword.setText("");
            }
        });

        tvRegister.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE)
                {
                    tvRegister.setTextColor(Color.parseColor("#ffc107"));
                }

                if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL)
                {
                    tvRegister.setTextColor(Color.parseColor("#ffffff"));
                }


                return false;
            }
        });

    }


    private boolean inputValidator(String userDetails){
        boolean result = true;

        if(etName.getText().toString().trim().length() == 0) {
            result = false;
            error = "Name is required.";
        }
        else if(etPassword.getText().toString().trim().length() == 0) {
            result = false;
            error = "Password is required.";
        }
        else if(userDetails == "Username or Password is Incorrect." )
        {
            result = false;
            error = userDetails;
        }

        return result;
    }

}
