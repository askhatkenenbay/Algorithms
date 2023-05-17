class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraySumHashMap(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}