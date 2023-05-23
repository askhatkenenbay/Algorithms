class Solution {
    public int calculateTime(String keyboard, String word) {
        int res = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = keyboard.toCharArray();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
        }
        int prev = 0;
        char[] target = word.toCharArray();
        for(char ch : target){
            res += Math.abs(prev - map.get(ch));
            prev = map.get(ch);
        }
        return res;
    }
}