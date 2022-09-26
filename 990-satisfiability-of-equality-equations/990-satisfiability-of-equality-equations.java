class Solution {
  public boolean equationsPossible(String[] equations) {
    UnionFind unionFind = new UnionFind(26);
    for (String equation : equations) {
      if (equation.charAt(1) == '=') {
        unionFind.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
      }
    }

    for (String equation : equations) {
      if (equation.charAt(1) == '!') {
        if (unionFind.find(equation.charAt(0) - 'a', equation.charAt(3) - 'a')) {
          return false;
        }
      }
    }

    return true;
  }

  static class UnionFind {
    // parent of node
    private final int[] parent;
    // rank of disjoint set
    private final int[] rank;
    // number of disjoint set
    private int count;

    UnionFind(int n) {
      count = n;
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) {
        // every node is itself
        parent[i] = i;
        // every node init rank is one
        rank[i] = 1;
      }
    }

    private int root(int p) {
      while (parent[p] != p) {
        // compress path
        parent[p] = parent[parent[p]];
        p = parent[p];
      }

      return p;
    }

    public int count() {
      return count;
    }

    public boolean find(int p, int q) {
      return root(p) == root(q);
    }

    public boolean union(int p, int q) {
      int rootP = root(p);
      int rootQ = root(q);
      if (rootP == rootQ) {
        return false;
      }

      if (rank[rootP] < rank[rootQ]) {
        parent[rootP] = rootQ;
        rank[rootQ] += rank[rootP];
      } else {
        parent[rootQ] = rootP;
        rank[rootP] += rank[rootQ];
      }

      count++;

      return true;
    }
  }
}