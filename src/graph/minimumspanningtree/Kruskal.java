package graph.minimumspanningtree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Kruskal {

    static class DSU{
        int[] parent, rank;

        public DSU(int n){
            parent = new int[n];
            rank = new int[n];

            //parent -1, rank = 1
            for(int i=0;i<n;i++){
                parent[i] = -1;
                rank[i] = 1;
            }
        }

        int find(int i){
            //base case
            if(parent[i]==-1){
                return i;
            }
            //otherwise
            return parent[i] = find(parent[i]);
        }

        void unite(int x,int y){
            int s1 = find(x);
            int s2 = find(y);

            if(s1!=s2){
                //union by rank
                if(rank[s1]<rank[s2]){
                    parent[s1] = s2;
                    rank[s2] += rank[s1];
                }
                else{
                    parent[s2] = s1;
                    rank[s1] += rank[s2];
                }
            }
        }


    }
    static class Edge
    {
        private int first;
        private int second;
        private int weight;
        public Edge(int x,int y,int w)
        {
            this.first=x;
            this.second=y;
            this.weight=w;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        public int getWeight() {
            return weight;
        }
    }


    static class Graph{
        List<Edge> edgeList;
        int V;

        public Graph(int V) {
            this.V = V;
            edgeList = new ArrayList<>();
        }

        void addEdge(int x,int y,int w){
            Edge edge=new Edge(x,y,w);
            edgeList.add(edge);
        }

        int kruskal_mst(){
            //Main Logic = Easy!!!
            //1. Sort all the edges based upon weight
            edgeList.sort(new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return o1.getWeight() - o2.getWeight();
                }
            });

            //Init a DSU
            DSU s = new DSU(V);

            int ans = 0;
            for(Edge edge : edgeList){

                int w = edge.getWeight();
                int x = edge.getFirst();
                int y = edge.getSecond();

                //take that edge in MST if it doesnt form a cycle
                if(s.find(x)!=s.find(y)){
                    s.unite(x,y);
                    ans += w;
                }

            }
            return ans;
        }


    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(),m = scn.nextInt();


        Graph g =  new Graph(n);
        for(int i=0;i<m;i++){
            int x = scn.nextInt(),y= scn.nextInt(),w= scn.nextInt();

            g.addEdge(x-1,y-1,w);
        }

        System.out.println(g.kruskal_mst());
    }

}

