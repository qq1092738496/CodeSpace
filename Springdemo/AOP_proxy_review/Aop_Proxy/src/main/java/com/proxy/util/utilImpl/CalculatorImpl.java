package com.proxy.util.utilImpl;

import com.proxy.util.Calculator;

/**
 * @description:
 * @author: Andy
 * @time: 2020/10/4 22:30
 */

public class CalculatorImpl implements Calculator {
    public int add(int i, int j) {
        return i + j;
    }

    public int subtract(int i, int j) {
        return i - j;
    }

    public int multipy(int i, int j) {
        return i * j;
    }

    public int division(int i, int j) {
        return i / j;
    }
}
