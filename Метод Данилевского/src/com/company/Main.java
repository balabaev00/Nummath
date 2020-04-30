package com.company;


public class Main {

    static final int N = 4;

    static void getCofactor(double A[][], double temp[][], double p, double q, int n)
    {
        int i = 0, j = 0;

        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                if (row != p && col != q)
                {
                    temp[i][j++] = A[row][col];

                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    static double determinant(double A[][], int n)
    {
        double D = 0;
        if (n == 1)
            return A[0][0];
        double [][]temp = new double[N][N];
        double sign = 1;
        for (int f = 0; f < n; f++)
        {
            getCofactor(A, temp, 0, f, n);
            D += sign * A[0][f] * determinant(temp, n - 1);

            sign = -sign;
        }

        return D;
    }

    static void adjoint(double A[][],double [][]adj)
    {
        if (N == 1)
        {
            adj[0][0] = 1;
            return;
        }

        double sign = 1;
        double [][]temp = new double[N][N];

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                getCofactor(A, temp, i, j, N);
                sign = ((i + j) % 2 == 0)? 1: -1;
                adj[j][i] = (sign)*(determinant(temp, N-1));
            }
        }
    }

    static boolean MINV(double A[][], double [][]inverse)
    {
        double det = determinant(A, N);
        if (det == 0)
        {
            System.out.print("Singular matrix, can't find its inverse");
            return false;
        }

        double [][]adj = new double[N][N];
        adjoint(A, adj);

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                inverse[i][j] = adj[i][j]/(double)det;

        return true;
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
        double[][] e = new double[0][];
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
            double[][] inv = new double[n][n];
            MINV(e,inv);
            double[][] mul1 = MMUL(inv,array,n);
            double[][] mul2 = MMUL(mul1,e,n);
            array=mul2;
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
        //double[][] array = {{1,2,3,4},{2,1,2,3},{3,2,1,-2},{-4,3,2,1}};
        double[][] array = {{-1,-5,-3,1,-4},{-2,3,-2,2,4},{1,4,4,-5,-3},{-4,-3,-3,5,-1}, {0,-1,-4,-2,5}};
        int n = 4;
        array = methodDanilevskogo(array,n);
        printMatrix(array,n);
    }
}
