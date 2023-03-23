//{ Driver Code Starts
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

class GFG {
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t > 0){
	            int n=Integer.parseInt(br.readLine().trim());
	            String s[] = br.readLine().trim().split(" ");

	            int target=Integer.parseInt(br.readLine().trim());
    	    	Node root = null;
                for(int i=0;i<n;i++){
                    root=insert(root,Integer.parseInt(s[i]));
                }
        	    Solution g = new Solution();
        	    System.out.println(g.maxDifferenceBST(root,target));
                t--;
            
        }
    }

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) return new Node(val);
    
        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }
    
        return tree;
    }
  
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
 
    static int min = Integer.MAX_VALUE;
    
    public static void minPath(Node a, int currentSum)
    {
        if(a == null) return;
        
        
        currentSum += a.data;
        
        if(a.left == null && a.right == null)
        {
            min = Math.min(min, currentSum);
            
            return;
        }
        
        minPath(a.left, currentSum);
        
        minPath(a.right, currentSum);
    }
    
    public static int maxDifferenceBST(Node root,int target)
    {
        //Please code here
        min = Integer.MAX_VALUE;
        
        Queue<Node> q = new LinkedList<>();
        
        if(root == null) return -1;
        
        q.add(root);
        
        int upperSum = 0;
        
        while(!q.isEmpty())
        {
            Node temp = q.peek();
            
            if(temp == null) return -1;
            
            if(temp.data == target) break;
            
            else if(temp.data > target)
            {
                upperSum += temp.data;
                q.add(temp.left);
            }
            else{
                upperSum += temp.data;
                q.add(temp.right);
            }
            
            q.poll();
            
        }
        
        if(q.isEmpty())
        {
            return -1;
        }
        
        minPath(q.poll(), 0);
        
        min = min - target;
        return upperSum - min;
    }
}