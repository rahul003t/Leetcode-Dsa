//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class GFG
{
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
            long ans[]=ob.smallerSum(n,a);
            for(long i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long[] smallerSum(int n,int arr[])
    {
        long ans[]=new long[n],pfx[]=new long[n];
        int temp[]=arr.clone();
        Arrays.sort(temp);
        HashMap<Integer,Integer> map=new HashMap<>();
        pfx[0]=temp[0];
        map.put(temp[0],0);
        for(int i=1;i<n;i++){
            pfx[i]+=pfx[i-1]+temp[i];
            if(!map.containsKey(temp[i])) map.put(temp[i],i);
        }
        for(int i=0;i<n;i++){
            int idx=map.get(arr[i]);
            if(idx>0) ans[i]=pfx[idx-1];
        }
        return ans;
    }
}