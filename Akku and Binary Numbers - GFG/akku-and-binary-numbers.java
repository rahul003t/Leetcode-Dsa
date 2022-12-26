//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        Solution ob = new Solution();
        ob.precompute();
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            long L = Long.parseLong(input_line[0]);
            long R = Long.parseLong(input_line[1]);
            long ans = ob.solve(L, R);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution{
    
    void precompute(){
        // Code Here
    }
    long solve(long L, long R){
       
      return fun(R,63,0,0) - fun(L-1,63,0,0);
        
    }
    
    long fun(long n, long idx, int count_setBit,int set)
    {
        if(count_setBit ==3 )
        {
            return 1;
        }
        if(idx < 0)
        {
            return 0;
        }
        long ans =0;
        if(isSet(n,idx))
        {
            ans += fun(n,idx-1,count_setBit+1,set&1);
            ans += fun(n,idx-1,count_setBit,1);
        }
        else
        {
            if(set == 1)
            {
                ans += fun(n,idx-1,count_setBit+1,set);
                ans += fun(n,idx-1,count_setBit,set);
            }
            else
            {
                ans += fun(n,idx-1,count_setBit,set);
            }
        }
        
        return ans;
    }
    
    boolean isSet(long n,long idx)
    {
        long mask = (1l << idx);
        return ( n & mask ) != 0  ;
    }
    
}