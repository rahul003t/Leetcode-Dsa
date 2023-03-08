//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N, K, W;
			String [] str = br.readLine().trim().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);
			W = Integer.parseInt(str[2]);
			str = br.readLine().trim().split(" ");
			int [] arr = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution obj = new Solution();
			System.out.println(obj.maximizeMinHeight(N, K, W,arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	long maximizeMinHeight(int n, int k, int w,int [] a){
        int high = Integer.MAX_VALUE / 4;
        int low = 0;
        long ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(a , w , mid , k)){
                low = mid + 1;
                ans = (long)Math.max((long)mid , ans);
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean isPossible(int[] arr , int l , int maxHeight , int days){
        int[] water = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            if(i > 0){
                water[i] = water[i-1];    
            }
            int curHei = water[i] + arr[i];
            if(i >= l){
                curHei -= (water[i-l]);
            }
            if(curHei < maxHeight){
                water[i] += (maxHeight - curHei);
                days -= (maxHeight - curHei);
            }
            if(days < 0) return false;
        }
        return true;
    }
}