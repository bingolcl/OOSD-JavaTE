package com.example.cecihome.basicloginandregistersharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Ceci Home on 2018/3/12.
 */

public class CalendarActivity extends AppCompatActivity{

    private  static final String TAG = "Calendar";
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private BottomNavigationView bottomNavigationView;

//    private CalendarPickerView tsCalendar;
//    private TextView tvDate;
//    private ListView lvPackage;
//    private String date;
//    private BottomNavigationItemView bottomNavigationItemView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        int tabs[] = {R.drawable.ic_tab1, R.drawable.ic_tab2, R.drawable.ic_tab3};
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(tabs[i]);
            tabLayout.getTabAt(i).setCustomView(imageView);
            imageView.getLayoutParams().width = 200;
        }

        bottomNavigationView = findViewById(R.id.bottomNavView_bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        Intent intent = new Intent(CalendarActivity.this, MenuCards.class);
                        startActivity(intent);
                        break;
                    case R.id.ic_money:
                        break;
                    case R.id.ic_date:
                        break;
                    case R.id.ic_sun:
                        break;
                    case R.id.ic_travel:
                        break;
                }
                return false;
            }
        });

        //BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavView_bar);
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

    private  void setupViewPager(ViewPager viewPager){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new calendar_frag());
        adapter.addFragment(new Tab2Fragment());
        adapter.addFragment(new Tab3Fragment());
        viewPager.setAdapter(adapter);
    }
}
