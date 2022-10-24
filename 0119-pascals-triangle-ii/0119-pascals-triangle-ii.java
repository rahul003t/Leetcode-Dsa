class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        List<Integer> ans = new LinkedList<>();
        ans.add(1);
        for(int i=0;i<rowIndex;i++)
        { 
        List<Integer> temp = new LinkedList<>();
            temp.add(1);
            for(int j=0;j<ans.size()-1;j++)
            {
                temp.add(ans.get(j)+ans.get(j+1));
            }
            temp.add(1);
            ans = new LinkedList<>(temp);
        }
        return ans;
    }
}