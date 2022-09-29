class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = 1_000_000_000;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (possible(position, mid, m))
                left = mid;
            else
                right = mid - 1;
        }

        return left;
    }

    private boolean possible(int[] position, int distance, int m) {
        int lastPosition = position[0];
        int ballsNeedToBePlaced = m - 1;
        for (int i = 1; i < position.length && ballsNeedToBePlaced > 0; i++) {
            if (position[i] - lastPosition >= distance) {
                lastPosition = position[i];
                ballsNeedToBePlaced--;
            }
        }
        return ballsNeedToBePlaced == 0;
    }
}