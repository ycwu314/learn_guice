package com.example.housekeep;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * Created by ycwu on 2017/9/20.
 */
public class HouseKeepModule extends AbstractModule {
    @Override
    protected void configure() {
        // bindInterceptor(clazz matcher, method matcher, interceptor)
        // if the interceptor need injection, use requestInjection(interceptor);
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Weekend.class), new WeekendInterceptor());
    }
}
