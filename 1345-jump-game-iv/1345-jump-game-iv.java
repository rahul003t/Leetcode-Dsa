class Solution {
    public int minJumps(int[] arr) {
        int steps=0;
        int  n=arr.length;
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!hm.containsKey(arr[i])){
                List<Integer> temp =new ArrayList<>();
                temp.add(i);
                hm.put(arr[i],temp);
            }
            else{
                List<Integer> temp=hm.get(arr[i]);
                temp.add(i);
                hm.put(arr[i],temp);
            }
        }
        boolean vis[]=new boolean[n];
        vis[0]=true;
        Queue<Integer> qu=new LinkedList<>();
        qu.add(0);
        while(!qu.isEmpty()){
            int size=qu.size();
            for(int i=0;i<size;i++){
                int curridx=qu.poll();
                if(curridx==n-1)
                    return steps;
                List<Integer> jumptoindexes=hm.get(arr[curridx]);
                jumptoindexes.add(curridx+1);
                jumptoindexes.add(curridx-1);
                for(int q:jumptoindexes){
                    if(q>=0 && q<n && !vis[q]){
                        vis[q]=true;
                        qu.add(q);
                    }
                }
                jumptoindexes.clear();
            }
            steps++;
        }
        return -1;
    }
}