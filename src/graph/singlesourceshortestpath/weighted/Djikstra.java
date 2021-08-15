package graph.singlesourceshortestpath.weighted;

import java.util.*;

class Pair implements Comparable<Pair> {
    int weight, vertex;

    Pair(int a, int b) {
        this.weight = a;
        this.vertex = b;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.weight != o.weight)
            return this.weight - o.weight;
        return this.vertex - o.vertex;
    }
}


class Graph1 {

    int V;
    Map<Integer, List<Pair>> parentChildMap = new HashMap<>();


    public Graph1(int v) {
        this.V = v;

        for (int i = 0; i < V; i++) {
            parentChildMap.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int wt, boolean undir) {

        parentChildMap.get(u).add(new Pair(wt, v));
        if (undir) {
            parentChildMap.get(v).add(new Pair(wt, u));
        }
    }
}

public class Djikstra {


    public static int dijkstra(Graph1 g,int src, int dest) {

        //Data Structures
        int[] dist = new int[g.V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        SortedSet<Pair> s = new TreeSet<>();

        //1. Init
        dist[src] = 0;
        s.add(new Pair(0, src));

            while(!s.isEmpty()){

                Pair it = s.first();
                int node = it.vertex;
                int distTillNow = it.weight;
                s.remove(it); //Pop

                //Iterate over the nbrs of node
                for(Pair nbrPair : g.parentChildMap.get(node)){
                    //......

                    int nbr = nbrPair.vertex;
                    int currentEdge = nbrPair.weight;

                    if(distTillNow + currentEdge < dist[nbr]){
                        //remove if nbr already exist in the set

                        s.remove(new Pair(dist[nbr], nbr));


                        //insert the updated value with the new dist
                        dist[nbr] = distTillNow + currentEdge;
                        s.add(new Pair(dist[nbr],nbr));

                    }

                }

            }
            //Single Source Shortest Dist to all other nodes
            for(int i=0;i<g.V;i++){
                System.out.println("Node i "+i +" Dist "+dist[i]);
            }
            return dist[dest];

        }


    public  static void main(String[] args){

        Graph1 g = new Graph1(5);
        g.addEdge(0,1,1, true);
        g.addEdge(1,2,1, true);
        g.addEdge(0,2,4, true);
        g.addEdge(0,3,7, true);
        g.addEdge(3,2,2, true);
        g.addEdge(3,4,3, true);

        System.out.println( Djikstra.dijkstra(g,0,4));
    }
}
