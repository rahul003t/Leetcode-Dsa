//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {

        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.makeBeautiful(arr);
            for (int e : res) out.print(e + " ");
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
   public static ArrayList<Integer> makeBeautiful(int[] arr) {
        // code here
         // Create a stack to store the integers
        Stack<Integer> stack = new Stack<>();
        
        // Iterate over the input array
        for(int num : arr) {
            // If the stack is empty, push the integer onto the stack
            if(stack.empty()) {
                stack.push(num);
            } else {
                // If the integer has a different sign than the top of the stack, pop the top element
                if((stack.peek() >= 0 && num < 0) || (stack.peek() < 0 && num >= 0)) {
                    stack.pop();
                } else {
                    // Otherwise, push the integer onto the stack
                    stack.push(num);
                }
            }
        }
        
        // Create a new ArrayList to store the result
        ArrayList<Integer> result = new ArrayList<>();
        
        // Pop the elements from the stack and add them to the result ArrayList
        while(!stack.empty()) {
            result.add(stack.peek());
            stack.pop();
        }
        
        // Reverse the order of the elements in the result ArrayList
        Collections.reverse(result);
        
        // Return the result ArrayList
        return result;
    }
}
