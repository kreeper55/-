package search_extremums;

public class Function {
    public static double calc(double x) {
        // 2 * x^2 - e^x
        return 2*x*x  - Math.exp(x);
    }

    public static double squareEq(double x) {
        return 4*x - 0.5 * x*x;
    }

    public static double complex(double x) {
        return 7 * x * x * Math.cos(x) - Math.exp(-1 * (x * x));
    }

    public static double calc2(double x) {
        return x * x - 4 * x + 3;
    }
}
