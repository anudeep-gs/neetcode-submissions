class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 1;
        for (int i = 0; i < nums.length; i++) {
            // Is this the beginning of a sequence?
            if (!set.contains(nums[i] - 1)) {
                int current = nums[i];
                int length = 1;

                // Keep going forward
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
