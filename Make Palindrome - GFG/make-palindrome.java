//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            boolean res = obj.makePalindrome(n, arr);
            
            String _result_val = (res) ? "YES" : "NO";
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean makePalindrome(int n, String[] arr) {
        // code here
       HashMap<String, Integer> map = new HashMap<>();
       boolean selfPalindrome = false;
		for (int i = 0; i < n; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else
				map.put(arr[i], 1);
		}
        int count =0;
        boolean flag = true;
		for (int i = 0; i < n; i++) {
			// Check if reverse of arr[i]
			String rev = String.valueOf(new StringBuilder(arr[i]).reverse());
			if(arr[i].equals(rev) && map.get(rev)>1 && flag){
			    if(map.get(rev)%2!=0 && count==map.get(rev)-2){
			        flag = false;
			    }
			    count++;
			}
			else if (arr[i].equals(rev) && !selfPalindrome) {
                selfPalindrome = true;
			}
			else if (map.containsKey(rev) && !arr[i].equals(rev)) {
				// Check if the values matches too
				if (map.get(rev) != map.get(arr[i])) {
					return false;
				}
			} 
			else
				return false;
		}

		return true;
        
    }
}
        
