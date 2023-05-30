//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution{
    public boolean isWordExist(char[][] board, String word){
        // Code here
        int row = board.length;
        int col = board[0].length;
        int[][] visited = new int[row][col];
        int k=0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(find(board, word, i, j, row, col, k, visited))
                    return true;
            }
        }
        return false;
    }
    
    public boolean find(char[][] board, String word, int i, int j, int row, int col, int k, int[][] visited){
        if(k==word.length())
            return true;
            
        if(i<0 || i>=row || j<0 || j>=col || visited[i][j]==1 || board[i][j]!=word.charAt(k))
            return false;
            
        visited[i][j]=1; 
        boolean up = find(board, word, i-1, j, row, col, k+1, visited);
        boolean down = find(board, word, i+1, j, row, col, k+1, visited);
        boolean left = find(board, word, i, j-1, row, col, k+1, visited);
        boolean right = find(board, word, i, j+1, row, col, k+1, visited);
        visited[i][j]=0;
        
        return up || down || left || right;
                
    }
}