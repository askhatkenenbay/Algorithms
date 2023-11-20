class Trie {
    Node root;
    public Trie() {
        root = new Node('#');
    }
    
    public void insert(String word) {
        char[] arr = word.toCharArray();
        Node node = root;
        for(int i = 0; i < arr.length; i++){
            if(node.map.containsKey(arr[i])){
                
            }else{
                node.map.put(arr[i], new Node(arr[i]));
            }
            node = node.map.get(arr[i]);
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        Node node = root;
        for(int i = 0; i < arr.length; i++){
            if(node.map.containsKey(arr[i])){
                node = node.map.get(arr[i]);
            }else{
                return false;
            }
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        Node node = root;
        for(int i = 0; i < arr.length; i++){
            if(node.map.containsKey(arr[i])){
                node = node.map.get(arr[i]);
            }else{
                return false;
            }
        }
        return true;
    }
}

class Node {
    char val;
    HashMap<Character, Node> map = new HashMap<>();
    boolean isWord = false;
    Node(char val){
        this.val = val;
    }

    public String toString(){
        return map.toString();
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */