package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        double[][] array = { {-1.8, 6.63552},
                {-0.3, -3.88773},
                {0.7, 16.99677},
                {0.9, 21.86919},
                {2.3, 15.99213},
                {3, 0} };
        Newton newton = new Newton(array);
        newton.print();
        System.out.println("Интерполяция по Лагранжу = " + newton.methodLagrange(1.8));
        System.out.println("Интерполяция по Ньютону (вперёд) = " + newton.methodNewtonForward(1.8));
        System.out.println("Интерполяция по Ньютону (назад) = " + newton.methodNewtonBack(1.8));

    }
}
