class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> res =new ArrayList<>();
        
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        for(int i : nums1){
            s1.add(i);
        }
        for(int i : nums2){
            s2.add(i);
        }

        for(int i : nums1){
            if(s2.contains(i)){
                s1.remove(i);
                s2.remove(i);
            }
        }

        for(int i : nums2){
            if(s1.contains(i)){
                s2.remove(i);
            }
        }

        List<Integer> one = new ArrayList<>(s1);
        List<Integer> two = new ArrayList<>(s2);
        res.add(one);res.add(two);
        return res;
    }
}