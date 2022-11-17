class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        int la = Math.abs(ax2-ax1);
        int ba = Math.abs(ay2-ay1);
        
        int lb = Math.abs(bx2-bx1);
        int bb = Math.abs(by2-by1);
        
        int aArea = la*ba;
        int bArea = lb*bb;
        
        int ans = aArea+bArea - Math.max(0,Math.min(ax2,bx2)-Math.max(ax1,bx1)) * Math.max(0, Math.min(by2,ay2)-Math.max(ay1,by1));
        
        return ans;
    }
}