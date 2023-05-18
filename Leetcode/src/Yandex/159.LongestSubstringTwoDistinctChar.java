class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        char arr[] = s.toCharArray();
        for(int right = 0; right < arr.length; right++){
            char ch = arr[right];
            map.put(ch, map.getOrDefault(ch,0) + 1);
            if(map.size() <= 2){

            }else{
                while(map.size() > 2){
                    char temp = arr[left];
                    map.put(temp, map.get(temp) - 1);
                    if(map.get(temp) == 0){
                        map.remove(temp);
                    }
                    left++;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}