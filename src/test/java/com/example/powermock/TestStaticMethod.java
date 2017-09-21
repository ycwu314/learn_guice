package com.example.powermock;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;

/**
 * Created by ycwu on 2017/9/21.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Calendar.class)
public class TestStaticMethod {

    @Test
    public void testStaticMethod() {
        Calendar c = new DateTime(2000, 1, 1, 0, 0, 0).toCalendar(null);
        PowerMockito.mockStatic(Calendar.class);
        PowerMockito.when(Calendar.getInstance()).thenReturn(c);
        Assert.assertEquals(2000, Calendar.getInstance().get(Calendar.YEAR));
    }

    @Test
    public void testPrivateMethod() throws Exception {
        SomeClazzHasAPrivateMethod obj = PowerMockito.spy(new SomeClazzHasAPrivateMethod());
        PowerMockito.when(obj, "me").thenReturn("you");
        Assert.assertEquals("you", obj.info());
    }

    class SomeClazzHasAPrivateMethod {
        private String me() {
            return "me";
        }

        public String info() {
            return me();
        }
    }
}


