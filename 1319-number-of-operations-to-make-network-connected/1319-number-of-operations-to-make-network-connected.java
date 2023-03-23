class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        //create undirected network
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int[] i:connections){
            ArrayList<Integer> a = map.getOrDefault(i[0], new ArrayList<>());
            a.add(i[1]);
            map.put(i[0], a);
            a = map.getOrDefault(i[1], new ArrayList<>());
            a.add(i[0]);
            map.put(i[1], a);
        }
        // count the number of components c
        int c=0;
        HashSet<Integer> vis = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!vis.contains(i)){
                dfs(i, map, vis);
                c++;
            }
        }
        return c-1;
    }
    public void dfs(int curr, HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> visited){
        if(visited.contains(curr)) return;
        visited.add(curr);
        for(int nei: map.getOrDefault(curr, new ArrayList<>())){
            dfs(nei, map, visited);
        }
    }
}