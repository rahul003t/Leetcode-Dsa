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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.leastPrimeFactor(n);
            for(int i = 1; i <=n; i++)
            {
                out.print(ans[i] + " ");
            }
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] leastPrimeFactor(int n)
    {
        // code here
        int ans[] = new int[n+1];
        ans[1] = 1;
        for(int i=2;i<=n;i++){
            if(ans[i] == 0){
                ans[i] = i;
                for(int j=i+i;j<=n;j+=i){
                    if(ans[j] == 0)
                    ans[j] = i;
                }
            }
        }
        return ans;
    }
}