//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {

        // code here

        int sum=0;

        

        for(int i:arr){

            sum+=i;

        }

        

        int low=0,high=sum,ans=Integer.MAX_VALUE;

        

        while(low<=high){

            int mid=low+(high-low)/2;

            

            if(isPossible(arr,mid,K)){

               ans=Math.min(ans,mid);

                high=mid-1;

            }else{

                low=mid+1;

            }

        }

        return ans;

    }

    private static boolean isPossible(int[] arr,int mid,int tar){

        int sum=0,count=1;

        

        for(int i:arr){

            if(sum+i<=mid){

                sum+=i;

            }else{

                sum=i;

                if(i>mid) return false;

                count++;

            }

        }

        return count<=tar;

    }


};