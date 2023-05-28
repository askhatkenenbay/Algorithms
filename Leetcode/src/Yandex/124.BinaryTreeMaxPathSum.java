class Solution {
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        postOrderTraversal(root);
        return maxSum;
    }

    public int postOrderTraversal(TreeNode root){
        if(root == null)return 0;
        int leftPathSum = postOrderTraversal(root.left);
        leftPathSum = Math.max(leftPathSum,0);
        int rightPathSum = postOrderTraversal(root.right);
        rightPathSum = Math.max(rightPathSum, 0);
        
        int val = leftPathSum + rightPathSum + root.val;
        maxSum = Math.max(maxSum, val);
        return Math.max(root.val + leftPathSum, root.val + rightPathSum);
    }
}