import java.util.*;
class LargestTree{
    static void addEdge(LinkedList<Integer> adj[], int u, int v)
    {
        //TO-DO:
        adj[u].add(v);
        adj[v].add(u);
    }

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited)
    {
        visited.set(u, true);
        int size = 1;
        // Iterate through all the nodes and perform DFS if the node is not yet visited
        //TO-DO:

        for(int w : adj[u]){
            if(!visited.get(w)){
                size += DFS(w, adj, visited);
            }
        }
        return size;
    }

    public int largestTree(LinkedList<Integer> adj[], int V)
    {
        //TO-DO:
        if(adj.length == 0){
            return 0;
        }
        int res = 1;
        Vector<Boolean> visited = new Vector<>();
        for(int i = 0; i < V; i++){
            visited.add(i, false);
        }
        for(int i = 0; i < V; i++){
            if(!visited.get(i)){
                res = Math.max(DFS(i, adj, visited), res);
            }
        }
        return res;
    }
}

