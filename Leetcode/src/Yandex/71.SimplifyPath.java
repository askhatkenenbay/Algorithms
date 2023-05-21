class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String components[] = path.split("/");
        for(String component : components){
            if(component.equals(".") || component.isEmpty()){
                continue;
            }else if(component.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(component);
            }
        }
        StringBuilder builder = new StringBuilder();
        for(String str : stack){
            builder.append("/");
            builder.append(str);
        }
        return builder.length() > 0 ? builder.toString() : "/";
    }
}