class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int i = 0;
        int j = people.length - 1;
        Arrays.sort(people);
        int ans = 0;
        while(i <= j){
            int sum = people[i] + people[j];
            if(sum > limit){
                j--;
                ans++;
            }else{
                i++;
                j--;
                ans++;
            }
        }
        
        return ans;
    }
}