//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
       int n = A.length();
       Queue<Character> q = new LinkedList<>();
       int[] map = new int[128];
       StringBuilder ans =new StringBuilder();
       
       for(char c : A.toCharArray()){ 
           map[c]++;
           
           if(map[c]==1) q.add(c);
           
           while(!q.isEmpty() && map[q.peek()]>1) q.remove();
           ans.append(q.isEmpty() ? '#' : q.peek());
       }
       return ans.toString();
    }
}