package com.company;


public class Main {

    public static void main(String[] args) {
        double[] X = {0.4,1.2,2.9,3.1,4.7,5.5,6.3};
        double[] Y = {3.9,9.3,2.4,0.4,-9.9,-7.1,0.2};
        Lagrange lagrange = new Lagrange(X,Y,6.4,X.length);
        System.out.printf("%.3f", lagrange.method());
    }
}
