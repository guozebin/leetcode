public class Solution {
    public int hammingDistance(int x, int y) {
        int distance = 0;
        
        for (int i = 0; i < 31; i++) {
            if (((x & 1) ^ (y & 1)) == 1) {
                ++distance;
            }
            x >>= 1;
            y >>= 1;
        }

        return distance;
    }
}