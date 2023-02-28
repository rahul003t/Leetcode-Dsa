//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long arr[]=ob.optimalArray(n,a);
            for(long i:arr){
                out.print(i+" ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {
    public long[] optimalArray(int n,int a[])
    {
        long[] res=new long[n];
        long[] pref=new long[n];
        long sum=a[0];
        pref[0]=sum;
        for(int i=1;i<n;i++){
            sum+=a[i];
            pref[i]=sum;
        }
        res[0]=0;
        for(int i=1;i<n;i++){
            if(i%2==0){
                int mid=i/2;
                long sum1=pref[i]-pref[mid]-pref[mid-1];
                res[i]=sum1;
            }
            else{
                int mid=i/2;
                long sum1=pref[i]-2*pref[mid];
                res[i]=sum1;
            }
        }
        return res;
    }
}
        
