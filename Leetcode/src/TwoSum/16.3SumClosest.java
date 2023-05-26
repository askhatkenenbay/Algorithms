class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int size = nums.length;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length && diff != 0; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                int complement = target - nums[i] - nums[j];
                int index = Arrays.binarySearch(nums, j + 1, size - 1, complement);
                int right = index >= 0 ? index : ~index;
                int left = right - 1;
                if(right < size && Math.abs(complement - nums[right]) < Math.abs(diff)){
                    diff = complement - nums[right];
                }
                if(left > j && Math.abs(complement - nums[left]) < Math.abs(diff)){
                    diff = complement - nums[left];
                }
            }
        }
        return target - diff;
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length - 2 && diff != 0; i++){

            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    diff = 0;
                    break;
                }
                if(Math.abs(diff) > Math.abs(target - sum)){
                    diff = target - sum;
                }
                if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return target - diff;
    }
}