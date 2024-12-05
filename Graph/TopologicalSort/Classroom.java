package TopologicalSort;
import java.util.*;

public class Classroom {

    public static class Edge{ 
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;   
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();  
        }
        graph[2].add(new Classroom.Edge(2, 3)); 
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

    public static boolean isCyclicUtil(ArrayList<Edge>[] graph, boolean vis[], int
curr, int par) {
vis[curr] = true;
for(int i=0; i<graph[curr].size(); i++) {
Edge e = graph[curr].get(i);
//case1
if(vis[e.dest] && e.dest != par) {

boolean isCycle = isCyclicUtil(graph, vis, e.dest, curr);
if(isCycle)
return true;
} else if(e.dest == par) {
//case 2
continue;
} else {
//case 3
return true;
}
}
return false;
}
//O(V+E)
public static boolean isCyclic(ArrayList<Edge>[] graph, boolean vis[]) {
for(int i=0; i<graph.length; i++) {
if(isCyclicUtil(graph, vis, i, -1)) {
return true;
}
}
return false;
}
    public static void main(String[] args) {
        int V = 7;  // Change to 7 to accommodate vertex 6
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topSort(graph, V);
    }   
}