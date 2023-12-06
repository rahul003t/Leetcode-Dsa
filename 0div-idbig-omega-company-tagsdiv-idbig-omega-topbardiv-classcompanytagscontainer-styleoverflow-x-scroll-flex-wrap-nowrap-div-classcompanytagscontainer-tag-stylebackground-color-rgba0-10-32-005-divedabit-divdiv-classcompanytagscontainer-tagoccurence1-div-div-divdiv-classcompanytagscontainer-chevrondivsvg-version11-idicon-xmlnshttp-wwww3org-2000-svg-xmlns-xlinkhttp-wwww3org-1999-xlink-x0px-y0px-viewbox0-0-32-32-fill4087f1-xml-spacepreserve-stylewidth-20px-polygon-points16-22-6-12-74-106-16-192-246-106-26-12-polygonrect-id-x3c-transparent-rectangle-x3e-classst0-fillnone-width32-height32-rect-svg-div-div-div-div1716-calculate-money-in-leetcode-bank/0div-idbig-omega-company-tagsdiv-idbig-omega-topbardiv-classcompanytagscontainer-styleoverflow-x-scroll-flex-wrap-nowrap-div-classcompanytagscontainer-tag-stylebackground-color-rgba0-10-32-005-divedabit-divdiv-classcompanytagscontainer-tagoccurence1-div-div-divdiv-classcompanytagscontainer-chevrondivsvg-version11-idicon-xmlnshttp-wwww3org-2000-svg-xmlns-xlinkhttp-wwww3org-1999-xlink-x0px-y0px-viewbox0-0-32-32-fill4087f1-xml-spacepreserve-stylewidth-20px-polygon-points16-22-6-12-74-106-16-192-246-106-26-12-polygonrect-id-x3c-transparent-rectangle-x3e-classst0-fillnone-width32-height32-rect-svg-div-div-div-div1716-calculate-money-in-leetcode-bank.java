class Solution {
    public int totalMoney(int n) {
        int total = 0;

        for (int day = 0; day < n; day++) {
            total += (day / 7 + 1) + (day % 7);
        }

        return total;        
    }
}