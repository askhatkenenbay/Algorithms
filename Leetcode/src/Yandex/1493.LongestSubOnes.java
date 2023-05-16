class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int res = 0;
        boolean hasZero = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if(hasZero == false){
                    hasZero = true;
                }else{
                    right++;
                    while(nums[left] == 1){
                        left++;
                    }
                    left++;
                }
            }else{
                right++;
            }
            res = Math.max(res, right - left+1);
        }
        if(!hasZero)return nums.length - 1;
        return res-1;
    }

    public int longestSubarrayShort(int[] nums) {
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
