class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public MyQueue() {
        
    }
    
    // O(n)
    public void push(int x) {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s2.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    //O(1)
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}



class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int front = 0;
    public MyQueue() {
        
    }
    
    // O(1)
    public void push(int x) {
        if(s1.isEmpty()){
            front = x;
        }
        s1.push(x);
    }
    //O(1) amortized
    public int pop() {
        int res = front;
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}