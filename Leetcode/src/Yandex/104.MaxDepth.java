class Solution {
    int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return max;
    }
    
    public void dfs(TreeNode node, int curr){
        if(node == null){
            max = Math.max(max, curr);
            return;
        }
        dfs(node.left, curr + 1);
        dfs(node.right, curr + 1);
    }
}