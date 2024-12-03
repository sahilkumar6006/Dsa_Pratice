package DFS;
import java.util.*;

public class Classroom {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        // Initialize empty ArrayLists for each vertex
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 2)); // Self-loop

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    public static void DFS(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                DFS(graph, e.dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        // Printing edges of graph[1] for demonstration
        for (int i = 0; i < graph[1].size(); i++) {
            Edge e = graph[1].get(i); // Fixed to use graph[1]
            System.out.println("Edge: " + e.src + " " + e.dest);
        }

        // Perform DFS from node 0
        boolean visited[] = new boolean[V];
        System.out.println("DFS Traversal:");
        DFS(graph, 0, visited);
    }
}
