class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())return false;
        HashMap<Character,Integer> targetMap = new HashMap<>();
        for(char ch : s1.toCharArray()){
            targetMap.put(ch, targetMap.getOrDefault(ch,0) + 1);
        }
        int size = s1.length();
        HashMap<Character, Integer> tempMap = new HashMap<>();
        char[] arr = s2.toCharArray();
        for(int i = 0; i < size; i++){
            tempMap.put(arr[i], tempMap.getOrDefault(arr[i],0)+1);
        }
        if(targetMap.equals(tempMap))return true;
        int left = 0;
        for(int i = size; i < arr.length; i++){
            tempMap.put(arr[left], tempMap.get(arr[left]) - 1);
            if(tempMap.get(arr[left]) == 0){
                tempMap.remove(arr[left]);
            }
            left++;
            tempMap.put(arr[i], tempMap.getOrDefault(arr[i],0)+1);
            if(targetMap.equals(tempMap))return true;
        }
        return false;
    }
}