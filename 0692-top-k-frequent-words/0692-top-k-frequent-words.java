class Solution {
    public List<String> topKFrequent(String[] words, int k) {
         HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        
        for(String w : words){
            map.put(w, map.getOrDefault(w, 0)+1);
        }
        
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (x, y) -> (
                x.getValue()==y.getValue() ? 
                x.getKey().compareTo(y.getKey()) : 
                y.getValue()-x.getValue()
            )
        );
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.add(entry);
        }
        
        while(k-- > 0){
            res.add(pq.poll().getKey());
        }
        
        return res;
        
    }
}