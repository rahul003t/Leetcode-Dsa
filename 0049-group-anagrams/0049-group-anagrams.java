class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        
        HashMap<String,List<String>> hm = new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            char[] ch1 = strs[i].toCharArray();
            Arrays.sort(ch1);
            String s = new String(ch1);
            
            if(hm.containsKey(s)){
                
                List<String> list = hm.get(s);
                list.add(strs[i]);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hm.put(s,list);
                
            }
        }
        for(Map.Entry<String,List<String>> e : hm.entrySet()){
            res.add(e.getValue());
        }
        return res;
    }
}
        
   