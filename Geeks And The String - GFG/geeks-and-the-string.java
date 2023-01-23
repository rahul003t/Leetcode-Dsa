//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        // code here
        String ans = "";
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(!st.empty() && st.peek() == ch)
            {
                st.pop();
            }
            else
            {
                st.push(ch);
            }
            
        }
        
        if(st.isEmpty())
        {
            return "-1";
        }
        
        while(!st.isEmpty())
        {
            ans = st.pop()+ans;
        }
        
        return ans;
        
    }
}
        
