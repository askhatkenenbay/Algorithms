class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            int val = temperatures[i];
            if(stack.peek().getKey() < val){
                while(!stack.isEmpty() && stack.peek().getKey() < val){
                    Pair<Integer, Integer> temp = stack.pop();
                    res[temp.getValue()] = i - temp.getValue();
                }
            }
            stack.push(new Pair(val, i));
        }
        return res;
    }
}


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--){
            int val = temperatures[i];
            if(val >= max){
                max = val;
                continue;
            }
            int days = 1;
            while(val >= temperatures[i + days]){
                days += res[i + days];
            }
            res[i] = days;
        }
        return res;
    }
}