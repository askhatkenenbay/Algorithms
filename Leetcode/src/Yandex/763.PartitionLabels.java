class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
        }

        int left = 0;
        List<Integer> list = new ArrayList<>();
        int maxIndex = -1;
        for(int i = 0; i < arr.length; i++){
            char ch = arr[i];
            maxIndex = Math.max(maxIndex, map.get(ch));
            if(i == maxIndex){
                list.add(i - left + 1);
                left = i + 1;
                maxIndex = -1;
                continue;
            }

        }
        return list;
    }
}