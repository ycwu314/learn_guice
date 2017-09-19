package com.example;

import com.example.billing.BillingServiceModule;
import com.example.billing.service.impl.*;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ycwu on 2017/9/19.
 */
public class TestBillingServiceModule {

    @Test
    public void test() {
        Injector injector = Guice.createInjector(new BillingServiceModule());
        RealBillingService realBillingService = injector.getInstance(RealBillingService.class);

        // module
        assertNotNull(realBillingService);
        assertTrue(realBillingService.getCreditCardProcessor() instanceof CheckoutCreditCardProcessor);
        assertTrue(realBillingService.getTransactionLog() instanceof DatabaseTransactionLog);

        // @Provides
        assertEquals("root", ((DatabaseTransactionLog) realBillingService.getTransactionLog()).getUser());

        PayPalBillingService payPalBillingService = injector.getInstance(PayPalBillingService.class);
        assertNotNull(payPalBillingService);
        assertTrue(payPalBillingService.getCreditCardProcessor() instanceof PayPalCreditCardProcessor);
    }


}
