class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = 101;
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != prev){
                nums[left] = nums[i];
                left++;
                prev = nums[i];
            }
        }
        return left;
    }
}