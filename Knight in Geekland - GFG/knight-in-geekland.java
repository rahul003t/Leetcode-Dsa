//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            s = br.readLine().trim().split(" ");

            int start_x = Integer.parseInt(s[0]);
            int start_y = Integer.parseInt(s[1]);
            int arr[][] = new int[n][m];
            for(int i = 0; i < n; i++){
                s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    arr[i][j] = Integer.parseInt(s[j]);
            }

            Solution soln = new Solution();
            ot.println(soln.knightInGeekland(arr, start_x, start_y));
            
        }

        ot.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int knightInGeekland(int[][] arr, int start_x, int start_y) {
        int m = arr.length;
        int n = arr[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start_x, start_y));
        
        boolean[][] vis = new boolean[m][n];
        vis[start_x][start_y] = true;
        
        List<Integer> coins = new ArrayList<>();
        
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, 2, -2, 1, -1};
        
        while (!q.isEmpty()) {
            int size = q.size();
            int coinsInThisStep = 0;
            while (size-- > 0) {
                Pair node = q.poll();
                
                int currX = node.first;
                int currY = node.second;
                
                coinsInThisStep += arr[currX][currY];
                
                for (int dir = 0; dir < 8; dir++) {
                    int newX = currX + dx[dir];
                    int newY = currY + dy[dir];
                    
                    if (newX >= 0 && newY >= 0 && newX < m && newY < n && !vis[newX][newY]) {
                        vis[newX][newY] = true;
                        q.add(new Pair(newX, newY));
                    }
                }
            }
            coins.add(coinsInThisStep);
        }
        
        int size = coins.size();
        int maxi = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (coins.get(i) + i < size) {
                coins.set(i, coins.get(i) + coins.get(coins.get(i) + i));
            }
            if (coins.get(i) >= maxi) {
                maxi = coins.get(i);
                ans = i;
            }
        }
        return ans;
    }
    
    static class Pair {
        int first;
        int second;
        
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}  
