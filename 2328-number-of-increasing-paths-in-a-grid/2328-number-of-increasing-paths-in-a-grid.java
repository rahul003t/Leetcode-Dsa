class Solution {
    private int mod=1000000007;
    public int countPaths(int[][] grid) {
        int ans=0;
        int r=grid.length;
        int c=grid[0].length;
        int dp[][]=new int[r][c];
        for(int i[]:dp) Arrays.fill(i,-1);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans=(ans%mod+solve(i,j,grid,-1,dp)%mod)%mod;
            }
        }
        return ans;
    }
    private int solve(int i,int j,int grid[][],int prev,int dp[][]){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || prev>=grid[i][j]) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=1;
        ans+=(solve(i,j+1,grid,grid[i][j],dp)%mod);
        ans+=(solve(i,j-1,grid,grid[i][j],dp)%mod);
        ans+=(solve(i+1,j,grid,grid[i][j],dp)%mod);
        ans+=(solve(i-1,j,grid,grid[i][j],dp)%mod);
        return dp[i][j]=ans%mod;
    }
}