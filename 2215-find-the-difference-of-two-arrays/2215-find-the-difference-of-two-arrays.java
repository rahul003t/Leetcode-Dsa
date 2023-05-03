class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        
        HashSet<Integer>set = new HashSet<>();
        
        
        for(int i=0;i<nums2.length;i++){
            set.add(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            if(!set.contains(nums1[i]) && !first.contains(nums1[i])){
                first.add(nums1[i]);
            }
        }
        ans.add(first);
        set.clear();
        
        
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(!set.contains(nums2[i]) && !second.contains(nums2[i])){
                second.add(nums2[i]);
            }
        }
        ans.add(second);
        
        return ans;
    }
    
}
