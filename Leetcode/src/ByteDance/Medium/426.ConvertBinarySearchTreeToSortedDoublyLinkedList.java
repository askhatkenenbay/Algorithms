class Solution {
    Node min;
    Node max;
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        dfs(root);
        min.left = max;
        max.right = min;
        return min;
    }

    public void dfs(Node node){
        if(node != null){
            dfs(node.left);
            if(max != null){
                max.right = node;
                node.left = max;
            }else{
                min = node;
            }
            max = node;
            dfs(node.right);
        }
    }
}