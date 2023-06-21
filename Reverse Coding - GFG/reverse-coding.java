//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);

            Solution ob = new Solution();
            System.out.println(ob.sumOfNaturals(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static int sumOfNaturals(int n) {
        // code here
        
         int m=(int)Math.pow(10,9)+7;
        long p=n;
        return(int)((p*(p+1)/2)%m);
    }
};