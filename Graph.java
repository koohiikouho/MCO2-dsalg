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

    private boolean dfsHelper(int v, boolean visited[], int destination, int source) {
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

                bConnection = dfsHelper(n, visited, destination, source);
                if (bConnection == true) {
                    connectedTo = n;
                    System.out.println(connectedTo + " is connected to " + v);
                    return true;
                }
            }

        }

        return false;

    }

    public void dfs(int v, int destination) {
        boolean visited[] = new boolean[V];
        if (dfsHelper(v, visited, destination, v) != true) {
            System.out.println("Cannot find connection between " + v + " and " + destination);
        }

    }

    public ArrayList<Integer> bfs(int source, int destination) {
        boolean[] visited = new boolean[V];
        int[] start = new int[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        visited[source] = true;
        start[source] = -1;

        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == destination) {
                return makePath(start, current);

            }
            for (int edges : adj[current]) {
                if (!visited[edges]) {
                    q.add(edges);
                    visited[edges] = true;
                    start[edges] = current;
                }
            }
        }

        return null;
    }

    private ArrayList<Integer> makePath(int[] source, int destination) {
        ArrayList<Integer> path = new ArrayList<>();
        int current = destination;

        while (current != -1) {
            path.add(0, current);
            current = source[current];
        }
        return path;
    }

}