package com.example.cecihome.basicloginandregistersharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ceci Home on 2018/3/11.
 */

public class DisplayScreen extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info);

        SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        String display = preferences.getString("display","");

        TextView displayInfo = findViewById(R.id.tvName);
        displayInfo.setText(display);
        //Toast.makeText(this, "Test", Toast.LENGTH_LONG).show();
    }
}
