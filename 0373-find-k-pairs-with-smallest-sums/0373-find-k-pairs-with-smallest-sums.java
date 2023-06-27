class Solution {
    class Node implements Comparable<Node> {
        int start;
        int end;
        int index;
        public Node(int start ,int end , int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }
        public int compareTo(Node node){
            return (this.start + this.end) - (node.start + node.end);
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] arr1, int[] arr2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0 ; i < arr1.length ; i++){
            pq.add(new Node(arr1[i] , arr2[0] , 0));
        }
        while(k-- > 0 && pq.size() > 0){
            Node curNode = pq.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(curNode.start);
            temp.add(curNode.end);
            if(curNode.index + 1 < arr2.length){
                pq.add(new Node(curNode.start , arr2[curNode.index + 1] , curNode.index + 1));
            }
            ans.add(temp);
        }
        return ans;
    }
}