class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
      List<Integer> result= new ArrayList<>()  ;
      boolean indegree[]=new  boolean[n];

      for(int i=0;i<edges.size();i++){
          int p=edges.get(i).get(1);
          indegree[p]=true;
      }
      for(int i=0; i<n;i++){
          if(!indegree[i]){
              result.add(i);
          }
      }
      return result;
    }
}