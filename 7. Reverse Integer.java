// Reverse digits of an integer.
//
// Example1: x = 123, return 321
// Example2: x = -123, return -321
//
// click to show spoilers.
//
// Note:
// The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
//
class Solution {
    public int reverse(int x) {
         String absString = String.valueOf(Math.abs(x));
         int length = absString.length();
         char c[] = new char[length];

         for (int i = 0; i < length; i++) {
             c[i] = absString.charAt(length - i - 1);
         }
         String revString = String.valueOf(c);
         if (x > 0 && revString.length() > 9 && revString.compareTo("2147483647") > 0) {
             return 0;
         }
         if (x < 0) {
             revString = "-" + revString;
             if (revString.length() > 10 && revString.compareTo("-2147483648") > 0) {
                 return 0;
             }
         }

         return Integer.parseInt (revString);
    }
}
