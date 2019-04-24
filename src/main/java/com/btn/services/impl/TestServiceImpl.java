package com.btn.services.impl;

import com.btn.annotations.BtService;
import com.btn.services.TestService;

@BtService("testService")
public class TestServiceImpl implements TestService {
    @Override
    public void doServiceTest() {
        System.out.println("业务层执行方法了。。。");
    }
}
