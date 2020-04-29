package com.company;

public class Main {

    public static double a = 0;
    public static double b = 1;
    private static double h = 0.1;
    private static int n = (int) ((b-a)/h);
    private static double eps = 0.0001;

    private static double f(double x, double y) {
        //return (8*x*x-1)*Math.cos(y);
        return (x*x+1)*Math.sin(y);
    }

    private static double[] zeros(int n) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i]=0;
        }
        return array;
    }

    private static double[] generateArray(int n, double h) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i]=i*h;
        }
        return array;
    }

    private static void printArray(double[] array, int n) {
        for (int i = 0; i < n; i++) {
            System.out.printf("%4f", array[i]);
            System.out.print("  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        double[] x;
        double[] y;
        double[] ypr;
        double[] ykor;
        double a,b,c,d;
        double e;

        x = generateArray(n + 1, h);
        y = zeros(n + 1);
        ypr = zeros(n + 1);
        ykor = zeros(n + 1);
        y[0] = 1;

        for (int k = 0; k < 4; k++) {
            a = h * f(x[k], y[k]);
            b = h * f(x[k] + h / 2, y[k] + a / 2);
            c = h * f(x[k] + h / 2, y[k] + b / 2);
            d = h * f(x[k] + h, y[k] + c);
            y[k + 1] = y[k] + (a + 2 * b + 2 * c + d) / 6;
        }

        for (int k = 4; k < n + 1; k++) {
            ypr[k] = y[k-4] + (4*h) / 3*( 2*f(x[k-3],y[k-3] )-f( x[k-2],y[k-2] )+2*f( x[k-1],y[k-1] ));
            ykor[k] = y[k-2] + (h/3)*(f(x[k-2],y[k-2] )+4*f(x[k-1],y[k-1] )+ f(x[k], ypr[k] ));
            e = Math.abs(ykor[k] - ypr[k]) / 29;
            if (e < eps)
                y[k] = ykor[k];
            else
                y[k] = ypr[k];
        }
        printArray(y,n+1);
    }
}
