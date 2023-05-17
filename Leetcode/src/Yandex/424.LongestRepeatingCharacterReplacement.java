class Solution {
    public int characterReplacementBinary(String s, int k) {
        int left = 1;
        int right = s.length();
        char[] arr = s.toCharArray();
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(valid(arr, mid, k)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left - 1;
    }

    public boolean valid(char[] arr, int window, int k){
        int map[] = new int[26];
        int maxFrequency = 0;
        int left = 0;
        for(int right = 0; right < arr.length; right++){
            map[ arr[right] - 'A' ] += 1;
            if(right - left + 1 > window){
                map[ arr[left] - 'A' ] -= 1;
                left++;
            }
            maxFrequency = Math.max(maxFrequency, map[arr[right] - 'A']);
            if(window - maxFrequency <= k){
                return true;
            }
        }
        return false;
    }


    public int characterReplacementWindow(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        for(char ch : arr){
            set.add(ch);
        }
        int res = 0;
        for(char ch : set){
            int left = 0;
            int curr = 0;
            for(int right = 0; right < arr.length; right++){
                if(arr[right] != ch){
                    if(curr < k){
                        curr++;
                    }else{
                        while(arr[left] == ch){
                            left++;
                        }
                        left++;
                    }
                }
                res = Math.max(res, right - left + 1);
            }
        }
        return res;
    }


    public int characterReplacementBest(String s, int k) {
        int left = 0;
        int res = 0;
        int maxFreq = 0;
        int map[] = new int[26];
        char arr[] = s.toCharArray();
        for(int right = 0; right < arr.length; right++){
            char ch = arr[right];
            map[ch - 'A'] += 1;
            maxFreq = Math.max(maxFreq, map[ch - 'A']);
            
            boolean isValid = (right - left + 1 - maxFreq <= k);
            if(!isValid){
                map[ arr[left] - 'A' ] -= 1;
                left++;
            }

            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}