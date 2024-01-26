package Graph;
import java.util.*;

class Pair {
    int distance, node;
    public Pair(int _dis, int _node){
        distance = _dis;
        node = _node;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        //min heap
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        
        int[] dist = new int[V];
        for(int i = 0; i < V; i++){
            dist[i] = (int)(1e9);
        }
        
        dist[S] = 0;
        pq.add(new Pair(0, S));
        
        while(!pq.isEmpty()){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            
            for(int i = 0; i < adj.get(node).size(); i++){
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                
                if(dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        
        for(int i = 0; i < V; i++){
            if(dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }
}

// TC -> E log V (edge log total_nodes)
