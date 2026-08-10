class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int maxN=0;
        for(int i : piles){
            maxN=Math.max(i,maxN);
        }
        int r = maxN;
        int res = r;

        while (l <= r) {
            int k = l + (r - l) / 2;

            int hours = 0;

            for (int pile : piles) {
                hours += (pile + k - 1) / k; // ceiling division
            }

            if (hours <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return res;
    }
}