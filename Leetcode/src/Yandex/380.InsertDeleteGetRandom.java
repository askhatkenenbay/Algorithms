class RandomizedSet {
    HashMap<Integer,Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))return false;
        map.put(val, list.size());
        list.add(list.size(),val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))return false;

        int index = map.get(val);
        int lastVal = list.get(list.size()-1);
        list.set(index, lastVal);
        map.put(lastVal, index);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
