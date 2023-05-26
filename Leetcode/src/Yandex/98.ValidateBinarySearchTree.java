class Solution {
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    public boolean inorder(TreeNode node){
        if(node == null)return true;
        if(!inorder(node.left)){
            return false;
        }
        if(prev != null && node.val <= prev){
            return false;
        }
        prev = node.val;
        return inorder(node.right);
    }
}


class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean validate(TreeNode node, Integer low, Integer high){
        if(node == null)return true;

        if((low != null && node.val <= low) || (high != null && node.val >= high)){
            return false;
        }

        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}