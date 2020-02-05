package com.company;

import java.util.Scanner;

public class Main {
    public static double f(double value) {
        return 2*value*value+16/value;

    }
    public static double pol(double a, double b, double eps) {
        double x1;
        double x2;
        double x3;
        while ((b - a) < (2 * eps)) {
            x1 = (3*a+b)/4;
            x2 = (a+b)/2;
            x3 = (a+3*b)/4;
            if ((f(x1)<f(x2))&&(f(x2)<f(x3)))
                b = x2;
            else
                if (((f(x1)>f(x2))&&(f(x2)>f(x3)))) {
                    a = x2;
                }
                else {
                    a = x1;
                    b = x3;
                }
        }
        return (a+b)/2;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите x[0] : ");
        double x_zero = scanner.nextDouble();
        System.out.print("Введите d (d>0) : ");
        double d = scanner.nextDouble();
        if (d<=0) {
            throw new Error();
        }

        double xC = x_zero;
        double xL = x_zero-d;
        double xR = x_zero+d;
        double xN;
        double a;
        double b;
        int iterator = 0;
        while (!((f(xL)>f(xC))&&(f(xR)>f(xC)))) {
            if ((f(xL)>f(xC)) && (f(xC)>f(xR))) {
                xN = xR+2*d;
                xL = xC;
                xC = xR;
                xR = xN;
            }
            else {
                if ((f(xL)<f(xC)) && (f(xC)<f(xR))) {
                    xN = xL - 2*d;
                    xR = xC;
                    xC = xL;
                    xL = xN;
                }
                d = d*2;
            }
            iterator++;
        }
        a = xL;
        b = xR;
        System.out.println("Количество итераций : " + iterator);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("Половинное деление : " + pol(a,b,0.00001));
    }
}
