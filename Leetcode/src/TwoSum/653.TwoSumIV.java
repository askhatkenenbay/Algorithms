class Solution {
    HashSet<Integer> set = new HashSet<>();
    int target = 0;
    public boolean findTarget(TreeNode root, int k) {
        target = k;
        return dfs(root);
    }
    
    public boolean dfs(TreeNode node){
        if(node == null)return false;
        
        int complement = target - node.val;
        if(set.contains(complement))return true;
        set.add(node.val);
        
        return dfs(node.left)
         || dfs(node.right);
    }
}