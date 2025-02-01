import lombok.experimental.UtilityClass;

@UtilityClass
public class Fibonacci {

    // fibonacci(0) = 0, fibonacci(1) = 1,
    // fibonacci(n) = fibonacci(n - 1) + fibonacci(n - 2) (for n >= 2)

    // iterative: O(n) time, O(1) space
    public static long fibonacci(byte n) {
        if (n < 0) throw new IllegalArgumentException("fibonacci(): n=" + n + " shouldn't be negative");
        if (n > 92) throw new IllegalArgumentException("fibonacci(): the n=" + n + "th fibonacci number is out of Java's long's range");

        if (n < 2) return n;
        long n_2 = 0, n_1 = 1, res = 1;
        for (int i = 2; i <= n; i++) {
            res = n_1 + n_2;
            n_2 = n_1;
            n_1 = res;
        }
        return res;
    }

    /* tail recur: still O(n) time, ***probably*** O(1) space
     * public static long fibonacci(byte n) {
     *     if (n < 2) return n;
     *     return fibonacciHelper(n, 2, 1, 0);
     * }
     *
     * private static long fibonacciHelper(byte n, byte currN, long prev, long prevPrev) {
     *     if (currN == n) return prev + prevPrev;
     *     return fibonacciHelper(n, currN + 1, prev + prevPrev, prev);
     * } */

    /* brute force: T(n) = 1 + T(n - 1) + T(n - 2) = O(2^n)
     * public static long fibonacci(byte n) {
     *     if (n < 2) return n;
     *     return fibonacci(n - 1) + fibonacci(n - 2);
     * } */
}
