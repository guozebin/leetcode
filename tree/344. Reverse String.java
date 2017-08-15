public class Solution {
    public String reverseString(String s) {
        StringBuilder ret = new StringBuilder(s.length());

        for (int i = s.length() - 1; i > - 1; --i) {
            ret.append(s.charAt(i));
        }

        return ret.toString();
    }
}