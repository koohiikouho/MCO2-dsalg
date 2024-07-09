import java.util.*;

public class Graph {
    private int V;

    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private boolean DFSUtil(int v, boolean visited[], int destination, int source) {
        visited[v] = true;
        boolean bConnection = false;
        Iterator<Integer> i = adj[v].listIterator();
        int connectedTo = -1;
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                if (n == destination) {
                    System.out.println("There is a connection between " + source + " and " + destination + "!");
                    System.out.println(n + " is friends with " + v);
                    return true;
                }

                bConnection = DFSUtil(n, visited, destination, source);
                if (bConnection == true) {
                    connectedTo = n;
                    System.out.println(connectedTo + " is connected to " + v);
                    return true;
                }
            }

        }

        return false;

    }

    public void DFS(int v, int destination) {

        boolean visited[] = new boolean[V];
        if (DFSUtil(v, visited, destination, v) != true) {
            System.out.println("Cannot find connection between " + v + " and " + destination);
        }

    }
}
