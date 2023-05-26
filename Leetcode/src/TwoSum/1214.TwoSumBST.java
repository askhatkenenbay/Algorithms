class SolutionSet {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> set = new HashSet<>();
        dfs(root2, set);
        return isValid(root1, two, target);
    }

    public void dfs(TreeNode node, HashSet<Integer> set){
        if(node == null)return;
        set.add(node.val);
        dfs(node.left, set);
        dfs(node.right, set);
    }

    public boolean isValid(TreeNode node, HashSet<Integer> set, int target){
        if(node == null){
            return false;
        }
        if(set.contains(target - node.val)){
            return true;
        }
        return isValid(node.left, set, target) || isValid(node.right, set, target);
    }
}


class SolutionBST {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        return dfs(root1, root2, target);
    }

    public boolean dfs(TreeNode node, TreeNode root2, int target){
        if(node == null)return false;
        if(isValid(root2, target - node.val))return true;
        return dfs(node.left, root2, target) || dfs(node.right, root2, target);
    }

    public boolean isValid(TreeNode node, int target){
        if(node == null)return false;
        if(node.val == target)return true;
        if(node.val > target){
            return isValid(node.left, target);
        }else{
            return isValid(node.right, target);
        }
    }
}


class SolutionInorder {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        dfsInorder(root1, one);
        dfsInorder(root2, two);
        int left = 0;
        int right = two.size() - 1;
        while(left < one.size() && right >= 0){
            int sum = one.get(left) + two.get(right);
            if(sum == target)return true;
            if(sum > target){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }

    public void dfsInorder(TreeNode node, List<Integer> list){
        if(node == null)return;
        dfsInorder(node.left, list);
        list.add(node.val);
        dfsInorder(node.right, list);
    }
}