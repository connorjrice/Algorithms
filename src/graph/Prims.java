package graph;

/**
 *
 * @author Connor
 */
public class Prims {
    
    public Prims() {
        
    }
    
    
    /**
     * startEdge, endEdge, weight
     * @param W
     * @return int[][] where int[i][0] = startNode // node
     *                       int[i][1] = endNode // vertex
     *                       int[i][2] = weight
     */
    public static int[][] getMST(int[][] W) {
        // TODO: Check if W is a matrix
          
        
        int n = W[0].length;
        int[][] F = new int[W[0].length][3]; // list of edges to be returned.
        // Y is the set of nodes, which I guess is contained in F.
        int numEdges = 0;
                
        // Edge is startEdge, endEdge, weight (a[0], a[1], a[2])
        int vnear = 0; // index of nearest node
        double min = Double.POSITIVE_INFINITY; // value // thanks book for infinity
        int[] nearest = new int[W[0].length]; // index
        int[] distance = new int[W[0].length]; // value
        
        // For all vertices, initalize v1 to be the nearest vertex in Y and init
        // ialize the distance from Y to be the weight on the edge to v1.
        for (int i = 1; i < n; i++) {
            nearest[i] = 1;
            distance[i] = W[0][i];
        }
        for (int i = 0; i < n; i++) { // repeat n-1 times
            min = Double.POSITIVE_INFINITY; // value // thanks book for infinity
            
            for (int j = 1; j < n; j++) { // Check each vertex for being nearest
                                           // to Y (current vertex)
                if (0 <= distance[j] && distance[j] < min) {
                    min = distance[j];
                    vnear = j;
                }                
            }
            // Add this edge to F
            F[numEdges] = new int[]{vnear,nearest[vnear],W[vnear][nearest[vnear]]}; 
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
    
}
