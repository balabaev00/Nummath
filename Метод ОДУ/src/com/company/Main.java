package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {

    public static double f(double x, double y) {
        return (8*x*x-1)*Math.cos(y);
    }

    public static void linspace(ArrayList<Double> x, Double a,Double h, int n) {
        Double temp;
        for (int i = 0; i < n+1; i++) {
            temp = a+i*h;
            x.add(temp);
        }
    }

    public static void printList(ArrayList<Double> x) {
        for (int i = 0; i < x.size(); i++) {
            System.out.printf("%.3f",x.get(i));
            System.out.print("  ");
        }
        System.out.println();
    }

    // Зануляем элементы массива
    public static void zeroList(ArrayList<Double> x) {
        for (int i = 0; i < n+1; i++) {
            x.add(new Double(0));
        }
    }
    // Метод Эйлера
    public static void methodEuler(ArrayList<Double> x, ArrayList<Double> y) {
        for (int k = 0; k < n; k++) {
            double temp = y.get(k)+h*f(x.get(k),y.get(k));
            y.set(k+1,temp);
        }
    }

    // Метод Эйлера (Модифицированный)
    public static void methodEulerModificated(ArrayList<Double> x, ArrayList<Double> y, double h) {
        for (int k = 0; k < n; k++) {
            double temp = y.get(k)+h*f(x.get(k)+h/2,y.get(k)+h*f(x.get(k),y.get(k))/2);
            y.set(k+1,temp);
        }
    }

    // Метод Рунге-Кутта
    public static void methodRungeKutta(ArrayList<Double> x,ArrayList<Double> y,double h) {
        for (int k = 0; k < n; k++) {
            double a = h*f(x.get(k),y.get(k));
            double b = h*f(x.get(k)+h/2,y.get(k)+a/2);
            double c = h*f(x.get(k)+h/2,y.get(k)+b/2);
            double d = h*f(x.get(k)+h,y.get(k)+c);
            double temp = y.get(k)+(a+2*b+2*c+d)/6;
            y.set(k+1,temp);
        }
    }

    // Метод Адамса для 3 порядков
    public static void methodAdams(ArrayList<Double> x,ArrayList<Double> y, double h, int m) {
        if (m == 3) {
            for (int k = 3; k < n; k++) {
                double t = (55 * f(x.get(k), y.get(k))
                        - 59 * f(x.get(k - 1), y.get(k - 1))
                        + 37 * f(x.get(k - 2), y.get(k - 2))
                        - 9 * f(x.get(k - 3), y.get(k - 3)));
                double temp = y.get(k) + h * t / 24;
                y.set(k + 1, temp);
            }
        } else if (m == 2) {
            for (int k = 3; k < n; k++) {
                double t = (23*f(x.get(k),y.get(k))
                -16*f(x.get(k-1),y.get(k-1))
                +5*f(x.get(k-2),y.get(k-2)));
                double temp = y.get(k)+h*t/12;
                y.set(k+1,temp);
            }
        } else if (m==1) {
            for (int k = 3; k < n; k++) {
                double t = (3*f(x.get(k),y.get(k))
                -f(x.get(k-1),y.get(k-1)));
                double temp = y.get(k)+h*t/2;
                y.set(k+1,temp);
            }
        }
    }

    public static double a = 0;
    public static double b = 1;
    public static double eps = 0.001;
    public static double h = 0.1;
    public static int n = (int) ((b-a)/h);

    public static void main(String[] args) {
        ArrayList<Double> x = new ArrayList<Double>();
        ArrayList<Double> y = new ArrayList<Double>();
        zeroList(y);
        y.set(0,new Double(1));
        linspace(x,a,h,n);
        methodEuler(x,y);
        System.out.print("Метод Эйлера : ");
        printList(y);
        methodEulerModificated(x,y,h);
        System.out.print("Метод Эйлера (Модифицированный) : ");
        printList(y);
        methodRungeKutta(x,y,h);
        System.out.print("Метод Рунге-Кутта : ");
        printList(y);
        methodAdams(x,y,h,3);
        System.out.print("Метод Адамса 3 порядка : ");
        printList(y);
        methodAdams(x,y,h,2);
        System.out.print("Метод Адамса 2 порядка : ");
        printList(y);
        methodAdams(x,y,h,1);
        System.out.print("Метод Адамса 1 порядка : ");
        printList(y);
    }
}
