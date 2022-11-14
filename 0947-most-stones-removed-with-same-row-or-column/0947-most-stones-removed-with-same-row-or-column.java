class Solution {
    public int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        
        int length = stones.length;
        UnionFind unionFind = new UnionFind(length);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (stones[i][0] == stones[j][0] || stones[j][1] == stones[i][1]) {
                    unionFind.union(i, j);
                }
            }
        }
       return length - unionFind.getComponent();
    }
}

class UnionFind {
    int size;
    int component;
    int [] rank;
    int [] parent;
    
    public UnionFind(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n cannot be less than or equal to 0");
        }
        size = n;
        component = n;
        rank = new int [n];
        parent = new int [n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        }
        else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ]) {
                rank[rootP]++;
            }
        }
        component--;
    }
    
    public int getComponent() {
        return component;
    }
}