// Given a string, sort it in decreasing order based on the frequency of characters.
//
// Example 1:
//
// Input:
// "tree"
//
// Output:
// "eert"
//
// Explanation:
// 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// Example 2:
//
// Input:
// "cccaaa"
//
// Output:
// "cccaaa"
//
// Explanation:
// Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
// Note that "cacaca" is incorrect, as the same characters must be together.
// Example 3:
//
// Input:
// "Aabb"
//
// Output:
// "bbAa"
//
// Explanation:
// "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.
//
class Solution {
    public String frequencySort(String s) {
        List<Character> counts[] = new List[s.length() + 1];
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        for (Character c : frequencyMap.keySet()) {
            int value = frequencyMap.get(c);
            if (counts[value] == null) {
                counts[value] = new ArrayList<>();
            }
            for (int i = 0; i < value; i++)
                counts[value].add(c);
        }

        StringBuilder sb = new StringBuilder(s.length());
        for (int i = s.length(); i > 0; i--) {
            if (counts[i] == null)
                continue;
            while (counts[i].size() > 0) {
                sb.append(counts[i].remove(0));
            }
        }

        return sb.toString();
    }
}
