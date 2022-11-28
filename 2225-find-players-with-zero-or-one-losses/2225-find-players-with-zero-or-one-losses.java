class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> w_map = new HashMap<>();
        HashMap<Integer, Integer> l_map = new HashMap<>();
        
        for(int i=0;i<matches.length;i++)
        {
            int winCount = w_map.getOrDefault(matches[i][0], 0);
            int lostCount= l_map.getOrDefault(matches[i][1], 0);
            
            w_map.put(matches[i][0], winCount+1);
            l_map.put(matches[i][1], lostCount+1);
        }
        
        
        List<List<Integer>> list = new ArrayList<>();
        
        List<Integer>list1 = new ArrayList<>();
        List<Integer>list2 = new ArrayList<>();
        
        for(int key : w_map.keySet())
        {
            if(!l_map.containsKey(key)) 
            {
                list1.add(key);
            }
        }
        for(int key: l_map.keySet() )
        {
            if(l_map.get(key) == 1) list2.add(key);
        }
        
        Collections.sort(list1);
        Collections.sort(list2);
        list.add(list1);
        list.add(list2);
        return list;
    }
}