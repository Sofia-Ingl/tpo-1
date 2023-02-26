package task1;

public class ArcCos {

    public static double arccos(double x) {

        if ((x > 1) || (x < -1)) {
            return Double.NaN;
        }

        double res = x;

        double a = 1;
        double b = 2;
        double n = 2;

        double term = 1;

        while (Math.abs(term) > 0.0001) {
            term = Math.pow(x, 2 * n - 1) * a / (b * (2 * n - 1));
            res += term;
            a *= 2L * n - 1;
            b *= 2L * n;
            n++;
        }
        return Math.PI / 2 - res;
    }

}
