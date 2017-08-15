public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones = 0;

        for (int i = 0; i < 32; i++) {
            ones += n & 1;
            n >>>= 1;
        }

        return ones;
    }
}