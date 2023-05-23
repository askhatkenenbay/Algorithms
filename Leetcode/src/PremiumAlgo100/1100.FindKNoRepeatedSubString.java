class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        char[] arr = s.toCharArray();
        int res = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            char ch = arr[i];
            while(set.contains(ch)){
                set.remove(arr[left++]);
            }
            set.add(ch);
            while(set.size() > k){
                set.remove(arr[left++]);
            }
            
            if(i - left + 1 == k){
                res++;
            }
        }
        return res;
    }


}