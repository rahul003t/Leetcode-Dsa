//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
	public static int countPaths(int N){
	int count=0;
	int mod = 1000000007;
	long curr=1;
	long prev=0;
	if(N==1)
	    return 0;
	if(N==2)
	    return 3;
	for(int i=3;i<=N;i++){
	    int temp = (int)curr;
	    curr= (2*curr + 3*prev)%mod;
	    prev=temp;
	}
	count=(int)((3*curr)%mod);

    return count;
        
	}
}		//code here

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends