package Dijkstra;
import java.util.*;


public class ClassRoom {

    public static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }


    }

    
    public void createGraph(ArrayList<Edge> graph[]){
        for(int i =0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        } 
        
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static int[] dijkstra(ArrayList<Edge> graph[], int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[graph.length];
        boolean visited[] = new boolean[graph.length];

    for(int i =0; i < dist.length; i++){
        dist[i] = Integer.MAX_VALUE;
    }

    pq.add(new Pair(src, 0));

    while(!pq.isEmpty()){
        Pair 

    }


    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        int src = 0;

        int dist[]  = dijkstra(graph,src);

        for(int i 0;  i< dist.length; i++){
            System.out.println("Vertex " + i + " is at a distance of " + dist[i]);
        }
    
    }
}
