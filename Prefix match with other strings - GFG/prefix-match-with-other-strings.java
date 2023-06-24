//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.next();
            }
            
            int k = Integer.parseInt(sc.next());
            
            String str = sc.next();
            
            Solution obj = new Solution();
            int ans = obj.klengthpref(arr,n,k,str);
            System.out.println(ans);
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int klengthpref(String[] arr, int n, int k, String str)
    {
        // code here
           if(k>str.length()){
             return 0;
             }
         int count=0;
        String str1="";
        for(int i=0;i<k;i++){
             str1+=str.charAt(i);
        }
        for(int  i=0;i<arr.length;i++){
            if(arr[i].startsWith(str1)){
                 count++;
                
            }}
        
            return count;
    }
}