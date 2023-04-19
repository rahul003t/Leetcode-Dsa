//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            String S = read.readLine().trim();
            Solution ob = new Solution();
            boolean ans = ob.wifiRange(N, S, X); 
            if(ans)
            System.out.println(1);
            else
            System.out.println(0);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
  boolean wifiRange(int N, String S, int X) 
    {
        // code here
        boolean wifiAvailable = false;

        if (X == 0 && S.contains("0"))
            return false;

        for (int i = 0; i < N; i++) {

            if (S.charAt(i) == '1') {
                wifiAvailable = true;
                continue;
            }

            // Check for X Left Room
            // If Found skip Right Room
            if (i - X >= 0) {
                String leftSub = S.substring(i - X, i);
                if (leftSub.contains("1")) {
                    wifiAvailable = true;
                    continue;
                }
            }
            else {
                String leftSub = S.substring(0, i);
                if (leftSub.contains("1")) {
                    wifiAvailable = true;
                    continue;
                }
            }
            // Right Nodes
            if (i + X < N) {
                String rightSub = S.substring(i + 1, i + X + 1);
                if (rightSub.contains("1")) {
                    wifiAvailable = true;
                    continue;
                } else {
                    wifiAvailable = false;
                    break;
                }
            } else {
                String rightSub = S.substring(i + 1, N);
                if (rightSub.contains("1")) {
                    wifiAvailable = true;
                    continue;
                } else {
                    wifiAvailable = false;
                    break;

                }
            }
        }

        return wifiAvailable;
    }


} 