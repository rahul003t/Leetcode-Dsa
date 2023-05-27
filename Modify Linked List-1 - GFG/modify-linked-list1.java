//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    static Node reverse(Node n){
        Node prev = null;
        Node nn = null;
        while(n != null){
            nn = n.next;
            n.next = prev;
            prev = n;
            n = nn;
        }
        return prev;
    }
    public static Node modifyTheList(Node head)
    {
        Node curr = head;
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        int mid = len/2;
        curr = head;
        int i = 0;
        if(len % 2 == 0){
            mid--;
        }
        while(i != mid){
            curr = curr.next;
            i++;
        }
        Node join = curr;
        Node r = reverse(curr.next);
        
        curr = head;
        Node curr2 = r;
        while(curr2 != null){
            int temp = curr.data;
            curr.data = curr2.data - curr.data;
            curr2.data = temp;
            curr = curr.next;
            curr2 = curr2.next;
        }
        r = reverse(r);
        join.next = r;
        return head;
   
    }
}