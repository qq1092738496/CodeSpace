package com.meditation.Text;


import java.util.Scanner;

public class HelloWorld {


    public static void main(String[] args) {

       /* for(int i = 0;i < 10 ;i++){
                System.out.print(" ");
            }
            for (int y = 0; y < i*2-1; y++){
                System.out.print("*");
            }

            System.out.println();
        }

       for (int i = 0; i < 10 ;i++){
           for (int y = 0; y < i ; y++){
               System.out.print(" ");
           }
            for (int j = 18;j > i*2-1;j--){
                System.out.print("*");
            }
            System.out.println();
       }*/

        /*有一只兔子，从第3个月开始每月生1只兔子，
        小兔子长到第3个月开始每个月也会生1只兔子，假如兔子都不死，问每个月的兔子总数是多少？*/
       /*
        1
        1
        2
        3
        5
        8
        13
        21
        34
        55
        89
        */
        int q = 1;
        int w = 0;
        int z = 0;
        for (int i = 1; i <= 12; i++) {
            z = w;
            w = q + w;
            q = z;
            System.out.println(w+"adssaasda傻傻的阿斯顿啊");

        }
        System.out.println(rabbit(12));
        Scanner aa = new Scanner(System.in);
        int jj = aa.nextInt();

    }

    private static int rabbit(int moth) {

        if (moth < 3) {
            return 1;
        } else {
            return rabbit(moth - 2) + rabbit(moth - 1);
        }
    }
}

