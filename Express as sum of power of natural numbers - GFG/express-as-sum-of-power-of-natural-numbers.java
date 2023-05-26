//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{   static long M = 1000000007l;
    public static int numOfWays(int targetSum, int pow){
        long[][] dp = new long[targetSum + 1][targetSum+1];
        for(int i = 0 ; i <= targetSum ; i++){
            dp[i][0] = 1;
        }
        for(int i = 1 ; i <= targetSum ; i++){
            for(int j = 1 ; j <= targetSum ; j++){
                long cur = power(i , pow);
                long count = 0;
                count += dp[i-1][j];
                if(j - cur >= 0){
                    count += dp[i-1][j-(int)cur];
                }
                dp[i][j] = (count % M);
            }
        }
        return (int)dp[targetSum][targetSum];
    }
    private static long power(long base  , int power){
        if(power == 0) return 1;
        if(power == 1) return base;
        if(power % 2 == 0){
            return power(base * base , power / 2);
        }else{
            return base * power(base * base , power / 2);
        }
    }
    
}