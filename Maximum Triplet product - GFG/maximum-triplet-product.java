//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java
class Solution {
    Long maxTripletProduct(Long arr[], int n)
    {
        long largest=Integer.MIN_VALUE,slargest=Integer.MIN_VALUE,tlargest=Integer.MIN_VALUE;
        long smallest=Integer.MAX_VALUE,ssmallest=Integer.MAX_VALUE;
        
        for(long el:arr)
        {
                if(el>largest)
                {
                    tlargest=slargest;
                    slargest=largest;
                    largest=el;
                }
                else if(el>slargest)
                {
                    tlargest=slargest;
                    slargest=el;
                }
                else if(el>tlargest)
                {
                    tlargest=el;
                }

            
            if(el<smallest)
            {
                ssmallest=smallest;
                smallest=el;
            }
            else if(el<ssmallest)
            {
                ssmallest=el;
            }
            
        }
        
            return Math.max(smallest*ssmallest*largest,largest*slargest*tlargest);
                
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    Long[] arr = new Long[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Long.parseLong(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    Long res = obj.maxTripletProduct(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


// } Driver Code Ends