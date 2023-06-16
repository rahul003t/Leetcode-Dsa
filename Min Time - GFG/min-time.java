//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG implements Runnable{
    
	public static void main (String[] args) throws Exception{
        new Thread(null, new GFG(), "whatever", 1<<26).start();
    }
    public void run()
    {
        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
                
            int t=Integer.parseInt(in.readLine());
            while(t-- > 0){
                int n=Integer.parseInt(in.readLine().trim());
                int A[]=new int[n],B[]=new int[n];
                String s[]=in.readLine().trim().split(" ");
                for(int i=0;i<n;i++){
                    A[i]=Integer.parseInt(s[i]);
                }
                s=in.readLine().trim().split(" ");
                for(int i=0;i<n;i++){
                    B[i]=Integer.parseInt(s[i]);
                }
                Solution ob=new Solution();
                long ans=ob.minTime(n,A,B);
                out.println(ans);
            }
            out.close();
        }catch(IOException e){
            ;
        }
    }
}
// } Driver Code Ends

class Solution {
    static long dp[][];
    public static long minTime(int n, int[] locations, int[] types) {
        // code here
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            mx=Math.max(mx,types[i]);
        }
        int tmp[][]=new int[mx+1][2];
        for(int i=0;i<mx+1;i++){
            tmp[i][0]=Integer.MAX_VALUE;
            tmp[i][1]=Integer.MIN_VALUE;
        }
        for(int i=0;i<n;i++){
            int in=types[i];
            tmp[in][0]=Math.min(tmp[in][0],locations[i]);
            tmp[in][1]=Math.max(tmp[in][1],locations[i]);
        }
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for(int i=0;i<mx+1;i++){
            if(tmp[i][0]!=Integer.MAX_VALUE){
                ArrayList<Integer> A=new ArrayList<>();
                A.add(tmp[i][0]);
                A.add(tmp[i][1]);
                arr.add(A);
            }
        }
        dp=new long[arr.size()+1][3];
        for(int i=0;i<arr.size()+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(0,arr,2);
    }
    public static long fun(int i,ArrayList<ArrayList<Integer>> arr,int pos)
    {
        if(i==arr.size()){
            return dp[i][pos]=Math.abs(arr.get(i-1).get(pos));
        }
        if(dp[i][pos]!=-1){
            return dp[i][pos];
        }
        int x=0;
        if(pos==0){
            x=arr.get(i-1).get(0);
        }else if(pos==1){
            x=arr.get(i-1).get(1);
        }
        if(arr.get(i).get(1)<=x){
            return dp[i][pos]=x-arr.get(i).get(0)+fun(i+1,arr,0);
        }else if(arr.get(i).get(0)>=x){
            return dp[i][pos]=(arr.get(i).get(1)-x)+fun(i+1,arr,1);
        }else{
            int mn=arr.get(i).get(0),mx=arr.get(i).get(1);
            return dp[i][pos]=Math.min(2*(x-mn)+(mx-x)+fun(i+1,arr,1),2*(mx-x)+(x-mn)+fun(i+1,arr,0));
        }
    }
}