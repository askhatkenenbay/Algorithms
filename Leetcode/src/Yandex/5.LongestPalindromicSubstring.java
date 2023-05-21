class BruteForceSolution {
    public String longestPalindrome(String s) {
        int res = 0;
        char arr[] = s.toCharArray();
        int x=0,y=0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                if(isPalindrome(arr, i, j)){
                    if(j - i + 1 > res){
                        res = j - i + 1;
                        x = i; y = j;
                    }   
                }
            }
        }
        return s.substring(x,y+1);
    }

    public boolean isPalindrome(char arr[], int start, int end){
        while(start <= end){
            if(arr[start] != arr[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}


class OptimizedSolution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        char arr[] = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            int lenEven = expand(arr, i, i);
            int lenOdd = expand(arr, i, i + 1);
            int len = Math.max(lenEven, lenOdd);
            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expand(char arr[], int left, int right){
        int i = left;
        int j = right;
        while(i >= 0 && j < arr.length && arr[i] == arr[j]){
            i--;
            j++;
        }
        return j - i - 1;
    }


}