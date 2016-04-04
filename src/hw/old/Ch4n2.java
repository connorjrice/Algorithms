package hw.old;

/**
 *
 * @author Connor
 */
public class Ch4n2 {
    
    /** Chapter 4, n.2
     * Prim's algorithm for minimum spanning tree.
     * startEdge, endEdge, weight
     * @param W//
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
               // if (0 <= distance[j] && distance[j] < min) {
               if (0 < distance[j] && distance[j] < min) {               
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
    

    
    private static boolean contains(Integer[] a, int q) {
        for (int i : a) {
            if (i == q) {
                return true;
            }
        }
        return false;
    }    
    

}
