//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends



class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
         int leftmin[]=new int[n];
        leftmin[0]=arr[0];
        
        int rightmax[]=new int[n];
        rightmax[n-1]=arr[n-1];
        
        int mn=leftmin[0];
        for(int i=1;i<n;i++){
            mn=Math.min(mn,arr[i]);
            leftmin[i]=mn;
        }
        
        int mx=rightmax[n-1];
        for(int i=n-2;i>=0;i--){
            mx=Math.max(mx,arr[i]);
            rightmax[i]=mx;
        }
         int k=0,j=0,ans=0;
        while(k<n && j<n){
            if(leftmin[k]<=rightmax[j]){
                ans=Math.max(ans,j-k);
                j++;
            }
            else{k++;}
        }
        return ans;
    }
}