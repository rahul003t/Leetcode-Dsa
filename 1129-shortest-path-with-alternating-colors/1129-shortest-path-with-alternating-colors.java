class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer,Set<Pair<Integer,Integer>>> graph = new HashMap<>();// Here use set instead of array list is to prevent duplicate edges in same label
        Queue<Pair<Integer,Integer>> queue  = new LinkedList<>();
        Set<Pair<Integer,Integer>> visited = new HashSet<>();
        int[] res = new int[n];
        Arrays.fill(res,-1);
        res[0] = 0;

        for(int i=0;i<n;i++)
        {
            graph.put(i,new HashSet<>());
        }

        for(int[] redEdge:redEdges)
        {
            graph.get(redEdge[0]).add(new Pair<>(redEdge[1],1));
        }
        for(int[] blueEdge:blueEdges)
        {
            graph.get(blueEdge[0]).add(new Pair<>(blueEdge[1],2));
        }

        int dis = 0;
        queue.add(new Pair<>(0,-1));
        while(!queue.isEmpty())        
        {
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                Pair<Integer,Integer> curPair = queue.poll();
                int curNode = curPair.getKey();
                int curLabel = curPair.getValue();
                Set<Pair<Integer,Integer>> setPair = graph.get(curNode);
                for(Pair<Integer,Integer> adjPair:setPair)
                {
                    int adjNode = adjPair.getKey();
                    int adjLabel = adjPair.getValue();

                    if(visited.contains(adjPair)||curLabel==adjLabel)
                        continue;
                    
                    if(res[adjNode]==-1)
                        res[adjNode] = dis+1;
                    visited.add(adjPair);
                    queue.add(adjPair);
                }
            }
            dis++;
        }

        return res;
    }
}
