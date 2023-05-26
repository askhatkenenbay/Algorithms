class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length - 2; i++){
            res += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return res;
    }

    public int twoSumSmaller(int[] nums, int start, int target){
        int end = nums.length - 1;
        int res = 0;
        while(start < end){
            int sum = nums[start] + nums[end];
            if(sum < target){
                res+= end - start;
                start++;
            }else{
                end--;
            }
        }
        return res;
    }
}