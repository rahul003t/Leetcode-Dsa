//{ Driver Code Starts
//Initial Template for Java
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out=new PrintWriter(System.out);
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
    	    	int target=Integer.parseInt(br.readLine());
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
        	    long ans=g.verticallyDownBST(root,target);
        	    out.println(ans);
                t--;
            
        }
        out.close();
    }
  
}




// } Driver Code Ends


//User function Template for Java
class Solution

{

    class Pair{

        int hd;

        Node node;

        boolean isPar;

        Pair(int hd, Node node, boolean isPar)

        {

           this.hd = hd;

           this.node = node;

           this.isPar = isPar;

        }

    }

    long verticallyDownBST(Node root,int target)

    {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, root, false));

        int ans = Integer.MIN_VALUE;

        boolean flag = false;

        int sum = 0;

        while(!q.isEmpty())

        {

            Pair cur = q.remove();

            int hd = cur.hd;

            Node tem = cur.node;

            boolean boolPar = cur.isPar;

            if(flag == true && hd == ans && boolPar == true)

            {

                //System.out.println(tem.data);

                sum += tem.data;

            }

            if(tem.data == target)

            {

                ans = hd;

                flag = true;

                boolPar = true;      

           }

            if(tem.left != null)

            {

                 if(boolPar)

                {

                   q.add(new Pair(hd-1, tem.left, true));

                }

                else

                {

                    q.add(new Pair(hd-1, tem.left, false));

               }          

            }

            if(tem.right != null)

            {

                if(boolPar)

                {

                   q.add(new Pair(hd+1, tem.right, true));

                }

                else

                {

                    q.add(new Pair(hd+1, tem.right, false));

                }

            }

       }

        if(flag)

        {

          return sum;  

        }

        return -1;

        

    }

}