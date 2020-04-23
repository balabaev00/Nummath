package com.company;

import java.util.Arrays;
import java.util.Locale;

public class Main {

    private static double[][] arrayZero(int n) {
        double[][] array = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = 0;
            }
        }
        return array;
    }

    private static void printArray(double[][] array, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j]+"\t");
                System.out.print("  ");
            }
            System.out.println();
        }
    }
    
    private static double[][] toArray(double[][] array, int i, int n) {
        double massive[][] = new double[1][n];
        for (int k = 0; k < n; k++) {
            massive[0][k]=array[i][k];
        }
        return massive;
    }

    private static double[][] toVector(double[][] vector, int i, int n) {
        double massive[][] = new double[n][1];
        for (int k = 0; k < n; k++) {
            massive[k][0]=vector[k][i];
        }
        return massive;
    }

    private static double mulArrayToVector(double[][] array, double[][] vector, int n) {
        double result = 0;
        for (int i = 0; i < n; i++) {
            result+=array[0][i]*vector[i][0];
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        double[][] a = {{-1,-5,-3,1,-4}, {-2,3,-2,2,4}, {1,4,4,-5,-3},{-4,-3,-3,5,-1}, {0,-1,-4,-2,5}};
        double[][] y = arrayZero(n);
        y[0][n-1] = 1;
        for (int j = n-2; j > -1; j--) {
            for (int i = 0; i < n; i++) {
                y[i][j]=mulArrayToVector(toArray(a,i,n),toVector(y,j+1,n),n);
            }
        }
        double[][] yn = arrayZero(n);
        double[][] temp = toVector(y,0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               yn[i][0]+=a[i][j]*temp[j][0];
            }
        }
        System.out.println("Матрица - A");
        printArray(a,n);
        System.out.println("Вектор - Y");
        printArray(y,n);
        System.out.println("Вектор - Yn");
        printArray(yn,n);
    }

}
