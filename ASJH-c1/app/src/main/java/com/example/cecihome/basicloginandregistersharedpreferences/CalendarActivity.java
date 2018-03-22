package com.example.cecihome.basicloginandregistersharedpreferences;

import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
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
    private CalendarPickerView tsCalendar;
    private TextView tvDate;
    private ListView lvPackage;
    private String date;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.calendar_layout);

        tsCalendar = findViewById(R.id.tsCalendar);
        tvDate = findViewById(R.id.tvDate);
        lvPackage = findViewById(R.id.lvPackage);


        //Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        String tvToday = DateFormat.getDateInstance(DateFormat.FULL).format(today);
        tvDate.setText(tvToday);




        //set start date of the calendar to be 1 month before today, end date 1 year after today;
        Date startDate = addDays(today,-30);
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        tsCalendar.init(startDate,nextYear.getTime()).withSelectedDate(today);


        CalendarEmptyDecorator tscd = new CalendarEmptyDecorator(CalendarActivity.this,startDate,today);
        tscd.decorate(tsCalendar,addDays(today,-1));

        //set calendar highlighted dates
        String start = "15/03/2018";
        DateFormat dfs = new SimpleDateFormat("dd/MM/yyyy");
        Date startD = new Date();
        try {
            startD =  dfs.parse(start);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String end = "25/03/2018";
        DateFormat dfe = new SimpleDateFormat("dd/MM/yyyy");
        Date endD = new Date();
        try {
            endD =  dfe.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //return a list of dates between today and endDate
        ArrayList<Date> dates = getDaysBetweenDates(startD,endD);
        tsCalendar.highlightDates(dates);

        tsCalendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);

                Calendar calSelected = Calendar.getInstance();
                calSelected.setTime(date);

//                String selectedDate = " " + calSelected.get(Calendar.DAY_OF_MONTH)
//                        + "-" + (calSelected.get(Calendar.MONTH)+1)
//                        + "-" + calSelected.get(Calendar.YEAR);
                tvDate.setText(selectedDate);
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });


        ArrayList<Package> packages =  new ArrayList<>();
        packages.add(new Package(1,"Caribbean New Year","Cruise the Caribbean & Celebrate the New Year."));
        packages.add(new Package(2,"Polynesian Paradise","8 Day All Inclusive Hawaiian Vacation."));
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,packages);
        lvPackage.setAdapter(adapter);

    }

    public static ArrayList<Date> getDaysBetweenDates(Date startDate, Date endDate)
    {
        ArrayList<Date> dates = new ArrayList<Date>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);

        while (calendar.getTime().before(addDays(endDate,1)))
        {
            Date result = calendar.getTime();
            dates.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        return dates;
    }

    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
}
