class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : words){
            map.put(str, map.getOrDefault(str,0) + 1);
        }
        PriorityQueue<Pair<String,Integer>> pq = new PriorityQueue<>((a,b) ->{
            if(a.getValue() != b.getValue()){
                return a.getValue() - b.getValue();
            }else{
                return b.getKey().compareTo(a.getKey());
            }
        });
        for(String str : map.keySet()){
            Pair<String, Integer> p = new Pair(str, map.get(str));
            pq.add(p);
            if(pq.size() > k){
                pq.poll();
            }
        }
        LinkedList<String> list = new LinkedList<>();
        while(!pq.isEmpty()){
            list.addFirst(pq.poll().getKey());
        }
        return list;
    }
}