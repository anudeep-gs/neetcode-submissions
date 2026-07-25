class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int reslt=target-nums[i];
            if(map.containsKey(reslt)){
                return new int [] {map.get(reslt),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int [2];
    }
}
