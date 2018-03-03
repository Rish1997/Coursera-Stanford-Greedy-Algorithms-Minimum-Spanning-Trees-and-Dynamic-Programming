import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Prim {

    // Prim-Jarník's algorithm to find MST rooted at s
    public static int[] prim(WeightedGraph G, int s) {
        final int[] dist = new int[G.size()]; // shortest known distance to MST
        final int[] pred = new int[G.size()]; // preceeding node in tree
        final boolean[] visited = new boolean[G.size()]; // all false initially

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;

        for (int i = 0; i < dist.length; i++) {
            final int next = minVertex(dist, visited);
            visited[next] = true;

            // The edge from pred[next] to next is in the MST (if next!=s)

            final int[] n = G.neighbors(next);
            for (int j = 0; j < n.length; j++) {
                final int v = n[j];
                final int d = G.getWeight(next, v);
                if (dist[v] > d) {
                    dist[v] = d;
                    pred[v] = next;
                }
            }
        }
        return pred; // (ignore pred[s]==0!)
    }

    private static int minVertex(int[] dist, boolean[] v) {
        int x = Integer.MAX_VALUE;
        int y = -1; // graph not connected, or no unvisited vertices
        for (int i = 0; i < dist.length; i++) {
            if (!v[i] && dist[i] < x) {
                y = i;
                x = dist[i];
            }
        }
        return y;
    }

    public static void main(String[] args) throws FileNotFoundException {
        /* Let us create the following graph
           2    3
        (0)--(1)--(2)
        |    / \   |
        6| 8/   \5 |7
        | /      \ |
        (3)-------(4)
             9          */
        Scanner sc = new Scanner((new FileInputStream("./edges.txt")));
        int ver = sc.nextInt();
        int edges = sc.nextInt();
        int graph[][] = new int[500][500];
        for (int i = 0; i < edges; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int weight = sc.nextInt();
            graph[a - 1][b - 1] = weight;
        }
        System.out.println(graph[495][499]);

        // Print the solution
        t.primMST(graph);
        sc.close();
    }
}