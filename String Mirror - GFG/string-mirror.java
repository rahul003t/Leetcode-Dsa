//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.stringMirror(str);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
   public static String stringMirror(String str) {
        // code here
     // Create a StringBuilder to store the prefix of the mirrored string
    StringBuilder prefix = new StringBuilder();
    // Append the first character of the input string to the prefix
    prefix.append(str.charAt(0));

    // Iterate through the remaining characters of the input string
    for (int i = 1; i < str.length(); i++) {
        char currentChar = str.charAt(i);
        char previousChar = str.charAt(i - 1);
        
        // If the current character is greater than the previous character, we have gone past the mirror point
        if (currentChar > previousChar) {
            break;
        }
        // If the current character is equal to the first character of the input string,
        // we have reached the end of the valid prefix for the mirrored string
        if (currentChar == str.charAt(0)) {
            break;
        }
        // Append the current character to the prefix
        prefix.append(currentChar);
    }
    
    // Create a StringBuilder to store the mirrored prefix
    StringBuilder mirroredPrefix = new StringBuilder(prefix.toString());
    // Reverse the prefix and append it to the mirrored prefix
    String reversedPrefix = new StringBuilder(mirroredPrefix).reverse().toString();
    mirroredPrefix.append(reversedPrefix);
    
    // Return the mirrored string
    return mirroredPrefix.toString();

    }
}
        
