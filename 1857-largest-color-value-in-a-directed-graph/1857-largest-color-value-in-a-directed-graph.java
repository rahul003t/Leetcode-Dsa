class Solution {
    private int max = 1;

    // Maintain global max of color value.
    // Run DFS from each node. Backtrack a visited array.
    // For each node, maintain the map of color to max color value for paths from this node.
    // If running into a visited node during DFS, return -1.
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        if (n == 0) {
            return 0;
        }
        boolean[] visited = new boolean[n];
        List<List<Integer>> neighbors = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            neighbors.get(edge[0]).add(edge[1]);
        }

        List<Map<Character, Integer>> values = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            values.add(new HashMap<>());
        }
        
        for (int i = 0; i < n; i++) {
            boolean hasCycle = DFS(i, colors, neighbors, visited, values);
            if (hasCycle) {
                return -1;
            }
        }

        return max;
    }

    // return whether graph has cycle
    private boolean DFS(int current, 
        String colors,
        List<List<Integer>> neighbors, 
        boolean[] visited, 
        List<Map<Character, Integer>> values) {
        
        if (visited[current]) {
            return true;
        }

        if (values.get(current).size() > 0) { // current node has been DFS-ed
            return false;
        }

        visited[current] = true;

        values.get(current).put(colors.charAt(current), 1);

        for (int neighbor: neighbors.get(current)) {
            if (neighbor == current) {
                return true;
            }
            boolean hasCycle = DFS(
                neighbor, 
                colors, 
                neighbors,
                visited,
                values
            );
            if (hasCycle) {
                return true;
            }

            for (var entry: values.get(neighbor).entrySet()) {
                char color = entry.getKey();
                int neighborCount = entry.getValue();
                if (color == colors.charAt(current)) {
                    neighborCount += 1;
                }

                int currentCount = values.get(current).getOrDefault(color, 0);

                int maxCount = neighborCount > currentCount ? neighborCount : currentCount;

                values.get(current).put(color, maxCount);
                max = maxCount > max ? maxCount : max;
            }
        }

        visited[current] = false;
        return false;
    }
}