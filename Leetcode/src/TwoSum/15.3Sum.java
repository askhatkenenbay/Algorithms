class SolutionHashSet {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length && nums[i] <= 0; i++){
            if(i == 0 || nums[i - 1] != nums[i]){
                twoSum(nums, i, res);
            }
        }
        return res;
    }

    public void twoSum(int[] nums, int i, List<List<Integer>> res){
        HashSet<Integer> set = new HashSet<>();
        for(int j = i + 1; j < nums.length; j++){
            int target = -nums[i] - nums[j];
            if(set.contains(target)){
                res.add(Arrays.asList(nums[i], nums[j], target));
                while(j + 1 < nums.length && nums[j] == nums[j + 1]){
                    j++;
                }
            }
            set.add(nums[j]);
        }
    }
}


class SolutionSort {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length && nums[i] <= 0; i++){
            if(i == 0 || nums[i - 1] != nums[i]){
                twoSum(nums, i, res);
            }
        }
        return res;
    }

    public void twoSum(int[] nums, int i, List<List<Integer>> list){
        int left = i + 1;
        int right = nums.length - 1;
        while(left < right){
            int sum = nums[i] + nums[left] + nums[right];
            if(sum > 0){
                right--;
            }else if(sum < 0){
                left++;
            }else{
                list.add(Arrays.asList(nums[i],nums[left++],nums[right--]));
                while(left < right && nums[left - 1] == nums[left]){
                    left++;
                }
            }
        }
    }
}


class SolutionNoSort {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        return new ArrayList(res);
    }
}