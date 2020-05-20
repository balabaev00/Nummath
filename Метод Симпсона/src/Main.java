

public class Main {

    public static double f(double x) {
        return x*x*Math.sin(x);
    }

    public static double intSympTE(double a, double b, int m) {
        int n = 3*m;
        double h = (b-a)/n;
        double[] x = new double[n+1];
        double[] y = new double[n+1];
        for (int k = 0; k < n+1; k++) {
            x[k]=a+h*k;
        }
        for (int k = 0; k < n+1; k++) {
            y[k]=f(x[k]);
        }
        double s = y[0]+y[3*m];
        for (int k = 1; k < m; k++) {
            s += 2*y[3*k];
        }
        for (int k = 1; k < m+1; k++) {
            s += 3*(y[3*k-1]+y[3*k-2]);
        }
        s = 3*s*h/8;
        return s;
    }

    public static void main(String[] args) {
        int maxN = 30;
        double eps = 0.00001;
        while (Math.abs(intSympTE(0.1,1.1,maxN)
                - intSympTE(0.1,1.1,2*maxN)) > eps) {
            maxN*=2;
        }
        System.out.format("%.6f",intSympTE(0.1,1.1,maxN));
    }
}
