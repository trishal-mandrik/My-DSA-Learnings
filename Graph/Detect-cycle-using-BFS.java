package Graph;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Node{
    int curr, parent;
    
    public Node(int curr, int parent){
        this.curr = curr;
        this.parent = parent;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                if(detectCycle(i, vis, adj)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean detectCycle(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(node, -1));
        vis[node] = true;
        
        while(!q.isEmpty()){
            int curr = q.peek().curr;
            int parent = q.peek().parent;
            q.remove();
            
            for(Integer it: adj.get(curr)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(new Node(it, curr));
                }
                else if (parent != it){
                    return true;
                }
            }
        }
        return false;
    }
}
