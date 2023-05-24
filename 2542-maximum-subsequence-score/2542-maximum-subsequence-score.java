class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int nums[][] = new int[n][2];

        for(int i=0; i<n; i++){
            int temp[] = new int[2];
            temp[0] = nums1[i];
            temp[1] = nums2[i];
            nums[i] = temp;
        }

        Arrays.sort(nums, (a,b) -> b[1] - a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long ans = -1, sum = 0;

        for(int i=0; i<k; i++){
            sum += nums[i][0];
            pq.add(nums[i][0]);
        }
        ans = sum * nums[k-1][1];
        // System.out.println(ans);

        for(int i=k; i<n; i++){
            sum += nums[i][0] - pq.poll();
            pq.add(nums[i][0]);

            long temp = sum * nums[i][1];
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}