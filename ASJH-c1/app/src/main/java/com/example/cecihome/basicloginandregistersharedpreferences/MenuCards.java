package com.example.cecihome.basicloginandregistersharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MenuCards extends AppCompatActivity {

    private CardView cvCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cards);

        cvCalendar = findViewById(R.id.cvCalendar);

        cvCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCards.this,CalendarActivity.class);
                startActivity(intent);
            }
        });
    }
}
