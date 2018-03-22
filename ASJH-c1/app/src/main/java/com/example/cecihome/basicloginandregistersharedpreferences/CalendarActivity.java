package com.example.cecihome.basicloginandregistersharedpreferences;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.timessquare.CalendarPickerView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Ceci Home on 2018/3/12.
 */

public class CalendarActivity extends AppCompatActivity{

    private  static final String TAG = "Calendar";
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

//    private CalendarPickerView tsCalendar;
//    private TextView tvDate;
//    private ListView lvPackage;
//    private String date;
//    private BottomNavigationItemView bottomNavigationItemView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.travel_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.sunny_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.date_black_24dp);
    }

    private  void setupViewPager(ViewPager viewPager){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new fragment1());
        adapter.addFragment(new Tab2Fragment());
        adapter.addFragment(new Tab3Fragment());
        viewPager.setAdapter(adapter);
    }
}
