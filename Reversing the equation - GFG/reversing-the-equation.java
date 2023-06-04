//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    String reverseEqn(String S) {
        Stack<String> st = new Stack<>();
        int n = S.length();
        int p1 = 0, p2 = 0;

        while (p2 < n) {
            if (!Character.isDigit(S.charAt(p2))) {
                st.push(S.substring(p1, p2));
                st.push(Character.toString(S.charAt(p2)));
                p1 = p2 + 1;
            }

            p2++;
        }

        st.push(S.substring(p1, n));
        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.peek());
            st.pop();
        }

        return sb.toString();
    }
}
 