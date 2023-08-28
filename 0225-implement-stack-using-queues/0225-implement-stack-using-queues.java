class MyStack {
    private Queue<Integer> q = new LinkedList<>();

    MyStack() {
        
    }

    void push(int x) {
        q.add(x);
        int v = q.size() - 1;
        int i = 0;
        while (i < v) {
            q.add(q.poll());
            i++;
        }
    }

    int pop() {
        return q.poll();
    }

    int top() {
        return q.peek();
    }

    boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */