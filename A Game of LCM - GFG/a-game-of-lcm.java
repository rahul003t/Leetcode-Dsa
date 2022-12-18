//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.maxGcd(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    long gcd(long ans , long n){
        if (n ==0){
            return ans;
        }
        
        return gcd(n, ans%n);
    }
    long maxGcd(int N) {
        // code here
        long ans  = N*(N-1);
        int c = 0;
        for(long i = N-2; i>2 &&c<2; i--){
            if (gcd(ans, i) == 1){
                ans*=i;
                c++;
            }
        }
        return ans;
    }
}