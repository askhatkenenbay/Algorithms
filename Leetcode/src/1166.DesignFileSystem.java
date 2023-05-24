class FileSystem {


    TrieNode root;
    public FileSystem() {
        this.root = new TrieNode("");
    }
    
    public boolean createPath(String path, int value) {
        String[] arr = path.split("/");
        TrieNode curr = root;
        for(int i = 1; i < arr.length; i++){
            String currName = arr[i];
            if(!curr.map.containsKey(currName)){
                if(arr.length - 1 == i){
                    curr.map.put(currName, new TrieNode(currName));
                }else{
                    return false;
                }
            }
            curr = curr.map.get(currName);
        }

        if(curr.val != -1){
            return false;
        }
        curr.val = value;
        return true;
    }
    
    public int get(String path) {
        String[] arr = path.split("/");
        TrieNode curr = root;
        for(int i = 1; i < arr.length; i++){
            String currName = arr[i];
            if(!curr.map.containsKey(currName)){
                return -1;
            }
            curr = curr.map.get(currName);
        }
        return curr.val;
    }
}


class TrieNode {
    int val = -1;
    String name;
    Map<String, TrieNode> map = new HashMap<>();
    TrieNode (String name){
        this.name = name;
    }
}