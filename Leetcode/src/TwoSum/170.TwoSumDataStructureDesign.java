class TwoSum {
    List<Integer> list = new ArrayList<>();
    public TwoSum() {
        
    }
    
    public void add(int number) {
        list.add(number);
    }
    
    public boolean find(int value) {
        return twoSum(value);
    }

    public boolean twoSum(int target){
        HashSet<Integer> set = new HashSet<>();
        for(int i : list){
            if(set.contains(target - i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */