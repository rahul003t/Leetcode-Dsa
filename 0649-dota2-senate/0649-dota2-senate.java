class Solution {
    public String predictPartyVictory(String senate) {
        
        Queue<Integer> q1 = new LinkedList();
        Queue<Integer> q2 = new LinkedList();
        int n = senate.length();
        for(int i=0; i<n; i++) {
            if(senate.charAt(i)=='R')
                q1.add(i);
            else
                q2.add(i);
        }
        while(!q1.isEmpty()&&!q2.isEmpty()) {
            int r_idx = q1.poll();
            int d_idx = q2.poll();
            if(r_idx<d_idx)
                q1.add(r_idx+n);
            else
                q2.add(d_idx+n);
        }
        return q1.size()>q2.size()? "Radiant":"Dire";
    }
}