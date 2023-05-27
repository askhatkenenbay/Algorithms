class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        return isValid(root.left, root.right);
    }

    public boolean isValid(TreeNode one, TreeNode two){
        if(one == null && two == null){
            return true;
        }else if((one != null && two == null) || (one == null && two != null)){
            return false;
        }else{
            if(one.val != two.val)return false;
            return isValid(one.left, two.right) && isValid(one.right, two.left);
        }
    }
}