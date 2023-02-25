//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {

    static int checkCompressed(String S, String T) {

        

        // code here

    int i = 0, j = 0;

    while (j < T.length()) {

        if (Character.isDigit(T.charAt(j))) {

            int count = 0;

            while (j < T.length() && Character.isDigit(T.charAt(j))) {

                count = count * 10 + (T.charAt(j) - '0');

                j++;

            }

            i += count;

        } else {

            if (i >= S.length() || T.charAt(j) != S.charAt(i)) {

                return 0;

            }

            i++;

            j++;

        }

    }

    return i == S.length()? 1:0;

}

 
}