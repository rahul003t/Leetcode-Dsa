class Solution {
    public int[] kWeakestRows(int[][] matrix, int k) {
        // Using a min heap to store pairs of the sum of soldiers and their respective row indices
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        // Calculate the sum of soldiers for each row and store in the min heap
        for (int row = 0; row < matrix.length; row++) {
            int soldierCount = findSoldierCount(matrix[row]);
            minHeap.offer(new int[]{soldierCount, row});
        }

        // Extract the k weakest row indices
        int[] weakestRows = new int[k];
        for (int i = 0; i < k; i++) {
            weakestRows[i] = minHeap.poll()[1];
        }

        return weakestRows;
    }

    private int findSoldierCount(int[] row) {
        int left = 0, right = row.length - 1;

        // Perform binary search to find the count of soldiers
        while (left <= right) {
            int mid = (left + right) / 2;
            if (row[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}