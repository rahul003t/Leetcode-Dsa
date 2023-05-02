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
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [] sweetness = new int[n];
			str = br.readLine().trim().split(" ");
			int i = 0;
			for(String s: str) {
				sweetness[i++] = Integer.parseInt(s);
			}
			Solution obj = new Solution();
			System.out.println(obj.maxSweetness(sweetness, n, k));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    int maxSweetness(int [] sweetness, int N, int K) {
        int max=0,min= Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            if(sweetness[i]<min) min= sweetness[i];
            max +=sweetness[i];
        }
        int ans=0,mid=0;
        while(min<=max){
            mid=(min+max)/2;
            if(checkPossible(mid,sweetness,N,K+1)){
                ans=mid;
                min=mid+1;
            }
            else max=mid-1;
        }
        return ans;
    }
    
    boolean checkPossible(int mid,int[] sweetness, int N, int K){
        int curr=0;
        for(int i=0;i<N;i++){
            curr += sweetness[i];
            if(curr>=mid){
                curr=0;
                K--;
            }
        }
        if(K<=0) return true;
        return false;
    }
}