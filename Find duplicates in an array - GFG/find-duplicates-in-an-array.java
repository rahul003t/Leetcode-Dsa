//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
       ArrayList<Integer> res1 = new ArrayList<Integer>();
       boolean ifPresent = false;
        for(int i=0;i<n;i++){
         if(arr[arr[i] % n] >= n){
                if (arr[arr[i] % n] < 2 * n)
                {
                    res1.add(arr[i] % n);
                    ifPresent = true;
                }
            }
            arr[arr[i] % n] += n;
        }

        if (!ifPresent) res1.add(-1);
       Collections.sort(res1);

        return res1;
    }
}