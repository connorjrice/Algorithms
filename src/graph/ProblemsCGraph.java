package graph;

/**
 * Problems C, Chapter 3(28), Chapter 4(2,6,7,12,15)
 * @author Connor
 * Figure out what "Modify Dijkstra's algorithm so that it computes the lengths
 * of the shortest paths." means.
 */
public class ProblemsCGraph {
    
    /** Chapter 3, n.28
     * Takes a minimum spanning tree as input, produces an optimal circuit from
     * that minimum spanning tree.
     * @param W
     * @return 
     */
    public static int[][] getOptimalCircuit(int[][] W) {
        int[][] mst = getMSTPrims(W);
        int[][] circuit = new int[mst.length+1][3];
        
        // Copy mst into circuit
        for (int i = 0; i < mst.length; i++) {
            circuit[i] = mst[i];
        }
        
        // Find the last edge to create a circuit
        
        return circuit;
    }
    
    /** Chapter 4, n.2
     * Prim's algorithm for minimum spanning tree.
     * startEdge, endEdge, weight
     * @param W
     * @return int[][] where int[i][0] = startNode // node
     *                       int[i][1] = endNode // vertex
     *                       int[i][2] = weight
     */
    public static int[][] getMSTPrims(int[][] W) {
        // TODO: Check if W is a matrix
        int n = W[0].length;
        int[][] F = new int[W[0].length-1][3]; // list of edges to be returned.
        // Y is the set of nodes, which I guess is contained in F.
        int numEdges = 0;
                
        // Edge is startEdge, endEdge, weight (a[0], a[1], a[2])
        int vnear = 0; // index of nearest node
        double min; // value of smallest edge weight
        int[] nearest = new int[W[0].length]; // index
        int[] distance = new int[W[0].length]; // value
        
        // Grab the edge values for v1, our starting vertex.
        for (int i = 1; i < n; i++) {
            nearest[i] = 0; // 0 is our starting index 
            distance[i] = W[0][i];
        }
        for (int i = 0; i < n-1; i++) { // repeat n-1 times
            min = Double.POSITIVE_INFINITY; // value
            
            // Check each edge weight, look for minimum
            for (int j = 1; j < n; j++) {
                // If we have a nonzero distance and the distance at the current
                // index is less than our minimum, set minimum to be distance[j]
                if (0 <= distance[j] && distance[j] < min) {
                    min = distance[j];
                    vnear = j;
                }                
            }
            // Add this edge to F
            F[numEdges] = new int[]{vnear,nearest[vnear],
                W[vnear][nearest[vnear]]}; 
            numEdges++;
            distance[vnear] = -1;
            
            // Add vertex indexed by vnear to Y.
            // For each vertex not in Y, update it's distance from Y.
            for (int j = 1; j < n; j++) {
                if (W[j][vnear] < distance[j]) {
                    distance[j] = W[j][vnear];
                    nearest[j] = vnear;
                }
            }            
        }
        return F;
    }
    
    /** Chapter 4, n.12
     * 
     * @param edges
     * @return 
     */
    public static int[][] getShortestPath(int[][] edges) {
        return null;
    }
            
    
    /** Chapter 4, n.7
     * 
     * @param w
     * @return 
     */
    public static int[][] getMSTKruskals(int[][] w) {
        return null;
    }
    
    /** Chapter 4, n.6
     * Checks to see whether or not a graph described by edges is connected.
     * The problem described modifying your Prim's algorithm to determine 
     * whether an unweighted graph was connected. Rather than copy-pasting code,
     * this function determines if a given set of edges (all we care about is
     * if the graph is connected, so weighted or unweighted doesn't actually 
     * matter, and this function's output will not be affected by whether or not
     * the value to and from each node is equal.
     * @param edges
     * @param n number of nodes
     * @return 
     */
    public static boolean isConnected(int[][] edges, int n) {
        // Definintion:
        // A graph is connected if there all nodes are connected by a path.
        int currentIndex = 0;
        int[] connectedNodes = new int[n]; 
        boolean isConnected = false;
        // We will build a path from [0] to [n-1], length n
        for (int[] edge : edges) {
            
        }
        return isConnected;
    }

    /** For comparison
     * Return the total weight of a minimum spanning tree.
     * @param edges
     * @return 
     */    
    public static int getMSTWeight(int[][] edges) {
        int weight = 0;
        for (int[] e : edges) {
            weight += e[2];
        }
                
        return weight;
    }
        
}
