class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length > nums1.length){
            return intersect(nums2, nums1);
        }    

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums1){
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int i : nums2){
            if(map.containsKey(i)){
                list.add(i);
                map.put(i, map.get(i) - 1);
                if(map.get(i) == 0){
                    map.remove(i);
                }
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}


class SolutionSort {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }
        }
        int[] array = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            array[k] = list.get(k);
        }
        return array;
    }
}