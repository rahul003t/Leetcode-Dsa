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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        
        int n = nums.length;
        int[] min1 = new int[n];
        int[] min2 = new int[n];
        
        for(int i=0;i<n;i++)
        {
            min1[i]=1;
            for(int j=0;j<i;j++)
            {
                if(nums[j] <nums[i]  &&  min1[j]+1 > min1[i])
                {
                    min1[i] = min1[j]+1;
                }
            }
        }
        
        for(int i=n-1;i>=0;i--)
        {
            min2[i]=1;
            for(int j=i+1;j<n;j++)
            {
                if(nums[j] <nums[i]  && min2[j]+1 > min2[i])
                {
                    min2[i] = min2[j]+1;
                }
            }
        }
        
        int  ans =0;
        for(int i=0;i<n;i++)
        {
            ans = Math.max(ans,min1[i]+min2[i]-1);
        }
        
        return ans;
    }
}