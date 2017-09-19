package com.example.billing.service;

import com.example.billing.dto.CreditCard;
import com.example.billing.dto.PizzaOrder;
import com.example.billing.dto.Receipt;

/**
 * Created by ycwu on 2017/9/19.
 */
public interface BillingService {

    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);

}
