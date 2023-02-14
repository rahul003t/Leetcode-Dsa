//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] colors, int n){
        //Write your code here
        
        int[][] dp = new int[n][3];
         dp[0][0]= colors[0][0];
         dp[0][1]= colors[0][1];
         dp[0][2]= colors[0][2];
         
         for(int i=1;i<n;i++)
         {
            dp[i][0] = colors[i][0]+ Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = colors[i][1]+ Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = colors[i][2]+ Math.min(dp[i-1][0],dp[i-1][1]);
         }
         
         
         int ans = Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
         
         return ans;
        
    }
}