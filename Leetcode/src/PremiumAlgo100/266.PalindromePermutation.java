class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int oddCount = 0;
        for(char ch : arr){
            map.put(ch, map.getOrDefault(ch,0) + 1);
            if(map.get(ch) % 2 == 1){
                oddCount++;
            }else{
                oddCount--;
            }
        }
        
        return oddCount < 2;
    }
}