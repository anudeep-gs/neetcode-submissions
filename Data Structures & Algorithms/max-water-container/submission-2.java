class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        // for(int i=0;i<heights.length;i++){
        //     for(int j=heights.length-1;j>0;j--){
        //         int water = Math.min(heights[i],heights[j])*(j-i);
        //         if(water>max){
        //             max=water;
        //         }
        //     }
        // }
        int i = 0;
        int j = heights.length - 1;
        while (i < j) {
            int water = Math.min(heights[i], heights[j]) * (j - i);
            if (water > max) {
                max = water;
            }
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
