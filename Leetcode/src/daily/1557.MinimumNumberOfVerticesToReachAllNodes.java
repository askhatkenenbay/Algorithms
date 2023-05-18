class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(i);
        }
        for(List<Integer> temp : edges){
            set.remove(temp.get(1));
        }
        List<Integer> list = new ArrayList<>(set);
        return list;
    }
}