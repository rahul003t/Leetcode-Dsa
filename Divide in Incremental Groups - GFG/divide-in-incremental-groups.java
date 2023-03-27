//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.countWaystoDivide(N, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
 
    static int find(int n,int k,int pos,int min,int sum,int[][][] dp){
        
    
        if(pos==k-1){
        
            if((n-sum)>=min){
              
                dp[pos][n-sum][n]=1;
                return 1;
                
            }else{
       
                return 0;
            }
        }
  
    
        int t=0;
        for(int i=min;(i+sum)<=n;i++){
            
             int y=0;
             if(dp[pos][i][sum+i]==-1){
                 
                 y=find(n,k,pos+1,i,sum+i,dp);
                 dp[pos][i][sum+i]=y;
                 
             }else{
                 
                 y=dp[pos][i][sum+i];
             }
                t+=y;
        }
       
        return t;
        
    }
    public int countWaystoDivide(int N, int K) {
        
       int[][][] dp=new int[K][N+1][N+1];
      
       for(int i=0;i<K;i++){
           for(int j=0;j<N+1;j++){
               for(int u=0;u<N+1;u++){
                   
               dp[i][j][u]=-1;
               
               }
           }
       }
            return find(N,K,0,1,0,dp);
     
        
    }
}