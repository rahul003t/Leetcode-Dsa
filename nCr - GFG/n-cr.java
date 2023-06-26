//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int nCr(int n, int r)
    {
        // code here
        int modC = 1000000007,res=1;
        java.math.BigInteger result = new java.math.BigInteger("1");
        if(r>n)
          return 0;
        else if(r==0 || r== n)
          return 1;
        else if(r==1)
          return n;
        for(int i=0;i<=r;i++){
            if(i==0 || i == n)
               result = result.multiply(java.math.BigInteger.valueOf(1));
            else if(i==1)
               result = result.multiply(java.math.BigInteger.valueOf(n));
            else{
               result= result.multiply(java.math.BigInteger.valueOf(n-i+1));
               result = result.divide(java.math.BigInteger.valueOf(i));
            }
           //System.out.println(result + " " + i);
        }
           result = result.mod(java.math.BigInteger.valueOf(modC));
           
           res = result.intValue();
           return res;
    }
}