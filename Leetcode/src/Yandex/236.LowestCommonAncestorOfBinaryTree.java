class Solution {
    private TreeNode res;
    TreeNode p, q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        backtrack(root);
        return res;
    }

    public boolean backtrack(TreeNode node){
        if(node == null)return false;
        int left = backtrack(node.left) ? 1 : 0;
        int right = backtrack(node.right) ? 1 : 0;

        int mid = (node.val == p.val || node.val == q.val) ? 1 : 0;

        if(left + mid + right >= 2){
            res = node;
            return true;
        }
        return (left + mid + right > 0);
    }
}