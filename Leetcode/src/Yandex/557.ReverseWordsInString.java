class Solution {
    public String reverseWords(String s) {
        String str = new StringBuilder(s).reverse().toString();
        String[] arr = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i--){
            builder.append(arr[i]);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }
}