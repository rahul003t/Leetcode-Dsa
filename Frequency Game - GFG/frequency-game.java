//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

// Position this line where user code will be pasted.

// Driver class with main function
class GFG {
    // Main function
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        // Iterating over testcases
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int arr[] = new int[n];

            String s[]=in.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            System.out.println(obj.LargButMinFreq(arr, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// Helper class to find largest number with minimum frequency
class Solution {
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int a[], int n) {
        // Your code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        int min=Integer.MAX_VALUE,ans=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()<min) {
                min=m.getValue();
                ans=m.getKey();
            }
            if(m.getValue()==min && m.getKey()>ans){
                ans=m.getKey();
            }
        }
        return ans;
    }
}