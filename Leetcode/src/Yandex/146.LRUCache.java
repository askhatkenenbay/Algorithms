class LRUCache {

    class LinkedNode{
        int key;
        int val;
        LinkedNode prev;
        LinkedNode next;
    }

    private void addNode(LinkedNode node){
        //add note after head
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node){
        LinkedNode before = node.prev;
        LinkedNode after = node.next;

        before.next = after;
        after.prev = before;
    }

    private void moveToHead(LinkedNode node){
        //move node to head
        removeNode(node);
        addNode(node);
    }

    private LinkedNode popTail(){
        //remove last node
        LinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private HashMap<Integer,LinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private LinkedNode head;
    private LinkedNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new LinkedNode();
        this.tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        LinkedNode node = cache.get(key);
        if(node == null)return -1;
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if(node == null){
            node = new LinkedNode();
            node.key = key;
            node.val = value;
            cache.put(key, node);
            addNode(node);
            size++;
            if(size > capacity){
                LinkedNode lastNode = popTail();
                cache.remove(lastNode.key);
                size--;
            }
        }else{
            node.val = value;
            moveToHead(node);
        }
    }
}