//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException
    {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node(Integer.parseInt(s[0])), tail = head;
        for(int i = 1; i < s.length; i++)
            tail = tail.next = new Node(Integer.parseInt(s[i]));

        return head;
    }

    public static void printList(Node node)
    {
        while (node != null)
        {
    		System.out.print(node.data + " ");
    		node = node.next;
    	}
    	System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node head = Node.inputList(br);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            Node res = obj.reverse(head, k);
            
            Node.printList(res);
            
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static Node reverse(Node head, int k) {
        // code here
        Node head1=null,head2=null;
        head1=head;
        Node t=head1;
        
        while(k!=1)
        {
            t=t.next;
            k--;
        }
        
        head2=t.next;
        t.next=null;
        
        head1=reverse(head1);
        head2=reverse(head2);
        Node head3=head1;
        Node prev = null;
        
        while(head3 != null)
        {
            prev = head3;
            head3= head3.next;
        }
        
        prev.next=head2;
        return head1;
    }
    
    static Node reverse(Node node)
    {
        Node prev=null;
        Node current=node;
        Node next = null;
        
        while(current != null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current = next;
        }
        
        node=prev;
        return node;
    }
}
        
     
