class Solution {
    int C;
    boolean[] visited;
    public long minimumFuelCost(int[][] roads, int seats) {
        C = seats;
        ArrayList<Integer>[] adjList = new ArrayList[roads.length+1];
        visited = new boolean[roads.length+1];
        for(int i=0; i<=roads.length; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<roads.length; i++) {
            adjList[roads[i][0]].add(roads[i][1]);
            adjList[roads[i][1]].add(roads[i][0]);
        }
        Detail ans = traverse(0, adjList);
        return ans.fuel;

    }

    Detail traverse(int cur, ArrayList<Integer>[] adjList) {
        visited[cur]=true;
        Detail detail = new Detail(1, 0L);
        List<Integer> lst = adjList[cur];
        for(int child : lst) {
            if(!visited[child]) {
            Detail temp = traverse(child, adjList);
            detail.pCount = detail.pCount + temp.pCount;
            detail.fuel = detail.fuel + temp.fuel;
            }
        }
        if(cur!=0) {
        int currCarCount = (detail.pCount/C) + (((detail.pCount%C)==0) ? 0 : 1);
        long currFuel = detail.fuel + currCarCount;
        detail.fuel = currFuel;
        }
        return detail;
    }


}

class Detail {
    int pCount;
    long fuel;
    Detail(int pCount, long fuel) {
        this.pCount = pCount;
        this.fuel = fuel;
    }
}