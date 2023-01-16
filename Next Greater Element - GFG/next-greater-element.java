//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    Solution ob = new Solution();
		    long[] res = ob.nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


// User Function Template for JAVA


class Solution{
    public static long[] nextLargerElement(long[] arr, int n) { 
        // Your code here
        //creating a Long array to store the answer value
        long[] ans = new long[n];
      
        //here I using stak operation so i cretae a stack
        Stack<Long> st=new Stack<>();
        
        //traversing from the last element of the array
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek() < arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ans[i] = -1;
            }
            else
            {
                ans[i] = st.peek();
            }
            
            st.push(arr[i]);

        }
        
        return ans;
    } 
}