class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtracking(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public void backtracking(List<String> list, StringBuilder builder, int open, int close, int n){
        if(builder.length() == 2 * n){
            list.add(builder.toString());
            return;
        }
        if(open < n){
            builder.append("(");
            backtracking(list, builder, open + 1, close, n);
            builder.deleteCharAt(builder.length() - 1);
        }
        if(open > close){
            builder.append(")");
            backtracking(list, builder, open, close + 1, n);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
    
}