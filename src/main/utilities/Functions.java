package main.utilities;

public class Functions {

    public static int calculeazaFactorial(int n) {
        if(n == 0) {
            return 1;
        }
        int n_factorial = 1;
        for(int i = 1; i <=n; i++) {
            n_factorial *= i;
        }
        return n_factorial;
    }

    public static int calculeazaCombinari(int n, int k) {
        return  (calculeazaFactorial(n) / (calculeazaFactorial(k) * calculeazaFactorial(n-k)));
    }

}
