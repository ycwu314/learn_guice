package com.example.jmockit;

import mockit.integration.junit4.JMockit;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;

/**
 * Created by ycwu on 2017/9/21.
 */
@RunWith(JMockit.class)
public class TestStaticMethod {

    @Test
    public void testMockCalendar() {
        Calendar c1 = new DateTime(2017, 9, 20, 0, 0, 0).toCalendar(null);
        new MockCalendar(2017, 9, 20);
        Calendar c2 = Calendar.getInstance();
        Assert.assertEquals(c1.get(Calendar.YEAR), c2.get(Calendar.YEAR));
        Assert.assertEquals(c1.get(Calendar.MONTH), c2.get(Calendar.MONTH));
        Assert.assertEquals(c1.get(Calendar.DAY_OF_MONTH), c2.get(Calendar.DAY_OF_MONTH));
    }
}
