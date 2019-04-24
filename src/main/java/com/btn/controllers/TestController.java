package com.btn.controllers;

import com.btn.annotations.BtController;
import com.btn.annotations.BtQualifier;
import com.btn.annotations.BtRequestMapping;
import com.btn.annotations.BtRequestParam;
import com.btn.services.TestService;
import com.btn.services.TestService2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@BtController
@BtRequestMapping("/test")
public class TestController {
    @BtQualifier("testService")
    private TestService testService;

    // 测试@BrService使用默认值
    @BtQualifier("testService2Impl")
    private TestService2 testService2;

    /**
     * 测试的url：http://localhost:8080/spring-mvc/test/1?str_param=233&int_param=2&float_param=1.2&double_param=2.5
     *
     * @param request
     * @param response
     * @param strParam
     * @param intParam
     * @param floatParam
     * @param doubleParam
     */
    @BtRequestMapping("/1")
    public void test1(HttpServletRequest request, HttpServletResponse response,
                      @BtRequestParam("str_param") String strParam,
                      @BtRequestParam("int_param") Integer intParam,
                      @BtRequestParam("float_param") Float floatParam,
                      @BtRequestParam("double_param") Double doubleParam) {
        testService.doServiceTest();
        testService2.doServiceTest();
        try {
            response.getWriter().write(
                    "String parameter: " + strParam +
                            "\nInteger parameter: " + intParam +
                            "\nFloat parameter: " + floatParam +
                            "\nDouble parameter: " + doubleParam);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
