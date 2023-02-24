class Solution {
    public int minimumDeviation(int[] nums) {
        if(nums==null || nums.length==0)
            return Integer.MAX_VALUE;
        PriorityQueue<Integer> even=new PriorityQueue<>(nums.length,Collections.reverseOrder());
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            if(num%2==0){
                even.offer(num);
                min=Math.min(num,min);
            }
            else{
                even.offer(num*2);
                min=Math.min(num*2,min);
            }
        }
        int res=Integer.MAX_VALUE;
        while(even.peek()%2==0){
            int max=even.poll();
            res=Math.min(res,max-min);
            int newnum=max/2;
            even.offer(newnum);
            min=Math.min(min,newnum);
        }
        res=Math.min(even.peek()-min,res);
        return res;
    }
}