class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> graph=new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<n;i++){
            if(manager[i]!=-1)
                graph.get(manager[i]).add(i);
        }

        HashSet<Integer> juniors=new HashSet<Integer>();
        for(int i=0;i<n;i++){
            if(graph.get(i).size()==0)
                juniors.add(i);
        }

        return dfs(headID,graph,informTime,informTime[headID],juniors);
        

    }

    public int dfs(int id,List<List<Integer>> graph,int[] informTime,int time,HashSet<Integer> juniors){
        if(juniors.contains(id)){
            return time;
        }

        int count=time;

        for(int el:graph.get(id)){
            count=Math.max(count,dfs(el,graph,informTime,time+informTime[el],juniors));
        
        }

        return count;
    }

}