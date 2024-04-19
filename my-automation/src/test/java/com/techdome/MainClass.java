package com.techdome;

public class MainClass {
    public static void main(String[] args) {
    	ecomtestcases testcases = new ecomtestcases();
        testcases.setup();
        testcases.loginTest();
        testcases.searchProductTest();
        testcases.getProductDetailsTest();
        testcases.teardown();
        
    }
}