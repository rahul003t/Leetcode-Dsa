//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Gfg {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            char c[][]=new char[n][m];
            for(int i=0;i<n;i++){
                s=in.readLine().trim().split(" ");
                for(int j=0;j<m;j++){
                    c[i][j]=s[j].charAt(0);
                }
            }
            Solution ob=new Solution();
            int ans[][]=ob.chefAndWells(n, m, c);

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    out.print(ans[i][j]+" ");
                }
                out.println();
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    class Triplet{
        int dist , row , col;
        Triplet(int dist , int row , int col){
            this.dist = dist;
            this.row = row;
            this.col = col;
        }
    }
    public int[][] chefAndWells(int n,int m,char c[][])
    { 
        int ans[][] = new int [n][m];
        for(var arr : ans){
            Arrays.fill(arr , -1);
        }
        boolean vis[][] = new boolean [n][m];
        Queue<Triplet> q = new LinkedList<>();
        int dx [] = new int[]{0 , 1 , 0 , -1};
        int dy [] = new int[]{-1 , 0 , 1 , 0};
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if(c[i][j] == 'W'){
                    ans[i][j] = 0;
                    q.add(new Triplet(0 , i , j));
                    vis[i][j] = true;
                }
                else if(c[i][j] == 'N' || c[i][j] == '.'){
                    ans[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()){
            Triplet node = q.poll();
            int dist = node.dist;
            int x = node.row;
            int y = node.col;
            for(int i = 0 ; i < 4 ; i ++){
                int X = x + dx[i];
                int Y = y + dy[i];
                if(X >= 0 && X < n && Y >= 0 && Y < m && vis[X][Y] == false && c[X][Y] == 'H'){
                    q.add(new Triplet(dist + 2 , X , Y));
                    ans[X][Y] = dist + 2;
                    vis[X][Y] = true;
                } else if(X >= 0 && X < n && Y >= 0 && Y < m && vis[X][Y] == false && c[X][Y] == '.'){
                    q.add(new Triplet(dist + 2 , X , Y));
                    vis[X][Y] = true;
                }
            }
        }
        return ans;
    }
}

