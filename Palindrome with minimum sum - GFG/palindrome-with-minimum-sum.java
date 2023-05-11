//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumSum(String s) {
        
        int l=s.length();
        StringBuilder sb= new StringBuilder(s);
        
        for(int i=0;i<l/2;i++){
            
            if(s.charAt(i)=='?' && s.charAt(l-1-i)=='?') continue;
            else if(s.charAt(i)=='?' && s.charAt(l-1-i)!='?') sb.setCharAt(i,s.charAt(l-1-i));
            else if(s.charAt(i)!='?' && s.charAt(l-1-i)=='?') sb.setCharAt(l-1-i,s.charAt(i));
            else{
                if(s.charAt(i)!= s.charAt(l-1-i)) return -1;
            }
        }
        
        int count=0;
        char prev=' ';
        for(int i=0;i<l;i++){
            
            char curr= sb.charAt(i);
            if(curr=='?') continue;
            if(prev==' '){
                prev=curr;
                continue;
            }
            count += Math.abs(curr-prev);
            prev=curr;
            
        }
        
        return count;
    }
}

