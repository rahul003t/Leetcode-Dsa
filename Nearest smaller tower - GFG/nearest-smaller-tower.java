//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
	int [] nearestSmallestTower(int [] arr){
		//Write your code here
	    int n = arr.length;
        int[] left = new int[n];    // Array to store the index of the nearest smaller tower on the left
        int[] right = new int[n];   // Array to store the index of the nearest smaller tower on the right
        Arrays.fill(left, -1);      // Initialize all elements of the 'left' array to -1
        Arrays.fill(right, -1);     // Initialize all elements of the 'right' array to -1

        Stack<Integer> stack = new Stack<>();  // Create a stack to store the indices of towers
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                // Pop elements from the stack until the top element is smaller than the current tower
                stack.pop();    
            }
            if (!stack.isEmpty()) {
                // The index of the nearest smaller tower on the left is the top element of the stack
                left[i] = stack.peek(); 
            }
            stack.push(i);  // Push the index of the current tower onto the stack
        }

        stack.clear();  // Clear the stack for re-use
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                // Pop elements from the stack until the top element is smaller than the current tower
                stack.pop();    
            }
            if (!stack.isEmpty()) {
                // The index of the nearest smaller tower on the right is the top element of the stack
                right[i] = stack.peek();    
            }
            stack.push(i);  // Push the index of the current tower onto the stack
        }

        int[] result = new int[n];  // Array to store the final result
        for (int i = 0; i < n; i++) {
             // Distance between the current tower and the nearest smaller tower on the left
            int leftDist = left[i] == -1 ? Integer.MAX_VALUE : i - left[i]; 
            // Distance between the current tower and the nearest smaller tower on the right
            int rightDist = right[i] == -1 ? Integer.MAX_VALUE : right[i] - i;    
            /* If the nearest smaller tower on the left is closer or has equal distance but is 
            smaller or equal in height, set it as the result*/
            if (leftDist < rightDist || (leftDist == rightDist && left[i] != -1 && arr[left[i]] <= arr[right[i]])) {
                result[i] = left[i];    
            } else 
            /* If the nearest smaller tower on the right is closer or has equal distance but is 
            smaller in height, set it as the result*/
            
            if (leftDist > rightDist || (leftDist == rightDist && right[i] != -1 && arr[right[i]] < arr[left[i]])) {
                result[i] = right[i];   
            } else {
                result[i] = -1; // If there is no smaller tower on both sides, set the result as -1
            }
        }
        return result;  // Return the final result array
	}
}