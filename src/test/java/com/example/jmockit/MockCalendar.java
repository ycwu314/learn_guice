package com.example.jmockit;

import mockit.Mock;
import mockit.MockUp;
import org.joda.time.DateTime;

import java.util.Calendar;

/**
 * Created by ycwu on 2017/9/21.
 */
public class MockCalendar extends MockUp<Calendar> {

    static int year;
    static int month;
    static int day;

    public MockCalendar(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Mock
    public static Calendar getInstance() {
        return new DateTime(year, month, day, 0, 0, 0).toCalendar(null);
    }
}
