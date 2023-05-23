class Solution {
    public int shortestWay(String source, String target) {
        char[] arrSource = source.toCharArray();
        char[] arrTarget = target.toCharArray();
        int res = 0;
        int i = 0;
        int j = 0;
        int prev = -1;
        while(j < arrTarget.length){
            int index = i % arrSource.length;
            
            if(prev == index){
                return -1;
            }
            if(i % arrSource.length == 0)res++;
            if(arrTarget[j] == arrSource[index]){
                j++;
                i++;
                prev = -1;
            }else{
                if(prev == -1){
                    prev = index;
                }
                i++;
            }
        }

        return res;
    }
}