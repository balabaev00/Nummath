package com.company;

public class Main {

    public static void main(String[] args) {
        Trapeze trapeze = new Trapeze();
        System.out.println("Метод трапеций (a) = " + trapeze.methodTrapeze(0.8,1.6,0.001));
        System.out.println("Метод симпсона (a) = " + trapeze.methodSimpson(0.8,1.6,4));
        System.out.println("Метод трапеций (b) = " + trapeze.methodTrapeze1(1.2,2,0.001));
        System.out.println("Метод симпсона (b) = " + trapeze.methodSimpson1(1.2,2,4));
    }
}
