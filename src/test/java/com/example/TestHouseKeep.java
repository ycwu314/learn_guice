package com.example;

import com.example.housekeep.HouseKeep;
import com.example.housekeep.HouseKeepModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;

;

/**
 * Created by ycwu on 2017/9/20.
 */

@RunWith(JMockit.class)
public class TestHouseKeep {

    /**
     * aop
     */
    @Test
    public void testWeekend() {
        Injector injector = Guice.createInjector(new HouseKeepModule());
        HouseKeep houseKeep = injector.getInstance(HouseKeep.class);
        new MockCalendar(2017, 9, 23);
        houseKeep.doHouseKeep();
    }

    @Test(expected = IllegalStateException.class)
    public void testNotWeekend() {
        Injector injector = Guice.createInjector(new HouseKeepModule());
        HouseKeep houseKeep = injector.getInstance(HouseKeep.class);
        new MockCalendar(2017, 9, 20);
        houseKeep.doHouseKeep();
    }

    @Test
    public void testMockCalendar() {
        Calendar c1 = new DateTime(2017, 9, 20, 0, 0, 0).toCalendar(null);
        new MockCalendar(2017, 9, 20);
        Calendar c2 = Calendar.getInstance();
        Assert.assertEquals(c1.get(Calendar.YEAR), c2.get(Calendar.YEAR));
        Assert.assertEquals(c1.get(Calendar.MONTH), c2.get(Calendar.MONTH));
        Assert.assertEquals(c1.get(Calendar.DAY_OF_MONTH), c2.get(Calendar.DAY_OF_MONTH));
    }

    public static class MockCalendar extends MockUp<Calendar> {

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
}
