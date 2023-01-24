//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().convert(arr, n);
            for (int i = 0; i < n; i++) {
                out.print(arr[i] + " ");
            }
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void convert(int[] arr, int n) {
        //Code here
        int temp[]=new int[n],eg[]=new int[n],x=0;
        
        //copiying array
        for(int i=0;i<n;i++)temp[i]=arr[i];
        
        //sorting temp
        Arrays.sort(temp);
        
        // searching ezch element
        for(int i=0;i<n;i++){
            x=binary_Search(temp,0,n-1,arr[i]);
            eg[i]=x;
        }
        
        
        for(int i=0;i<n;i++)arr[i]=eg[i];
        
        
    }
    
    //binary search function
      int binary_Search(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
 
           
            if (arr[mid] == x)
                return mid;
 
           
            if (arr[mid] > x)
                return binary_Search(arr, l, mid - 1, x);
 
           
            return binary_Search(arr, mid + 1, r, x);
        }
 
      
        return -1;
    }
}