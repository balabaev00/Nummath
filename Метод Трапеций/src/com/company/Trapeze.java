package com.company;

public class Trapeze {

    private double f(double x) {
        return(1/Math.sqrt(2*x*x+1));
    }

    private double f1(double x) {
        return Math.log(x+2)/x;
    }

    private double max(double a,double b) {
        if(a>b)
            return a;
          else return b;
    }

    /*Производная второго порядка для первой функции*/
    private double fff(double x) {
        double first = (2*(6*Math.pow(x,2)/(2*Math.pow(x,2)+1))-1);
        double second = 2/(Math.pow(2*x*x+1,3/2));
        return first/second;
    }

    /*Производная второго порядка для второй функции*/
    private double fff1(double x) {
        return (2*Math.log(x)+1)/Math.pow(x,3);
    }

    public double methodTrapeze(double a, double b, double eps) {
        double max = max(fff(a),fff(b));
        int n = (int) Math.ceil(Math.sqrt(max*Math.pow(b-a,3)/(12*eps)));
        double h = (b-a)/n;
        double w = 0;
        double x1,x2;
        for (int k = 0; k < n-1; k++) {
            x1 = a+k*h;
            x2 = a+h*(k+1);
            w += (f(x1)+f(x2))*h/2;
        }
        return w;
    }

    public double methodSimpson(double a, double b, double m) {
        double n = 2*m;
        double h = (b-a)/n;
        double s = 0;
        double s1 = 0;
        double s2 = 0;
        double x;
        for (int k = 1; k < m; k++) {
            x = a+(2*k-1)*h;
            s1 += f(x);
        }

        for (int k = 0; k < m-1; k++) {
            x = a+2*k*h;
            s2 += f(x);
        }
        s = (4*s1+2*s2+f(a)+f(b))*h/3;
        return s;
    }

    public double methodTrapeze1(double a, double b, double eps) {
        double max = max(fff1(a),fff1(b));
        int n = (int) Math.ceil(Math.sqrt(max*Math.pow(b-a,3)/(12*eps)));
        double h = (b-a)/n;
        double w = 0;
        double x1,x2;
        for (int k = 0; k < n-1; k++) {
            x1 = a+k*h;
            x2 = a+h*(k+1);
            w += (f1(x1)+f1(x2))*h/2;
        }
        return w;
    }

    public double methodSimpson1(double a, double b, double m) {
        double n = 2*m;
        double h = (b-a)/n;
        double s = 0;
        double s1 = 0;
        double s2 = 0;
        double x;
        for (int k = 1; k < m; k++) {
            x = a+(2*k-1)*h;
            s1 += f1(x);
        }

        for (int k = 0; k < m-1; k++) {
            x = a+2*k*h;
            s2 += f1(x);
        }
        s = (4*s1+2*s2+f1(a)+f1(b))*h/3;
        return s;
    }
}
