// Given an integer array nums and an integer k, return the k most frequent elements within the array.
// The test cases are generated such that the answer is always unique.
// You may return the output in any order.
// Example 1:
// Input: nums = [1,2,2,3,3,3], k = 2
// Output: [2,3]

// Example 2:
// Input: nums = [7,7], k = 1
// Output: [7]

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {

            int count = entry.getValue();

            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }

            bucket[count].add(entry.getKey());
        }

        int[] ans = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {

            if (bucket[i] != null) {

                for (int num : bucket[i]) {

                    ans[index++] = num;

                    if (index == k)
                        break;
                }
            }
        }

        return ans;
    }
}