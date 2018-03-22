package com.example.cecihome.basicloginandregistersharedpreferences;

import android.content.Context;

import com.squareup.timessquare.CalendarCellDecorator;
import com.squareup.timessquare.CalendarCellView;
import com.squareup.timessquare.CalendarPickerView;

import java.util.Date;

/**
 * Created by 689438 on 2018-03-20.
 */

public class CalendarEmptyDecorator implements CalendarCellDecorator {

    private Context context;
    private Date min;
    private Date max;
    public CalendarEmptyDecorator(Context context, Date min, Date max) {
        this.context = context;
        this.min = min;
        this.max = max;
    }

    //@Override
    public void decorate(CalendarPickerView calendarView, Date date) {
        if(date.compareTo(min) != -1 && date.compareTo(max) != 1) {
            calendarView.setBackgroundColor(this.context.getResources()
                    .getColor(R.color.calendar_default_enabled_bakcground));

            //calendarView.getDayOfMonthTextView().setTextColor(this.context.getResources()
            //        .getColor(R.color.calendar_default_enabled_text));
        }
        else {
            calendarView.setBackgroundColor(this.context.getResources()
                    .getColor(R.color.calendar_default_disabled_background));

//            calendarView.getDayOfMonthTextView().setTextColor(this.context.getResources()
//                    .getColor(R.color.calendar_default_disabled_text));
        }
    }

    @Override
    public void decorate(CalendarCellView cellView, Date date) {

    }
}