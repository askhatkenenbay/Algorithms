class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char arr[] = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
        }
        int i = 0;
        List<Integer> list = new ArrayList<>();
        for(; i < arr.length; i++){
            char ch = arr[i];
            int right = getRightLimit(arr, i, map);
            list.add(right - i + 1);
            i = right;
        }
        return list;
    }


    public int getRightLimit(char arr[], int index, HashMap<Character, Integer> map){
        int targetIndex = map.get(arr[index]);
        for(int i = index; i < arr.length; i++){
            targetIndex = Math.max(targetIndex, map.get(arr[i]));
            if(targetIndex == i){
                return i;
            }
        }
        return arr.length - 1;
    }
}