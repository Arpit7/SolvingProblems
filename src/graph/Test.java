package graph;

public class Test {
    public static void main(String[] args) {
        Graph g=new Graph(7);
        g.addEdges(1,2,true);
        g.addEdges(1,0,true);
        g.addEdges(2,3,true);
        g.addEdges(0,4,true);
        g.addEdges(3,4,true);
        g.addEdges(3,5,true);
        g.addEdges(4,5,true);
        g.addEdges(5,6,true);
        //Graph.printAdjacentList(g);

      //  Graph.bfs(g,1,6);
       // int[][] edges={{0,1},{0,2},{0,3},{0,4},{0,5}};
       // Graph g1=new Graph(6);
       // Graph.printAdjacentMatrix(g1);
        Graph.dfs(g,1);



    }
}
