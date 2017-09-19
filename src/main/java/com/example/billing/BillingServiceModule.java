package com.example.billing;

import com.example.billing.service.BillingService;
import com.example.billing.service.CreditCardProcessor;
import com.example.billing.service.TransactionLog;
import com.example.billing.service.impl.*;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

/**
 * Created by ycwu on 2017/9/19.
 */
public class BillingServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(BillingService.class).annotatedWith(Names.named("billing")).to(RealBillingService.class).in(Singleton.class);
        bind(BillingService.class).annotatedWith(Names.named("paypalBilling")).to(PayPalBillingService.class).in(Singleton.class);
        bind(TransactionLog.class).to(DatabaseTransactionLog.class).in(Singleton.class);
        bind(CreditCardProcessor.class).annotatedWith(Names.named("paypal")).to(PayPalCreditCardProcessor.class).in(Singleton.class);
        bind(CreditCardProcessor.class).annotatedWith(Names.named("checkout")).to(CheckoutCreditCardProcessor.class).in(Singleton.class);
    }

    @Provides
    DatabaseTransactionLog databaseTransactionLog() {
        DatabaseTransactionLog databaseTransactionLog = new DatabaseTransactionLog();
        databaseTransactionLog.setPassword("123456");
        databaseTransactionLog.setUser("root");
        databaseTransactionLog.setUrl("mysql://localhost:3306/mydb");
        return databaseTransactionLog;
    }

    @Provides
    PayPalCreditCardProcessor payPalCreditCardProcessor() {
        PayPalCreditCardProcessor payPalCreditCardProcessor = new PayPalCreditCardProcessor();
        payPalCreditCardProcessor.setApiKey("aaazzzzxxxx");
        return payPalCreditCardProcessor;
    }
}
