public class Solution {
    public String reverseString(String s) {
        char ret[] = new char[s.length()];
        int i = s.length();

        for (char c : s.toCharArray()) {
            ret[--i] = c;
        }

        return String.valueOf(ret);
    }
}