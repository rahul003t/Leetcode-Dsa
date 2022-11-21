class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == '+') continue;
                    if (x == 0 || x == m - 1 || y == 0 || y == n - 1) return steps + 1;
                    q.offer(new int[]{x, y});
                    maze[x][y] = '+';
                }
            }
            steps++;
        }
        return -1;
    }
}