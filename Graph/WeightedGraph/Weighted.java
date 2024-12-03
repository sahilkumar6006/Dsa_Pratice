// package WeightedGraph;

// import java.util.ArrayList;

// public class Weighted {
    
//     static class Edge{
//         int src;
//         int dest;
//         int wt;

//         public Edge(int s ,int d, int w){
//             this.src = s;
//             this.dest = d;
//             this.wt = w;
//         }
//     }
    
//     public static void createGraph(ArrayList<Edge> graph[]){
//         for(int i =0; i < graph.length; i++){
//             graph[i] = new ArrayList<Edge>();
//         }

   

//         graph[0].add(new Edge(0, 2,2));

//         graph[1].add(new Edge(1, 2, 10));
//         graph[1].add(new Edge(1, 3,0));


        
//         graph[2].add(new Edge(2, 0, 2));
//         graph[2].add(new Edge(2, 1, 10));
//         graph[2].add(new Edge(2, 3,-1));


        
//         graph[2].add(new Edge(3, 1, 0));
//         graph[3].add(new Edge(3, 2, -1));
//     }

//     public static  void PrintAllPath(ArrayList<Edge> graph[], boolean visited[], int curr, int target, String path){
//         if(curr == target){
//             System.out.println(path);
//             return;
//         }

//         for(int i =0 ; i < graph[curr].size(); i++){
//             Edge e = graph[curr].get(i);
//             if(!visited[e.dest]){
//                visited[curr] = true;
//                PrintAllPath(graph, visited, e.dest, target, path + e.dest);
//                visited[curr] = false;
//             }
//         }
//     }


//     public static void main(String[] args) {
        
//         int V = 4;
//         ArrayList<Edge> graph[] = new ArrayList[V];
//         createGraph(graph);

//         for(int i = 0; i < graph[2].size(); i++){
//             Edge e = graph[2].get(i);
//             System.out.println("Edge from " + e.src + " to " + e.dest + "weight" + e.wt);
//         }
//     }

   
// }



// public static  void PrintAllPath(ArrayList<Edge> graph[], boolean visited[], int curr, int target, String path){
//     if(curr == target){
//         System.out.println(path);
//         return;
//     }

//     for(int i =0 ; i < graph[curr].size(); i++){
//         Edge e = graph[curr].get(i);
//         if(!visited[e.dest]){
//            visited[curr] = true;
//            PrintAllPath(graph, visited, e.dest, target, path + e.dest);
//            visited[curr] = false;
//         }
//     }
// }

import java.util.*;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        List<Integer> path = new ArrayList<>();
        path.add(0); // Start from the source node
        dfs(graph, 0, graph.length - 1, visited, path, result);
        return result;
    }

    private void dfs(int[][] graph, int curr, int target, boolean[] visited, List<Integer> path, List<List<Integer>> result) {
        if (curr == target) {
            // Add the current path to the result list
            result.add(new ArrayList<>(path));
            return;
        }

        // Mark the current node as visited
        visited[curr] = true;

        // Explore all neighbors of the current node
        for (int neighbor : graph[curr]) {
            if (!visited[neighbor]) {
                path.add(neighbor);
                dfs(graph, neighbor, target, visited, path, result);
                path.remove(path.size() - 1); // Backtrack
            }
        }

        // Backtrack: unmark the current node as visited
        visited[curr] = false;
    }
}
