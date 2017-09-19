package com.example.billing.service.impl;

import com.example.billing.service.TransactionLog;
import lombok.Data;

/**
 * Created by ycwu on 2017/9/19.
 */
@Data
public class DatabaseTransactionLog implements TransactionLog {

    private String url;
    private String user;
    private String password;
}
