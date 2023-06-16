class Solution {
    long mod = (long)1e9 + 7;
    long[][] table;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        table = new long[n][n];
        for (int i = 0; i < n; ++i) {
            table[i][0] = table[i][i] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % mod;
            }
        }
        List<Integer> arrList = new ArrayList();
        for(int i: nums) arrList.add(i);
        return (int)((helper(arrList) - 1) % mod);
        
    }
    
    public long helper(List<Integer> arr){
        int n = arr.size();
        if(n<3) return 1;
        List<Integer> leftNodes = new ArrayList<>();
        List<Integer> rightNodes = new ArrayList<>();
        for (int i  = 1; i<n;i++) {
            int element = arr.get(i);
            if (element < arr.get(0)) {
                leftNodes.add(element);
            } else {
                rightNodes.add(element);
            }
        }
        long leftWays = helper(leftNodes)%mod;
        long rightWays = helper(rightNodes) % mod;
        return (((leftWays * rightWays) % mod) * table[n - 1][leftNodes.size()]) % mod;
    }
}