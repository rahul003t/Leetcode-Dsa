class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // Using BFS
        int n = graph.length;
        int[] indegree = new int[n];
        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int itt : graph[i]) {
                g.get(itt).add(i); // reverse the direction of node
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int it : g.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }
        ans.sort(null);
        return ans;
    }
}