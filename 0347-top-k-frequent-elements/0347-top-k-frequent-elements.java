class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] count = new int[20001], res = new int[k];
        for(int i : nums) count[i + 10000]++;
        List<Integer>[] freq_list = new ArrayList[20001];
        for(int i = 0; i < 20001; i++) {
            if(count[i] != 0) {
                if(freq_list[count[i]] == null) freq_list[count[i]] = new ArrayList<>();
                freq_list[count[i]].add(i - 10000); 
            }
        }
        int index = 0;
        for(int i = 20000; i >= 0; i--) {
            if(freq_list[i] != null) {
                for(int n : freq_list[i]) {
                    res[index++] = n;
                    if(index == k) break;
                }
            }
            if(index == k) break;
        }
        return res;
    }
}