//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
         int dx[]={-1,-1,-1,0,0,1,1,1};
        int dy[]={-1,0,1,-1,1,-1,0,1};
        int n=grid.length;
        int m=grid[0].length;
        ArrayList<int []> A=new ArrayList<>();
        int sz=word.length();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(word.charAt(0)==grid[i][j])
                {
                    for(int k=0;k<8;k++)
                    {
                        int p=1;
                        int row=i+dx[k];
                        int col=j+dy[k];
                        while(row<n && row>=0 && col<m && col>=0 && p<sz && word.charAt(p)==grid[row][col] )
                        {
                            p++;
                            row+=dx[k];
                            col+=dy[k];
                        }
                        if(p==sz)
                        {
                            int []temp={i,j};
                            A.add(temp);
                            break;
                        }
                    }
                }
            }
        }
        int ans[][]=new int[A.size()][2];
        for(int i=0;i<A.size();i++)
            ans[i]=A.get(i);
        return ans;
    }
}