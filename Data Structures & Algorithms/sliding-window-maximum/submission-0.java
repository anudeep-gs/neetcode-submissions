class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // int start = 0;
        // int end = k - 1;
        // List<Integer> lst = new ArrayList<>();
        // while (end < nums.length) {
        //     int max = Integer.MIN_VALUE;
        //     for (int i = start; i <= end; i++) {
        //         if (max < nums[i])
        //             max = nums[i];
        //     }
        //     lst.add(max);
        //     start++;
        //     end++;
        // }
        // int[] ans = new int[lst.size()];

        // for (int i = 0; i < lst.size(); i++) {
        //     ans[i] = lst.get(i);
        // }

        // return ans;
        //[1,2,1,0,4,2,6]
        Deque<Integer> deque = new ArrayDeque<>();

        int[] ans = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // Remove indices that are out of the window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Record answer once the first window is formed
            if (i >= k - 1) {
                ans[index++] = nums[deque.peekFirst()];
            }
        }

        return ans;
    }
}
