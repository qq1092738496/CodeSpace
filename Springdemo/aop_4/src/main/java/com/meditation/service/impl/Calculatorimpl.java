package com.meditation.service.impl;

public class Calculatorimpl {
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
        int r = 0;

        try {
            r = i / j;
        } finally {

        }

        return r;
    }
}
