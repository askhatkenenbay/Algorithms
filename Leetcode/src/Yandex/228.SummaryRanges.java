class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int left = i;
            int j = i + 1;
            while(j < nums.length){
                if(nums[j-1] + 1 == nums[j]){
                    j++;
                }else{
                    j--;
                    break;
                }
            }
            if(j >= nums.length){
                j--;
            }
            if(nums[i] == nums[j]){
                res.add(nums[i]+"");
            }else{
                res.add(nums[i]+"->"+nums[j]);
            }
            i = j++;
        }
        return res;
    }
}