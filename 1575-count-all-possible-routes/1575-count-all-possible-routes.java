class Solution {
  int [][]dp;
  int n;
  int finish;
  public int possibleRoutes(int [] location ,int currCity,int remainingFuel){
        if(remainingFuel<0){
          return 0;
        }
        if(dp[currCity][remainingFuel] !=-1){
          return dp[currCity][remainingFuel];
        }
        int ans = currCity==finish ? 1: 0;
        for(int nextCity=0;nextCity <n;nextCity++){
          if(nextCity != currCity){
            ans=(ans + possibleRoutes(location , nextCity,remainingFuel - Math.abs(location[currCity] - location[nextCity]))) % 1000000007;
          }
        }
        dp[currCity][remainingFuel] = ans;
        return ans;
    }

    public int countRoutes(int [] locations , int start ,int finish,int fuel){
        n=locations.length;
        dp = new int[n][fuel + 1];
        this.finish =finish;

        for(int i=0;i<n;i++){
          Arrays.fill(dp[i],-1);
        }
        return possibleRoutes(locations,start,fuel);
    }
}