package graph;

public class Test {
    public static void main(String[] args) {
        Graph g=new Graph(6);
        g.addEdges(0,1);
        g.addEdges(0,2);
        g.addEdges(2,1);
        g.addEdges(3,1);
        g.addEdges(4,3);
        g.addEdges(5,0);
       // Graph.printGraph(g);

       // int[][] edges={{0,1},{0,2},{0,3},{0,4},{0,5}};
        Graph g1=new Graph(6);
        Graph.printAdjacentMatrix(g1);



    }
}
