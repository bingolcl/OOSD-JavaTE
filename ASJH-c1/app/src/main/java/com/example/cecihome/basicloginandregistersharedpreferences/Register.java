package com.example.cecihome.basicloginandregistersharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Ceci Home on 2018/3/11.
 */

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        final EditText userName = findViewById(R.id.etNewName);
        final EditText password = findViewById(R.id.etNewPassword);
        final EditText email = findViewById(R.id.etNewEmail);
        final CardView cvRegister = findViewById(R.id.cvRegister);
        final TextView tvBack = findViewById(R.id.tvBack);
        final TextView tvRegister = findViewById(R.id.tvRegister);

        cvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String newUser = userName.getText().toString();
                String newPassword = password.getText().toString();
                String newEmail = email.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail);
                editor.commit();

                Intent loginScreen = new Intent(Register.this, MainActivity.class);
                startActivity(loginScreen);
            }
        });

        cvRegister.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE)
                {
                    cvRegister.setCardBackgroundColor(Color.parseColor("#ffffff"));
                    tvRegister.setTextColor(Color.parseColor("#000000"));
                }

                if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL)
                {
                    cvRegister.setCardBackgroundColor(Color.parseColor("#ffc107"));
                    tvRegister.setTextColor(Color.parseColor("#ffffff"));
                }


                return false;
            }
        });
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginScreen = new Intent(Register.this, MainActivity.class);
                startActivity(loginScreen);
            }
        });

        tvBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE)
                {
                    tvBack.setTextColor(Color.parseColor("#ffc107"));
                }

                if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL)
                {
                    tvBack.setTextColor(Color.parseColor("#ffffff"));
                }


                return false;
            }
        });
    }
}
