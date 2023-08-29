class Solution {
    public int bestClosingTime(String customers) {
        int maxScore = 0, score = 0, rightTime = -1;
        for (int i = 0; i < customers.length(); ++i) {
            score += (customers.charAt(i) == 'Y') ? 1 : -1;
            if (score > maxScore) {
                maxScore = score;
                rightTime = i;
            }
        }
        return rightTime + 1;
    }
}
