class Solution {
    public int ways(String[] pizza, int k) {
        int[][] apples = new int[pizza.length][pizza[0].length()];
        Integer[][][] memo = new Integer[apples.length][apples[0].length][10];
        for (int i = pizza.length - 1; i >= 0; i--)
            for (int j = pizza[0].length() - 1; j >= 0; j--)
                apples[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0)
                        + (i < apples.length - 1 ? apples[i + 1][j] : 0)
                        + (j < apples[0].length - 1 ? apples[i][j + 1] : 0)
                        - (i < apples.length - 1 && j < apples[0].length - 1 ? apples[i + 1][j + 1] : 0);
        return waysHelper(memo, apples, k, 0, 0);
    }

    private int waysHelper(Integer[][][] memo, int[][] apples, int k, int r, int c) {
        if (k == 1) return apples[r][c] > 0 ? 1 : 0;
        else if (memo[r][c][k - 1] != null) return memo[r][c][k - 1];
        long s = 0;
        for (int i = r + 1; i < apples.length; i++)
            if (apples[r][c] - apples[i][c] > 0 && apples[i][c] >= k - 1) 
                s += waysHelper(memo, apples, k - 1, i, c);
        for (int j = c + 1; j < apples[0].length; j++)
            if (apples[r][c] - apples[r][j] > 0 && apples[r][j] >= k - 1) 
                s += waysHelper(memo, apples, k - 1, r, j);
        memo[r][c][k - 1] = Math.toIntExact(s % 1_000_000_007);
        return memo[r][c][k - 1];
    }
}