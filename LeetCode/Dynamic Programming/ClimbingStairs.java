public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 1) return 0;

        // f(1) = 1, f(2) = 2,
        // f(n) = f(n - 2) + f(n - 1) (for n >= 3)
        if (n == 1) return 1; if (n == 2) return 2;
        int prevPrev = 1, prev = 2, res = prevPrev + prev;
        for (int i = 3; i <= n; i++) {
            res = prevPrev + prev;
            prevPrev = prev;
            prev = res;
        }
        return res;
    }
}