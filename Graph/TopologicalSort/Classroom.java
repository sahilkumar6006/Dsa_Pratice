package TopologicalSort;
import java.util.*;

public class Classroom {

    public static class Edge{  // Make this static
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;   
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();  // Use generic type inference
        }

        graph[2].add(new Classroom.Edge(2, 3));  // Use fully qualified name
        graph[3].add(new Classroom.Edge(3, 1));
        graph[4].add(new Classroom.Edge(4, 0));
        graph[4].add(new Classroom.Edge(4, 1));
        graph[5].add(new Classroom.Edge(5, 6));
        graph[5].add(new Classroom.Edge(5, 2));
    }

    public static void TopSortUtil(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> stack){
        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!visited[e.dest]){
                TopSortUtil(graph, e.dest, visited, stack);
            }
        }

        stack.push(curr);
    }

    public static void topSort(ArrayList<Edge> graph[], int V){
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                TopSortUtil(graph, i, visited, stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int V = 7;  // Change to 7 to accommodate vertex 6
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topSort(graph, V);
    }   
}