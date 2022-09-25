class MyCircularQueue {
    
    Deque<Integer> queue;
    int size;

    public MyCircularQueue(int k) {
        queue = new LinkedList<>();
        size=k;
        
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        queue.addLast(value);
        return true;
    }
    
    public boolean deQueue() {
        
        if(isEmpty()){
            return false;
        }
        
        queue.pollFirst();
        return true;
        
    }
    
    public int Front() {
        
        if(isEmpty()){
            return -1;
        }
        
        return queue.getFirst();
    }
    
    public int Rear() {
        
        if(isEmpty()){
            return -1;
        }
        
        return queue.getLast();
    }
    
    public boolean isEmpty() {
        
        if(queue.size()==0){
            return true;
        }
        return false;
        
    }
    
    public boolean isFull() {
        
        if(queue.size()==size){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */