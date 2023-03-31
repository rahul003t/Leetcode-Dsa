//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int [] lexicographicallyLargest(int [] arr, int n) {
        //Write your code here
        Integer[]res = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
               res[i] = arr[i];
        }
        for (int i=0; i<n;) {
            int j = i;
            int cnt = arr[i] & 1;
            while(i < n && (arr[i] & 1) == cnt) {
                i++;
            }
            if(i-j > 1)
            Arrays.sort(res, j, i, Collections.reverseOrder());
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i];
        }
        return arr;
    }
}

