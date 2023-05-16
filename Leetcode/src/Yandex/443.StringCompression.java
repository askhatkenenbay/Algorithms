class Solution {
    public int compress(char[] chars) {
        int res = 0;
        char prev = chars[0];
        int count = 0;
        String str = "";
        for(int i = 0; i < chars.length; i++){
            if(prev == chars[i]){
                count++;
            }else{
                if(count == 1){
                    str += prev;
                }else{
                    str += prev+""+count;
                }

                prev = chars[i];
                count=1;
            }
        }
        if(count == 1){
            str += prev;
        }else{
            str += prev+""+count;
        }
        char temp[] = str.toCharArray();
        for(int i = 0; i < temp.length; i++){
            chars[i] = temp[i];
        }
        return str.length();
    }
}