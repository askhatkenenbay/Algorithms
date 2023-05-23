class Solution {
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int left = 0;
        int right = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                nums[i] = arr[left++];
            }else{
                nums[i] = arr[right--];
            }
        }
    }
}

class SolutionOptimal {

    public void swap(int[] nums, int i, int j){
        int val = nums[i];
        nums[i] = nums[j];
        nums[j] = val;
    }

    public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            if(i % 2 == 0 && nums[i] > nums[i + 1]){
                swap(nums,i,i+1);
            }
            if(i % 2 == 1 && nums[i] < nums[i + 1]){
                swap(nums,i,i+1);
            }
        }
    }
}