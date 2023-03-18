
public class Node{
    String data;
    Node prev;
    Node next;
    
    public Node (String data)
    {
        this.data = data;
        prev= null;
        next = null;
    }

}

class BrowserHistory {
    Node head;
    
   

    public BrowserHistory(String homepage) {
        
        head = new Node(homepage);
    }
    
    public void visit(String url) {
        
        Node temp = new Node(url);
        head.next = temp;
        temp.prev = head;
        head = head.next;
        
    }
    
    public String back(int steps) {
        while(steps >0 && head.prev != null){
            steps--;
            head = head.prev;
        }
        
        return head.data;
        
    }
    
    public String forward(int steps) {
    while(steps >0 && head.next != null)
    {
        steps--;
        head = head.next;
    }
        
        return head.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */