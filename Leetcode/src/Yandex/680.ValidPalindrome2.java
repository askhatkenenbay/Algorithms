class Solution {
    public boolean validPalindrome(String s) {
        char[] arr =  s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            if(arr[left] != arr[right]){
                return isPalindrome(arr ,left,right - 1) || isPalindrome(arr , left + 1, right);
            }else{
                left++;
                right--;
            }
        }
        return true;
        
    }

    public boolean isPalindrome(char[] arr, int left, int right){
        while(left <= right){
            if(arr[left] != arr[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}