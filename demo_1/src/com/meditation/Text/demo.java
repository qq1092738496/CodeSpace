package com.meditation.Text;

import java.util.ArrayList;

public class demo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("asdasd");
        list.add("asdww");
        list.add(2312);
        for (Object s : list) {
            System.out.println(s);
        }

        System.out.println("-----------------");
        String[] arrs = {"asda", "asdasd"};
        for (String arr : arrs) {
            System.out.println(arr);
        }

        System.out.println("---------------------");
        int q = 1;
        int w = 1;
        int e = 0;

        int j = 0;
        for (int i = 1; i <= 12; i++) {
            q = w;
            w = w + e;
            e = q;
            j += q;
            System.out.println("第" + i + "月总:" + q);

        }
        System.out.println("一年共有" + j + "只兔子");

    }
}
