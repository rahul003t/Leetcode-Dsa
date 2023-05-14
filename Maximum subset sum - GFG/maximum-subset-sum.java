//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.findMaxSubsetSum(N, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {

    public static long findMaxSubsetSum(int n, int[] arr) {
       

        int flag=1;
        long[][] dp = new long[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return findMaxSubsetSumR(n,arr,flag,0,dp);
        
    }
    
    
    public static long findMaxSubsetSumR(int n, int[] arr, int flag, int idx,long[][] dp){
        
        
        if(idx==n) return 0;
        
        if(dp[idx][flag]!=-1) return dp[idx][flag];
        
        long sum1=Integer.MIN_VALUE;
        long sum2=Integer.MIN_VALUE;
        if(flag==1){
            sum1 = findMaxSubsetSumR(n,arr,0,idx+1,dp);
        } 
             
        sum2 =  arr[idx] +findMaxSubsetSumR(n,arr,1,idx+1,dp);
             
        return dp[idx][flag]=(long)Math.max(sum1,sum2);
        
    }
}
        
