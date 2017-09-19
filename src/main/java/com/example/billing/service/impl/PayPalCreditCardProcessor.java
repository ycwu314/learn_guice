package com.example.billing.service.impl;

import com.example.billing.service.CreditCardProcessor;
import lombok.Data;

/**
 * Created by ycwu on 2017/9/19.
 */
@Data
public class PayPalCreditCardProcessor implements CreditCardProcessor {

    private String apiKey;

}
