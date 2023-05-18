class Solution {
    HashSet<String> set = new HashSet();
    Solution(){
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int res = 0;
        
        for(int i = 0; i < tokens.length; i++){
            if(set.contains(tokens[i])){
                int x = stack.pop();
                int y = stack.pop();
                switch(tokens[i]){
                    case "+" :
                        stack.push(y+x);
                        break;
                    case "-" :
                        stack.push(y-x);
                        break;
                    case "*" :
                        stack.push(x*y);
                        break;
                    case "/" :
                        stack.push(y/x);
                        break;  
                }
            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}