class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int low=0;
        int r=potions.length-1;
        int ar[]=new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            low=0;
            r=potions.length-1;
            while(low<=r){
                int mid=low+(r-low)/2;
                long prodc=(long)spells[i]*potions[mid];
                if(prodc<success){
                    low=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
            ar[i]=potions.length-1-r;
        }
        return ar;
    }
}