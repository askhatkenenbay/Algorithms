class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list1.length; i++){
            for(int j = 0; j < list2.length; j++){
                if(list1[i].equals(list2[j])){
                    if(i + j == min){
                        res.add(list1[i]);
                    }
                    if(i + j < min){
                        min = i + j;
                        res = new ArrayList<>();
                        res.add(list1[i]);
                    }
                }
            }
        }
        String[] arr = new String[res.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
}

class SolutionHashMap {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list1.length; i++){
            if(!map.containsKey(list1[i])){
                map.put(list1[i], i);
            }
        }
        List<String> list = new ArrayList<>();
        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i])){
                int sum = map.get(list2[i]) + i;
                min = Math.min(min, sum);
            }
        }
        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i])){
                int sum = map.get(list2[i]) + i;
                if(sum == min){
                    list.add(list2[i]);
                }
            }
        }
        String[] arr = new String[list.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}