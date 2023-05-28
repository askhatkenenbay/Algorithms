class Solution {
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        dfs(root, low, high);
        return sum;
    }

    public void dfs(TreeNode node, int low, int high){
        if(node == null)return;
        if(node.val >= low && node.val <= high){
            sum += node.val;
        }
        if(low < node.val){
            dfs(node.left, low, high);
        }
        if(node.val < high){
            dfs(node.right, low, high);
        }
    }
}