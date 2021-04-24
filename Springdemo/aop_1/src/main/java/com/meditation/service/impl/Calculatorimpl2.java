package com.meditation.service.impl;

import com.meditation.service.Calculator;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: Springdemo
 * @Package: com.meditation.service.impl
 * @ClassName: Calculatorimpl
 * @Author: yf
 * @Description: ${description}
 * @Date: 2020/7/4 21:19
 */

@Service
public class Calculatorimpl2 implements Calculator {
    public int add(int i, int j) {
        int r = i + j;
        return r;
    }

    public int sub(int i, int j) {
        int r = i - j;
        return r;
    }

    public int mul(int i, int j) {
        int r = i * j;
        return r;
    }

    public int div(int i, int j) {
        int r = i / j;
        return r;
    }
}
