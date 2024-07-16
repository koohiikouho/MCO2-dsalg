import java.util.*;

public class Graph {
    private int V;

    private LinkedList<Integer> adj[];

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public int getV() {
        return V;
    }

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

    public ArrayList<Integer> showConnection(int source, int destination) {
        boolean[] visited = new boolean[adj.length];
        int[] start = new int[adj.length];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;
        start[source] = -1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == destination) {
                return makePath(start, current);

            }
            for (int friend : adj[current]) {
                if (!visited[friend]) {
                    queue.add(friend);
                    visited[friend] = true;
                    start[friend] = current;
                }
            }
        }

        return null;
    }

    private ArrayList<Integer> makePath(int[] start, int destination) {
        ArrayList<Integer> path = new ArrayList<>();
        int current = destination;

        while (current != -1) {
            path.add(0, current);
            current = start[current];
        }
        return path;
    }

}