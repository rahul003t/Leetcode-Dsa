class Solution {
    public int maximumRemovals(String s, String p, int[] rem) {
        
    int l = 0, r = rem.length;
    int[] arr = new int[s.length()];
        
    Arrays.fill(arr, rem.length);
        
    for (int i = 0; i < rem.length; ++i){
         arr[rem[i]] = i; 
        
    }
    while (l < r) {
        int mid = (l + r + 1) / 2, j = 0;
        
        for (int i = 0; i < s.length() && j < p.length(); ++i){
            if (arr[i] >= mid && s.charAt(i) == p.charAt(j))
                ++j;
        }
        if (j == p.length()){
            l = mid;
        }
        else{
            r = mid - 1;
        }
    }
        
      return l;
    }
}