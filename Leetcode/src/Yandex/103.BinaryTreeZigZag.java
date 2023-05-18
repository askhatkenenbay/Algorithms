class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap();
        dfs(root, map, 0);

        int i = 0;
        List<List<Integer>> list = new ArrayList<>();
        while(map.containsKey(i)){
            list.add(map.get(i));
            i++;
        }
        return list;
    }

    public List<Integer> reverse(List<Integer> list){
        for(int i = 0; i < list.size() / 2; i++){
            int val = list.get(i);
            list.set(i, list.get(list.size() - 1 - i));
            list.set(list.size() - 1 - i, val);
        }
        return list;
    }

    public void dfs(TreeNode node, HashMap<Integer, LinkedList<Integer>> map, int index){
        if(node == null){
            return;
        }
        LinkedList<Integer> list = null;
        if(map.containsKey(index)){
            list = map.get(index);
        }else{
            list = new LinkedList<>();
        }
        if(index % 2 == 1){
            list.addFirst(node.val);
        }else{
            list.add(node.val);
        }
        map.put(index, list);
        dfs(node.left, map, index + 1);
        dfs(node.right, map, index + 1);
    }
}