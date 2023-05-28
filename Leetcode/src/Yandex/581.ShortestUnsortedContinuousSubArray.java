class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int left = -1;
        int right = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != temp[i]){
                left = i;
                break;
            }
        }
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] != temp[i]){
                right = i;
                break;
            }
        }
        if(left != -1){
            return right - left + 1;
        }else{
            return 0;
        }
    }
}


class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean isBroken = false;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i - 1]){
                isBroken = true;
            }
            if(isBroken){
                min = Math.min(min, nums[i]);
            }
        }
        if(!isBroken)return 0;
        isBroken = false;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] > nums[i + 1]){
                isBroken = true;
            }
            if(isBroken){
                max = Math.max(max, nums[i]);
            }
        }

        int left = -1;
        int right = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > min){
                left = i;
                break;
            }
        }
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] < max){
                right = i;
                break;
            }
        }
        return right - left + 1;
    }
}