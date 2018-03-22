package com.example.cecihome.basicloginandregistersharedpreferences;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MenuCards extends AppCompatActivity {

    private CardView cvCalendar;
    private BottomNavigationView bottomNavigationView;

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

        bottomNavigationView = findViewById(R.id.bottomNavView_bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        break;
                    case R.id.ic_money:
                        break;
                    case R.id.ic_date:
                        Intent intent = new Intent(MenuCards.this,CalendarActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.ic_sun:
                        break;
                    case R.id.ic_travel:
                        break;
                }
                return false;
            }
        });

        BottomNavigationMenuView menuView = (BottomNavigationMenuView)
                bottomNavigationView.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView =
                    menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams =
                    iconView.getLayoutParams();
            final DisplayMetrics displayMetrics =
                    getResources().getDisplayMetrics();
            layoutParams.height = (int)
                    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60,
                            displayMetrics);
            layoutParams.width = (int)
                    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 120,
                            displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }
    }
}
