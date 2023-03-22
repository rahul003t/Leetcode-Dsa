class Solution {
    class Edge {
        private int to;
        private int val;
        public Edge(int to, int val) { this.to = to; this.val = val; }
    }

    public int minScore(int n, int[][] roads) {
        Map<Integer, List<Edge>> map = new HashMap<>();
        for(int[] road : roads) {
            map.putIfAbsent(road[0], new ArrayList<>());
            map.get(road[0]).add(new Edge(road[1], road[2]));
            map.putIfAbsent(road[1], new ArrayList<>());
            map.get(road[1]).add(new Edge(road[0], road[2]));
        }
        boolean[] visited = new boolean[n + 1];

        return helper(n, map, visited);
    }

    private int helper(int n, Map<Integer, List<Edge>> map, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        Queue<Integer> que = new ArrayDeque<>();
        que.add(1);
        while(!que.isEmpty()) {
            Integer node = que.poll();
            visited[node] = true;
            if(!map.containsKey(node)) continue;
            for(Edge e : map.get(node)) {
                if(visited[e.to]) continue;
                min = Math.min(min, e.val);
                que.add(e.to);                
            }
        }
        return min;
    }
}