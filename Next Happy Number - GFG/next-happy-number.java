//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{


        // code here
        
        
         static int nextHappy(int N) {

        int nextHappyNumber = N + 1;

        while (true) {
            if (isHappy(nextHappyNumber)) {
                return nextHappyNumber;

            }
            nextHappyNumber++;
        }


    }

    private static boolean isHappy(int nextHappyNumber) {
        HashMap<Integer, Integer> map = new HashMap<>();


        while (!map.containsKey(nextHappyNumber)) {
            map.put(nextHappyNumber, 1);

            int sum = 0;
            while (nextHappyNumber > 0) {
                int a = nextHappyNumber % 10;

                sum += a * a;
                nextHappyNumber = nextHappyNumber / 10;
            }

            if (sum == 1) {
                return true;
            }
            nextHappyNumber = sum;

        }
        return false;
        
    }
}