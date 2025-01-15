import java.util.Vector;

public class AdjacencyList {


    // Function to initialize the adjacency list
    // of the given graph
    static void initGraph(int V, int edges[][], int noOfEdges) {

        // To represent graph as adjacency list
        @SuppressWarnings("unchecked")
        Vector<Integer> adj[] = new Vector[3];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Vector<>();
        }

        // Traverse edges array and make edges
        for (int i = 0; i < noOfEdges; i++) {
            // Function call to make an edge
            addEdge(adj, edges[i][0], edges[i][1]);
        }

        // Function Call to print adjacency list
        adjacencyList(adj, V);
    }

    // Function to add edges
    static void addEdge(Vector<Integer> adj[], int u, int v) {
        adj[u].add(v);
    }

    // Function to print adjacency list
    static void adjacencyList(Vector<Integer> adj[], int V) {
        for (int i = 0; i < V; i++) {
            System.out.print(i + "->");
            for (int x : adj[i]) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args) {
        // Given vertices
        int V = 3;

        // Given edges
        int edges[][] = {{0, 1}, {1, 2}, {2, 0}};

        int noOfEdges = 3;

        // Function Call
        initGraph(V, edges, noOfEdges);

    }
}
