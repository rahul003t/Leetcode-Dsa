//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine().trim());
            int a[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                a[i][0]=Integer.parseInt(s[0]);
                a[i][1]=Integer.parseInt(s[1]);
            }
            int k=Integer.parseInt(in.readLine().trim());
            Solution ob=new Solution();
            out.println(ob.powerfullInteger(n,a,k));
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution{
    public static int powerfullInteger(int n,int interval[][],int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0; i<n; i++){
            map.put(interval[i][0], map.getOrDefault(interval[i][0],0)+1);
            map.put(interval[i][1]+1, map.getOrDefault(interval[i][1]+1,0)-1);
            max = Math.max(max, interval[i][1]);
        }
        int [] freq = new int[max+2];
       
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            freq[entry.getKey()] = entry.getValue();
        }
        
        
        for(int i=1; i<freq.length; i++) freq[i] += freq[i-1];
        int pow = -1;
        for(int i=0; i<freq.length; i++){
            if(freq[i] >= k){
                pow = Math.max(pow, i);
            } 
        }
        return pow;
    }
}

