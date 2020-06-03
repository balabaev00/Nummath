public class Main {

    public static double[][] generateMatrix(int n) {
        double[][] array = new double[n][n];
        for (int i = 0; i < array.length; i++) {
                array[i][j] = Math.random()*100+5;
        }
        return array;
    }
    public static int n = 5;

    public static void main(String[] args) {
        double[][] b = generateMatrix(n);
        double[][] c = generateMatrix(n);
        double[][] a = new double[n][n];
        a[1]=b[0]/c[0];
    }
}
