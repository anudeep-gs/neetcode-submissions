
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         for (int k = j + 1; k < nums.length; k++) {
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 List<Integer> triplet =
        //                     new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));

        //                 Collections.sort(triplet);

        //                 set.add(triplet);
        //             }
        //         }
        //     }
        // }

        // return new ArrayList<>(set);
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // No need to continue if the first number is positive
            if (nums[i] > 0) {
                break;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;

                    // Skip duplicate second elements
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    // Skip duplicate third elements
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }

                } else if (sum < 0) {
                    j++;

                } else {
                    k--;
                }
            }
        }

        return result;
    }
}