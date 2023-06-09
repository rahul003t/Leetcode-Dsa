//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends

class Solution {
    public List<String> find_permutation(String S) {
        // Code here
         char[] chars = S.toCharArray();
        Set<String> uniquePermutations = new HashSet<>();
        generatePermutations(chars, 0, uniquePermutations);
        List<String> sortedPermutations = new ArrayList<>(uniquePermutations);
        sortedPermutations.sort(null);
        return sortedPermutations;
    }

    private static void generatePermutations(char[] chars, int start, Set<String> uniquePermutations) {
        if (start == chars.length) {
            uniquePermutations.add(new String(chars));
            return;
        }

        for (int i = start; i < chars.length; i++) {
            swap(chars, start, i);
            generatePermutations(chars, start + 1, uniquePermutations);
            swap(chars, start, i); // backtrack
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    
    }
}