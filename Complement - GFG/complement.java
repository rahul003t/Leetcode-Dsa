//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();

            Vector<Integer> ans = new Solve().findRange(str, n);
            if (ans.size() == 1) {
                System.out.println(ans.get(0));
            } else {
                System.out.println(ans.get(0) + " " + ans.get(1));
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solve {

    Vector<Integer> findRange(String str, int n) {
        // code here
        int l = -1;
        int r = -1;
        
        int max = 0;
        int count = 0;
        
        int maxL = -1;
        int maxR = -1;
        
        for(int i=0; i<n; i++){
            if(str.charAt(i) == '0'){
                count++;
            }
            else{
                count--;
                if(count < 0){ l = -1; count = 0; }
            }
            
            if(count == 1 && l == -1){ l = i; }
            
            if(count > max){ max = count; maxL = l+1; maxR = i+1; }
        }
        
        Vector<Integer> ans = new Vector<>();
        
        ans.add(maxL);
        
        if(maxL != -1){ ans.add(maxR); }
        
        return ans;
    }
}