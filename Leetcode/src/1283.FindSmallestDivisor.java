class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 1000000;
        int res = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isValid(nums, threshold, mid)){
                res = Math.min(res, mid);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }

    public boolean isValid(int[] nums, int threshold, int divisor){
        int sum = 0;
        for(int i : nums){
            sum += i / divisor;
            if(i % divisor != 0){
                sum++;
            }
        }
        return sum <= threshold;
    }
}