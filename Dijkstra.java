import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {
	// Member variables of this class
    public double dist[];
    public Set<Integer> settled;
    public PriorityQueue<Node> pq;
    // Number of vertices
    private int V;
    public List<List<Node> > adj;
 
    // Constructor of this class
    public Dijkstra(int V)
    {
 
        // This keyword refers to current object itself
        this.V = V;
        dist = new double[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
    }
 
    // Method 1
    // Dijkstra's Algorithm
    public void dijkstra(List<List<Node> > adj, int src)
    {
        this.adj = adj;
 
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;
 
        // Add source node to the priority queue
        pq.add(new Node(src, 0));
 
        // Distance to the source is 0
        dist[src] = 0;
 
        while (settled.size() != V) {
 
            // Terminating condition check when
            // the priority queue is empty, return
            if (pq.isEmpty())
                return;
 
            // Removing the minimum distance node
            // from the priority queue
            int u = pq.remove().node;
 
            // Adding the node whose distance is
            // finalized
            if (settled.contains(u))
 
                // Continue keyword skips exwcution for
                // following check
                continue;
 
            // We don't have to call e_Neighbors(u)
            // if u is already present in the settled set.
            settled.add(u);
 
            e_Neighbours(u);
        }
    }
 
    // Method 2
    // To process all the neighbours
    // of the passed node
    private void e_Neighbours(int u)
    {
 
        double edgeDistance = -1;
        double newDistance = -1;
 
        // All the neighbors of v
        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);
 
            // If current node hasn't already been processed
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;
 
                // If new distance is cheaper in cost
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;
 
                // Add the current node to the queue
                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }
    
    public Node getCurrentNode()
    {
    	return this.pq.element();
    }
}
 
// Helper class implementing Comparator interface
// Representing a node in the graph

