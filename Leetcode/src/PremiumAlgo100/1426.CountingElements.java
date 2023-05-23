class Solution {
    public int countElements(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int res = 0;
        for(int key : map.keySet()){
            if(map.containsKey(key + 1))res += map.get(key);
        }
        return res;
    }
}