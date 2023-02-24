//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            int a = Integer.parseInt(S1[0]);
            int b = Integer.parseInt(S1[1]);
            
            ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
            
            for(int i=0; i<m; i++)
            {
                String S2[] = read.readLine().split(" ");
                int u = Integer.parseInt(S2[0]);
                int v = Integer.parseInt(S2[1]);
                int x = Integer.parseInt(S2[2]);
                int y = Integer.parseInt(S2[3]);
                
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edge.add(x);
                edge.add(y);
                
                edges.add(edge);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestPath(n,m,a,b,edges));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {

    

    // Function to create the Adjacency List and the Adjacency List with Curved Distances

    static void createAdjList(ArrayList<ArrayList<Integer>> edges, ArrayList<ArrayList<int[]>> adj, ArrayList<int[]> curvedAdj, int n, int m) {

        

        for(int i = 0; i <= n; i++) {

            adj.add(new ArrayList<>());

        }

        

        for(int i = 0; i < m; i++) {

            

            int u = edges.get(i).get(0);

            int v = edges.get(i).get(1);

            int wt = edges.get(i).get(2);

            int curvedWt = edges.get(i).get(3);

            

            adj.get(u).add(new int[]{v, wt});

            adj.get(v).add(new int[]{u, wt});

            curvedAdj.add(new int[]{u, v, curvedWt});

        }

    }

    

    // Dijkstra's Algo to Find the Shortest Path

    static int[] findShortestPath(ArrayList<ArrayList<int[]>> adj, int src, int n) {

        

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[1]-a2[1]);

        

        int[] shortestPathsDists = new int[n+1];

        Arrays.fill(shortestPathsDists, (int)1e9);

        shortestPathsDists[src] = 0;

        

        pq.offer(new int[]{src, 0});

        while(!pq.isEmpty()) {

            int[] pair = pq.poll();

            int currNode = pair[0];

            int currWt = pair[1];

            // Processing the Neighbor Nodes

            for(int[] neighbor : adj.get(currNode)) {

                int neighborNode = neighbor[0];

                int neighborWt = neighbor[1];

                int newWt = currWt + neighborWt;

                if(newWt < shortestPathsDists[neighborNode]) {

                    shortestPathsDists[neighborNode] = newWt;

                    pq.offer(new int[]{neighborNode, newWt});

                }

            }

        }

        return shortestPathsDists;

    }

    

    static int shortestPath(int n, int m, int a, int b, ArrayList<ArrayList<Integer>> edges) {

        

        // Creating the Adjacency List and the Adjacency List with Curved Distances

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        ArrayList<int[]> curvedAdj = new ArrayList<>();

        createAdjList(edges, adj, curvedAdj, n, m);

        

        int[] dist1 = findShortestPath(adj, a, n);

        int[] dist2 = findShortestPath(adj, b, n);

        

        int shortestDist = dist1[b];

        for(int i = 0; i < m; i++) {

            int[] triplet = curvedAdj.get(i);

            int u = triplet[0];

            int v = triplet[1];

            int curvedWt = triplet[2];

            

            shortestDist = Math.min(shortestDist, dist1[u] + curvedWt + dist2[v]);

            shortestDist = Math.min(shortestDist, dist1[v] + curvedWt + dist2[u]);

        }

        

        if(shortestDist >= (int)1e9) {

            return -1;

        }

        

        return shortestDist;

    }

};