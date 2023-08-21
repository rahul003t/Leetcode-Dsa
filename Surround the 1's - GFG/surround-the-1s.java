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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean isSurrounded(int row, int col, int n, int m, int[][] matrix){
        
        int[][] dirr = new int[][] {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        int count=0;
        for(int[] k:dirr){
            int nrow=row+k[0]; //nrow - neighbour row
            int ncol=col+k[1]; //ncol - neighbour column
            if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&matrix[nrow][ncol]==0){
                count++;
            }
        }
        
        if(count!=0 && count%2==0){
            return true;
        }
        return false;
    }
    
    public int Count(int[][] matrix)
    {
        // code here
        int n = matrix.length;
        int m = matrix[0].length;
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 1 && isSurrounded(i, j, n, m, matrix)){
                    count++;
                }
            }
        }
        
        return count;
    }
}

