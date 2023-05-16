class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int sum = 0;
        for(int i = 0, j = 0; j < nums.length; j++){
            sum += nums[j];
            while(i < j && sum < j - i){
                sum -=nums[i++];
            }
            res = Math.max(res, j - i + 1);
        }
        return res;

    }
}