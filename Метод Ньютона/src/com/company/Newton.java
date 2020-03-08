package com.company;

public class Newton {
    private double[][] array;

    public Newton(double[][] array) {
        this.array=array;
    }

    double methodLagrange(double x) {
        double lagrange = 0;
        int n = this.array.length;
        double num, denom;
        for (int k = 0; k < n; k++) {
            num=1;
            for (int i = 0; i < n; i++)
                if(i!=k) num*=x-array[i][0];
            denom=1;
            for (int j = 0; j < n; j++)
                if(j!=k) denom*=array[k][0]-array[j][0];
            lagrange+=array[k][1]*(num/denom);
        }
        return lagrange;
    }


    double[][] separatedDifferences() {
        int n = array.length;
        double[][] y = new double[n][n];
        for (int i = 0; i < n; i++) {
            y[i][0] = array[i][1];
        }
        for (int m = 1; m < n; m++)
        {
            for (int k = 0; k < n - m; k++)
            {
                y[k][m] = (y[k + 1][m - 1] - y[k][m - 1]) / (array[k + m][0] - array[k][0]);
            }
        }
        return y;
    }

    double methodNewtonForward(double x) {
        double[][] y = separatedDifferences();
        double forward = array[0][1];
        double pr = 1;
        int n = array.length;
        for (int k = 1; k < n; k++) {
            pr *= x - array[k-1][0];
            forward += y[0][k]*pr;
        }
        return forward;
    }

    double methodNewtonBack(double x) {
        int n = array.length;
        double back = array[n-1][1];
        double pr = 1;
        double[][] y = separatedDifferences();
        for (int k = 1; k < n; k++) {
            pr *= x - array[n-k][0];
            back += y[n-(k+1)][k]*pr;
        }
        return back;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
