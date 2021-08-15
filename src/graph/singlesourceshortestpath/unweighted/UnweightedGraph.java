package graph.singlesourceshortestpath.unweighted;

import java.util.*;

class Graph
{
    private int vertex;
    private Map<Integer, List<Integer>> parentChildMap=new HashMap<>();
    public Graph(int vertex)
    {
        this.vertex=vertex;
        for(int i=0;i<vertex;i++)
        {
            parentChildMap.put(i,new ArrayList<>());
        }
    }

    public void addEdge(int x,int y)
    {
        parentChildMap.get(x).add(y);
        parentChildMap.get(y).add(x);
    }

    public int getVertex() {
        return vertex;
    }

    public Map<Integer, List<Integer>> getParentChildMap() {
        return parentChildMap;
    }
}




public class UnweightedGraph {
    public static void main(String[] args) {

        Graph graph=new Graph(7);
        graph.addEdge(1,2);
        graph.addEdge(1,0);
        graph.addEdge(2,3);
        graph.addEdge(0,4);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        int startVertex=1;
       int[] distance= UnweightedGraph.getSingleSourceShortestDistance(graph,startVertex);
       for(int i=0;i<distance.length;i++)
       {
           System.out.println("Distance from "+startVertex+" to vertex "+i+" equals= "+ distance[i]);
       }

    }

    public static int[] getSingleSourceShortestDistance(Graph g, int startNode)
    {
        int[] distance=new int[g.getVertex()];
        boolean[] visited=new boolean[g.getVertex()];
        Arrays.fill(distance,0);
        Arrays.fill(visited,false);
        visited[startNode]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(startNode);
        while(!q.isEmpty())
        {
           int vertex=q.poll();
            List<Integer> children=g.getParentChildMap().get(vertex);
            for(Integer node:children)
            {
                if(!visited[node])
                {
                    distance[node]=distance[vertex]+1;
                    q.add(node);
                    visited[node]=true;
                }
            }
        }

        return distance;


    }


}
