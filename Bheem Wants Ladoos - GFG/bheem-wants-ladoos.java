//{ Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int home = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            Solution x = new Solution();
            System.out.println( x.ladoos(root, home, k) );
            t--;
        }
    }
}


// } Driver Code Ends


/*
// node structure:

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution{
    static Node search(Node root,int home)
    {
        if(root==null)return null;
        if(root.data==home) return root;
        
        Node l=search(root.left,home);
        if(l!=null)return l;
        Node r=search(root.right,home);
        return r;
    }
    static void CreateConnection(Node root,HashMap<Node,Node> parent,Node p)
    {
        if(root==null)return;
        
        parent.put(root,p);//Key-> Root Value-> Parent
        
        CreateConnection(root.left,parent,root); // traversing left BT
        CreateConnection(root.right,parent,root);// traversing right BT
    }
    static int ladoos(Node root, int home, int k)
    {
        // Your code goes here
        
        //getting address for home
        Node target = search(root,home);
        
        //HashMap for storing Node and its parent
        HashMap<Node,Node> parent= new HashMap<>();
        
        CreateConnection(root,parent,null);
        
        //Creating a visited HashSet for checking
        HashSet<Node> visited= new HashSet<>();
        
        int Sum=0;
        
        //Using BFS
        Queue<Node>q= new LinkedList<>();
        q.add(target);
        visited.add(target);
        while(q.size()>0)
        {
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                Node temp= q.poll();
                Sum+=temp.data;
                
                if(temp.left!=null && !visited.contains(temp.left)) //left SubTree
                {
                    q.add(temp.left);
                    visited.add(temp.left);
                }
                if(temp.right!=null && !visited.contains(temp.right)) //right SubTree
                {
                    q.add(temp.right);
                    visited.add(temp.right);
                }
                if(parent.get(temp)!=null &&!visited.contains(parent.get(temp)))
                {
                    q.add(parent.get(temp));
                    visited.add(parent.get(temp));
                }
            }
            k--;
            if(k<0)break;
        }
        
        return Sum;
        
    }
}
