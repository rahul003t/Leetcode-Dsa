//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.BalancedString(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
   static int sumOfDigits(int n) {
       if(n<=9) {
           return n;
       }
       return sumOfDigits(n/10)+(n%10);
   }
   static String BalancedString(int N) {
       // code here
       String res = "";
       String str = "abcdefghijklmnopqrstuvwxyz";
       int m = N;
       while(m >= 26) {
           res += str;
           m -= 26;
       }
       if(N%2 == 0) {
           N %= 26;
           for(int i=0;i<N/2;i++) {
               res += (char)(i+'a');
           }
           String res1 = "";
           for(int i=0;i<N/2;i++) {
               res1 = (char)('z'-i) + res1;
           }
           return res+res1;
       }
       
       int sum = sumOfDigits(N);
       N %= 26;
       if(sum%2 == 0) {
           for(int i=0;i<(N+1)/2;i++) {
               res += (char)(i+'a');
           }
           String res1 = "";
           for(int i=0;i<(N-1)/2;i++) {
               res1 = (char)('z'-i) + res1;
           }
           return res+res1;
       }
       
       for(int i=0;i<(N-1)/2;i++) {
               res += (char)(i+'a');
       }
       String res1 = "";
       for(int i=0;i<(N+1)/2;i++) {
           res1 = (char)('z'-i) + res1;
       }
       return res+res1;
   }
}

