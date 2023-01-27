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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution

{

    public int CountWays(String str)

    {

        // code here

        

        int n=str.length();

        int mod=1000000007;

        int count[]=new int[n+1];

        

        count[0]=1;

        count[1]=1;

        

        if(str.charAt(0)=='0')

        return 0;

        for(int i=2;i<=n;i++){

            count[i]=0;

            if(str.charAt(i-1)>'0')

                count[i]=count[i-1]%mod;

            

            if(str.charAt(i-2)=='1'||(str.charAt(i-2)=='2'&& str.charAt(i-1)<'7'))

                count[i]+=count[i-2]%mod;

        }

        

        return count[n]%mod;

    }

}