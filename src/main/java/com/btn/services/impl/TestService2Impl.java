package com.btn.services.impl;

import com.btn.annotations.BtService;
import com.btn.services.TestService2;

@BtService
public class TestService2Impl implements TestService2 {
    @Override
    public void doServiceTest() {
        System.out.println("业务层执行方法了2222222222222");
    }
}
