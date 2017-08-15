public class Solution {
    public double myPow(double x, int n) {
        double ans = 1, base = x;
        long _n = n;
        boolean positive = _n >= 0;

        if (!positive) {
            _n = -_n;
        }

        while (_n != 0) {
            if ((_n & 1) != 0) {
                ans *= base;
            }
            base *= base;
            _n >>= 1;
        }

        return positive ? ans : 1 / ans;
    }
}