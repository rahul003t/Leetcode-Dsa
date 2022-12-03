class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map= new HashMap<>();
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        StringBuilder result=new StringBuilder();
        while(!pq.isEmpty())
        {    Character c=pq.remove();
            for(int i=0;i<map.get(c);i++){
                 result.append(c);
            }
               
        }
            
    

       return result.toString(); 
    }
}