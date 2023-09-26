//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n=arr.length;
        if(n<4) return list;
        
        Arrays.sort(arr);
        for(int i=0;i<n-3;i++){
            if(arr[i]>0&&arr[i]>k)break;//droplet not found
            if(i>0&&arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1&&arr[j]==arr[j-1]) continue;
                int l=j+1;
                int r=n-1;
                while(l<r){
                    int ll=l;
                    int rr=r;
                    int sum=arr[i]+arr[j]+arr[l]+arr[r];
                    if(sum==k) {
                        list.add(new ArrayList<>(
                           List.of(arr[i],arr[j],arr[l],arr[r])));
                        //remove duplicate
                        while(l<r&&arr[l]==arr[ll])l++;
                        while(l<r&&arr[r]==arr[rr])r--;
                    }
                    else if(sum>k) r--;
                         else l++;
                }
            }
        }
        return list;
    }

}