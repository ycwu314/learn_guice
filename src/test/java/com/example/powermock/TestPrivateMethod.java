package com.example.powermock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by ycwu on 2017/9/21.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(SomeClazzThatHasAPrivateMethod.class)
public class TestPrivateMethod {

    @Test
    public void testPrivateMethod() throws Exception {
        // spy only mock specific method
        SomeClazzThatHasAPrivateMethod obj = PowerMockito.spy(new SomeClazzThatHasAPrivateMethod());
        PowerMockito.when(obj, "me").thenReturn("you");
        Assert.assertEquals("you", obj.info());
    }

}

class SomeClazzThatHasAPrivateMethod {
    private String me() {
        return "me";
    }

    public String info() {
        return me();
    }
}


