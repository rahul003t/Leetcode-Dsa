class Solution {
    static int[] visited;

    public long countPairs(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = fillInTheGraph(edges);
        List<Integer> list = new ArrayList<>();
        visited = new int[n];
         long numberOfPairs = 0;
        long sizeOfComponent = 0;
        long remainingNodes = n;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                int componentSize = dfs(graph, i, n);
                numberOfPairs += componentSize * (remainingNodes - componentSize);
                remainingNodes -= componentSize;
            }
        }
       
        return numberOfPairs;
    }

    private static int dfs(HashMap<Integer, List<Integer>> graph, int source, int n) {
        visited[source] = 1;
        int ans = 1;
        if (!graph.containsKey(source)) return ans;
        for (int node : graph.get(source)) {
            if (visited[node] == 0) {
                ans += dfs(graph, node, n);
            }
        }
        return ans;
    }

    private static HashMap<Integer, List<Integer>> fillInTheGraph(int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], a -> new ArrayList<>()).add(edge[0]);
        }
        return graph;
    }
}