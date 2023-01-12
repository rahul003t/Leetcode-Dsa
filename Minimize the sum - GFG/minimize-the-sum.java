//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    long minimizeSum(int N, int arr[]) {
        // code here
        // as question mentioned minimize the sum ,I am using PriorityQueue 
        // as it use meanHeap in very efficient way.
        long ans =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //itterate the array and all elemnets in the queue
        for(int i: arr)
        {
            pq.add(i);
        }
        // while there is more than a single element in the list continue the list
        while(pq.size() >= 2)
        {
            //add the curr two element
            int curr = pq.remove()+ pq.remove();
            //adding the element to the answer
            ans += curr;
            pq.add(curr);
        }
        
        return ans;
    }
}

//{ Driver Code Starts.

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0; i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            long ans = obj.minimizeSum(n, A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends