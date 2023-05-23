class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int res = 0;
        for(int i = 1; i < arrays.size(); i++){
            List<Integer> list = arrays.get(i);
            res = Math.max(res, max - list.get(0));
            res = Math.max(res, list.get(list.size()-1) - min);
            min = Math.min(min, list.get(0));
            max = Math.max(max, list.get(list.size() - 1));
        }
        return res;
    }
}