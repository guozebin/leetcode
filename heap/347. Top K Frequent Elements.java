// Given a non-empty array of integers, return the k most frequent elements.
//
// For example,
// Given [1,1,1,2,2,3] and k = 2, return [1,2].
//
// Note:
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
//
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> bucket[] = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            // 将 key 作为频率，value 作为索引
            bucket[frequency].add(key);
        }
        // 频率高的将放在后面
        List<Integer> ret = new ArrayList<>();
        for (int idx = bucket.length - 1; idx >= 1 && ret.size() < k; idx--) {
            if (bucket[idx] != null) {
                ret.addAll(bucket[idx]);
            }
        }

        return ret;
    }
}