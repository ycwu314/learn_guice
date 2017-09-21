package com.example;

import com.example.housekeep.HouseKeep;
import com.example.housekeep.HouseKeepModule;
import com.example.housekeep.WeekendInterceptor;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;

/**
 * Created by ycwu on 2017/9/20.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({Calendar.class, WeekendInterceptor.class})
public class TestHouseKeep {

    /**
     * aop
     */
    @Test
    public void testWeekend() {
        Injector injector = Guice.createInjector(new HouseKeepModule());
        HouseKeep houseKeep = injector.getInstance(HouseKeep.class);
        Calendar weekend = new DateTime(2017, 9, 23, 0,
                0, 0).toCalendar(null);
        PowerMockito.mockStatic(Calendar.class);
        PowerMockito.when(Calendar.getInstance()).thenReturn(weekend);
        houseKeep.doHouseKeep();
    }

    @Test(expected = IllegalStateException.class)
    public void testNotWeekend() {
        Injector injector = Guice.createInjector(new HouseKeepModule());
        HouseKeep houseKeep = injector.getInstance(HouseKeep.class);
        Calendar notWeekend = new DateTime(2017, 9, 21, 0,
                0, 0).toCalendar(null);
        PowerMockito.mockStatic(Calendar.class);
        PowerMockito.when(Calendar.getInstance()).thenReturn(notWeekend);
        houseKeep.doHouseKeep();
    }

}
