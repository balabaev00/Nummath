package com.company;

public class Main {

    private static double[][] MINV(double [][]A, int N)
    {
        double temp;

        double [][] E = new double [N][N];


        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
            {
                E[i][j] = 0f;

                if (i == j)
                    E[i][j] = 1f;
            }

        for (int k = 0; k < N; k++)
        {
            temp = A[k][k];

            for (int j = 0; j < N; j++)
            {
                A[k][j] /= temp;
                E[k][j] /= temp;
            }

            for (int i = k + 1; i < N; i++)
            {
                temp = A[i][k];

                for (int j = 0; j < N; j++)
                {
                    A[i][j] -= A[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }

        for (int k = N - 1; k > 0; k--)
        {
            for (int i = k - 1; i >= 0; i--)
            {
                temp = A[i][k];

                for (int j = 0; j < N; j++)
                {
                    A[i][j] -= A[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = E[i][j];
            return A;
    }

    public static double[][] MMUL(double[][] matrixOne, double[][] matrixTwo, int n) {
        double[][] res = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += matrixOne[i][k] * matrixTwo[k][j];
                }
            }
        }
        return res;
    }

    public static double[][] generateOneMatrix(int n) {
        double[][] array = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j) {
                    array[i][j] = 1;
                }
            }
        }
        return array;
    }

    public static double[][] methodDanilevskogo(double[][] array, int n) {
        double[][] e;
        for (int i = 1; i < n; i++) {
            e=generateOneMatrix(n);
            for (int j = 0; j < n; j++) {
                if(j==n-i-1) {
                    e[n - i - 1][j] = 1 / array[n - (i - 1) - 1][n - i - 1];
                }
                else {
                    e[n - i - 1][j] = -array[n - (i - 1) - 1][j]/ array[n - (i - 1) - 1][n - i - 1];
                }
            }
            printMatrix(e,n);
            array=MMUL(MMUL(MINV(e,n),array,n),e,n);
        }
        return array;
    }

    public static void printMatrix(double[][] array, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%.2f", array[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        double[][] array = {{1,2,3,4},{2,1,2,3},{3,2,1,-2},{-4,3,2,1}};
        int n = 4;
        array = methodDanilevskogo(array,n);
        printMatrix(array,n);
    }
}
