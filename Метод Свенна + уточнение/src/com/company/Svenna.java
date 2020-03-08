package com.company;

public class Svenna {
    private double x0;
    private double d;
    private double a;
    private double b;
    private double E = 0.001f;


    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public Svenna(double x0, double d) {
        this.x0 = x0;
        this.d = d;
    }

    public double f(double x) {
        return Math.pow(1.3, 2 * x * x - 3 * x + 1);
    }

    public double getX0() {
        return x0;
    }

    public double getD() {
        return d;
    }

    public void calculate() {
        double xC = this.x0;
        double xL = this.x0 - this.d;
        double xR = this.x0 + this.d;
        if (f(xC) < f(xL) && f(xC) < f(xR)) {
            a = xL;
            b = xR;
        }
        while (!((f(xC) < f(xL)) && (f(xC) < f(xR)))) {
            if ((f(xL) > f(xC)) && (f(xC) > f(xR))) {
                xL = xC;
                xC = xR;
                xR = xR + 2 * this.d;
            } else {
                if ((f(xL) < f(xC)) && (f(xC) < f(xR))) {
                    xR = xC;
                    xC = xL;
                    xL = xL - 2 * this.d;
                }
            }
            this.d *= 2;
        }
        this.a = xL;
        this.b = xR;
    }

    public double Gold() {
        double fi = (Math.sqrt(5) - 1) / 2;
        double x1, x2;
        while (this.b - this.a > 2 * E) {
            x1 = fi * a + (1 - fi) * b;
            x2 = (1 - fi) * a + fi * b;
            if (f(x1) < f(x2)) {
                this.b = x2;
            } else {
                this.a = x1;
            }
        }
        return (a + b) / 2;
    }

    public double Pol() {
        double x1;
        double x2;
        double x3;
        while ((b - a)  > (2 * E)) {
            x1 = (3 * a + b) / 4;
            x2 = (a + b) / 2;
            x3 = (a + 3 * b) / 4;
            if ((f(x1) < f(x2)) && (f(x2) < f(x3)))
                b = x2;
            else if (((f(x1) > f(x2)) && (f(x2) > f(x3)))) {
                a = x2;
            } else {
                a = x1;
                b = x3;
            }
        }
        return (a + b) / 2;
    }
}