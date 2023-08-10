//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int dp(int x, int y, String s1, String s2, int matrix[][]){
         int i = x-1;
        int j = y-1;
        if(x < 0 || y <0){
            return 0;
        }
        
        if(matrix[x][y]!=-1){
            return matrix[x][y];
        }
        
        else {
             if(s1.charAt(x) == s2.charAt(y)){
              return matrix[x][y] = 1 + dp(x-1,y-1,s1,s2,matrix);
        }
        else return matrix[x][y] = 0+ Math.max(dp(x-1,y,s1,s2,matrix), dp(x,y-1,s1,s2,matrix));
        }
       
        
    }
    
    static int lcs(int x, int y, String s1, String s2)
    {
       int matrix[][] = new int[x][y];
       
       for(int rows[]: matrix){
           Arrays.fill(rows,-1);
       }
       return dp(x-1,y-1,s1,s2,matrix);
    }
    
}