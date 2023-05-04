//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class GFG implements Runnable
{
    public static void main(String args[])throws IOException
    {
        new Thread(null, new GFG(), "whatever", 1<<26).start();
    }
    public void run()
    {
        try{
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t=Integer.parseInt(in.readLine());
            while(t-->0){
                int n=Integer.parseInt(in.readLine().trim());
                int a[][]=new int[n][3];
                for(int i=0;i<n;i++){
                    String s[]=in.readLine().trim().split(" ");
                    a[i][0]=Integer.parseInt(s[0]);
                    a[i][1]=Integer.parseInt(s[1]);
                    a[i][2]=Integer.parseInt(s[2]);
                }
                Solution ob=new Solution();
                out.println(ob.maxCoins(n,a));
            }
            out.close();
        }catch(Exception e){
            ;
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static class Range{
        int s;
        int e;
        int c;
        public Range(int s, int e, int c){
            this.s=s;
            this.e=e;
            this.c=c;
        }
    }
    static class RangeComparator implements Comparator<Range>{
        public int compare(Range o1, Range o2){
            //This logic also handles cases when starting points are equal
            //If they are equal it arranges in asceding according to end points
            if(o1.s!=o2.s){
                return o1.s-o2.s;
            }else{
                return o1.e-o2.e;
            }
        }
    }
    public static int maxCoins(int n,int ranges[][])
    {
        Range[] r=new Range[n];
        for(int i=0;i<n;i++){
            r[i]=new Range(ranges[i][0],ranges[i][1],ranges[i][2]);
        }
        Arrays.sort(r,new RangeComparator());
        
        int[][] dp=new int[n][3];
        //Since in function below, we are going to only valid states after 'take', we just need to keep
        //a track of remaining slots and not the last range's end, so dp[n][3];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return maxCoins(r,0,2,dp);
    }
    
    public static int maxCoins(Range[] ranges, int i, int rem,int[][] dp){
        if(i==ranges.length || rem==0){
            return 0;
        }
        if(dp[i][rem]!=-1){
            return dp[i][rem];
        }
        int notTake=maxCoins(ranges,i+1,rem,dp);
        int take=ranges[i].c;
        //If we are taking this interval, checking the next possible interval with binary search lowerbound
        int s=i+1;
        int e=ranges.length-1;
        int ind=ranges.length;
        while(s<=e){
            int mid=(s+e)/2;
            if(ranges[mid].s>=ranges[i].e){
                ind=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        take+=maxCoins(ranges,ind,rem-1,dp);
        return dp[i][rem]=Math.max(take,notTake);
    }
}