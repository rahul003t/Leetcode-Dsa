class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sum_a =0,sum_b=0;
        int n = aliceSizes.length;
        int m = bobSizes.length;
        
        for(int i=0;i<n;i++)
        {
            sum_a+=aliceSizes[i];
        }
        
        for(int j=0;j<m;j++)
        {
            sum_b+=bobSizes[j];
        }
        
        
        int[] arr = new int[2];
        int target= (sum_a-sum_b)/2;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(aliceSizes[i] == bobSizes[j]+target )
                {
                    arr[0]=aliceSizes[i];
                    arr[1]=bobSizes[j];
                }
            }
        }
        return arr;
    }
}