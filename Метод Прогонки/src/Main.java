public class Main {

    public static double[] generateMatrix(int n) {
        double[] array = new double[n];
        for (int i = 0; i < array.length; i++) {
                array[i] = 5 + (int) (Math.random() * 10);;
        }
        return array;
    }

    public static double[] generateZero(int n) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i]=0;
        }
        return array;
    }

    public static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "   ");
        }
        System.out.println();
    }

    public static int n = 5;

    public static void main(String[] args) {
        double[] a = generateMatrix(n-1); // Число уравнений
        double[] b = generateMatrix(n-1);
        double[] c = generateMatrix(n);
        double[] f = generateMatrix(n); // Столбец
        double[] alp = generateZero(n-1);
        double[] bet = generateZero(n);
        double[] gam = generateZero(n);
        double[] x = generateZero(n); // Ответ

        gam[0]=c[0];
        alp[0]=-b[0]/gam[0];
        bet[0]=f[0]/gam[0];
        
        System.out.println("b");
        printArray(b);
        System.out.println("c");
        printArray(c);
        System.out.println("a");
        printArray(a);
        System.out.println("f");
        printArray(f);

        for (int i = 1; i < n-1; i++) {
            gam[i]=c[i]+a[i-1]*alp[i-1];
            alp[i]=-b[i]/gam[i];
            bet[i]=(f[i]-a[i-1]*bet[i-1])/gam[i];
        }
        System.out.println("Альфа");
        printArray(alp);
        gam[n-1]=c[n-1]+(a[n-2]*alp[n-2]);
        bet[n-1]=(f[n-1]-(a[n-2]*bet[n-2]))/gam[n-1];
        System.out.println("Бета");
        printArray(bet);
        System.out.println("Гамма");
        printArray(gam);

        //Обратная подгонка
        x[n-1]=bet[n-1];
        for (int i = n-2; i > -1; i--) {
            x[i]=(alp[i]*x[i+1])+bet[i];
        }
        System.out.println("X");
        printArray(x);
    }
}
