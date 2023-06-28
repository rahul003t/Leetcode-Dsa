class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Create an adjacency list to represent the graph
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph using the given edges and probabilities
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double p = succProb[i];
            graph.get(a).add(new Edge(b, p));
            graph.get(b).add(new Edge(a, p));
        }
        
        // Perform Dijkstra's algorithm to find the maximum probability path
        double[] probabilities = new double[n];
        probabilities[start] = 1.0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        pq.offer(new Node(start, 1.0));
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curr = node.vertex;
            
            if (curr == end) {
                return node.probability;
            }
            
            for (Edge edge : graph.get(curr)) {
                int neighbor = edge.destination;
                double probability = edge.probability;
                double newProbability = node.probability * probability;
                
                if (newProbability > probabilities[neighbor]) {
                    probabilities[neighbor] = newProbability;
                    pq.offer(new Node(neighbor, newProbability));
                }
            }
        }
        
        return 0.0;
    }
    
    // Helper class to represent an edge in the graph
    class Edge {
        int destination;
        double probability;
        
        public Edge(int destination, double probability) {
            this.destination = destination;
            this.probability = probability;
        }
    }
    
    // Helper class to represent a node in the priority queue
    class Node {
        int vertex;
        double probability;
        
        public Node(int vertex, double probability) {
            this.vertex = vertex;
            this.probability = probability;
        }
    }
}

