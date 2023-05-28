class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(char ch : arr){
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        int sum = 0;
        boolean isOdd = false;
        for(char ch : map.keySet()){
            int val = map.get(ch);
            if(val % 2 == 0){
                sum += val;
            }else{
                if(val > 2){
                    // aaaaa -> 5 - 1 -> 4
                    sum += (val - 1);
                }
                isOdd = true;
            }
        }
        if(isOdd)sum++;
        return sum;
    }
}