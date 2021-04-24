package com.meditation.service.impl;

import com.meditation.service.Calculator;
import org.springframework.stereotype.Service;


@Service
public class Calculatorimpl implements Calculator {

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
