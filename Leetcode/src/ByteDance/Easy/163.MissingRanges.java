class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        if(n == 0){
            list.add(Arrays.asList(lower, upper));
            return list;
        }

        if(nums[0] > lower){
            list.add(Arrays.asList(lower, nums[0] - 1));
        }

        for(int i = 0; i < n - 1; i++){
            int curr = nums[i];
            int next = nums[i+1];
            if(next - curr > 1){
                list.add(Arrays.asList(curr + 1, next - 1));
            }
        }

        if(nums[n - 1] < upper){
            list.add(Arrays.asList(nums[n - 1] + 1, upper));
        }

        return list;
    }
}