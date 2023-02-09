class Solution {
    public long distinctNames(String[] ideas) {
          List<String> arr[] = new ArrayList[26];               
                long disName = 0;                                     
              for(int i = 0; i < 26; i++)                         
           arr[i] = new ArrayList<>();
       for(String s : ideas)
           arr[s.charAt(0) - 'a'].add(s.substring(1));
       for(int i = 0; i < 25; i++) {
           for(int j = i + 1; j < 26; j++) {
               Set<String> set = new HashSet<>();
               set.addAll(arr[i]);
               set.addAll(arr[j]);
               disName += (arr[i].size() - set.size()) * (arr[j].size() - set.size());
           }
       }

       return disName * 2;
    }
}