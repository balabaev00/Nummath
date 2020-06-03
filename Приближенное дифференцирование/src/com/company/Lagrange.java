package com.company;

public class Lagrange {
    private double[] X;
    private double[] Y;
    private double x;
    private int n;

    public Lagrange(double[] x, double[] y, double x1, int n) {
        X = x;
        Y = y;
        this.x = x1;
        this.n = n;
    }

    public double[] getX() {
        return X;
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setX(double[] x) {
        X = x;
    }

    public double[] getY() {
        return Y;
    }

    public void setY(double[] y) {
        Y = y;
    }

    public double method() {
        double y = 0,
                mul1 = 1,
                mul2 = 1,
                sum = 0;
        for (int k = 0; k < n; k++)
        {
            mul1 = 1;
            for (int j = 0; j < n; j++)
            {
                if (k == j) continue;
                mul1 *= (X[k] - X[j]);
            }

            sum = 0;
            for (int m = 0; m < n; m++)
            {
                if (k == m) continue;

                mul2 = 1;
                for (int i = 0; i < n; i++)
                {
                    if (i == m || i == k) continue;
                    mul2 *= (x - X[i]);
                }
                sum += mul2;
            }

            y += (Y[k] * (sum / mul1));
        }
        return y;
    }

}
