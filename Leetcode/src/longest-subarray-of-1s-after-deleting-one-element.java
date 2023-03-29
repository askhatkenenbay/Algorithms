/*
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 */

 class Solution {
    public int longestSubarray(int[] nums) {
        int sum = 0;
        int res = -1;
        for(int i = 0, j = 0; j < nums.length; j++){
            sum += nums[j];
            while(i < j && sum < j - i){
                sum-=nums[i++];
            }
            res = Math.max(res, j - i);
        }
        if(res == -1){
            return nums.length - 1;
        }
        return res;
    }
}