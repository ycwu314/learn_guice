package com.example.billing.service.impl;

import com.example.billing.dto.CreditCard;
import com.example.billing.dto.PizzaOrder;
import com.example.billing.dto.Receipt;
import com.example.billing.service.BillingService;
import com.example.billing.service.CreditCardProcessor;
import com.example.billing.service.TransactionLog;
import lombok.Data;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by ycwu on 2017/9/19.
 */
@Data
public class RealBillingService implements BillingService {

    @Inject
    private TransactionLog transactionLog;
    @Inject
    @Named("checkout")
    private CreditCardProcessor creditCardProcessor;

    @Override
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        return null;
    }
}
