//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String s = read.readLine();
            Solution ob = new Solution();
            
            System.out.println(ob.cuts(s));
        }
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int cuts(String str) {

		for (int i = 22; i >= 0; i--)
			str = str.replaceAll(Long.toBinaryString((long) Math.pow(5, i)), "#");

		return str.contains("0") ? -1 : str.length();
	}
}
