class Solution {
    int visited[];
    public boolean isBipartite(int[][] graph) {
        visited = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(bfs(i, graph) == false)
                return false;
        }
        return true;
    }
    public boolean bfs(int node, int[][] graph){
        if(visited[node] != 0)
            return true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int color = 1;
        visited[node] = color;
        while(!q.isEmpty()){
            int temp = q.poll();
            //color for adjacent node
            color = visited[temp] == 1 ? 2 : 1;
            for(int neighbor : graph[temp]){
                if(visited[neighbor] == visited[temp])//adjacent node can't share same color
                    return false;
                else if(visited[neighbor] == 0){
                    visited[neighbor] = color;
                    q.add(neighbor);
                }
            }
        }
        return true;
    }
}