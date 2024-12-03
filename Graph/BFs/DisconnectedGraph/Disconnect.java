import java.util.*;

public class Disconnect {
    static  class Edge {
        int src;
        int dest;

        public Edge (int s, int d){
            this.src = s;
            this.dest = d;
        }
        
    }


    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(1, 2));
        graph[0].add(new Edge(2, 3));

        graph[1].add(new Edge(0, 2));
        graph[1].add(new Edge(2, 4));


        graph[2].add(new Edge(0, 1));
        graph[2].add(new Edge(1, 3));

        graph[3].add(new Edge(2, 3));
        graph[3].add(new Edge(4, 5));

        graph[4].add(new Edge(1, 4));
    }


    public static void BFS( ArrayList<Edge> graph[], int V, boolean visited[], int src){
        Queue<Integer> q = new LinkedList<>();
      
        q.add(src);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(visited[curr] == false){
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i =0; i < graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
       ArrayList<Edge> graph[] = new ArrayList[V];
       createGraph(graph);

       boolean visited[] = new boolean[graph.length];

       for(int i =0; i < V; i++){
           if(visited[i] == false){
           BFS(graph, V, visited, i);
           }
       }

       System.out.println();
    }
}


