package graph;

import java.util.ArrayList;
import java.util.List;

class Edge
{
    int first;
    int second;
    public Edge(int i,int j)
    {
        this.first=i;
        this.second=j;
    }
}

class EdgeGraph
{
    int vertex;
    List<Edge> edgeList=new ArrayList<>();

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    public EdgeGraph(int v)
    {
        this.vertex=v;
    }
    public void addEdges(int first,int second)
    {
        Edge e1=new Edge(first,second);
        this.edgeList.add(e1);
    }
}

public class DSU {

    public static void main(String[] args) {
       DSU dsu=new DSU();
        EdgeGraph g=new EdgeGraph(5);
        g.addEdges(0,1);
        g.addEdges(1,2);
        g.addEdges(2,3);
        g.addEdges(3,4);
        System.out.print(dsu.findCycle(g));
    }

    //FIND
    public int find(int i,int[] parent)
    {
        if(parent[i]==-1)
        {
            return i;
        }
        // Path compression making node directly connect to parent
        return parent[i]=find(parent[i],parent);
    }

    //UNION
    public void union(int x,int y,int[] parent,int[] rank)
    {
        int s1=find(x,parent);
        int s2=find(y,parent);

        if(s1!=s2)
        {
            // Union by rank , rank of root will be number of elements in set
            if(rank[s1]>=rank[s2])
            {
                parent[s2]=s1;
                rank[s1]+=rank[s2];
            }
            else
            {
                parent[s1]=s2;
                rank[s2]+=rank[s1];
            }
        }


    }

    public boolean findCycle(EdgeGraph g)
    {
        int[] parent=new int[g.getVertex()];
        int[] rank=new int[g.getVertex()];
        for(int i=0;i<parent.length;i++)
        {
            parent[i]=-1;
            rank[i]=1;
        }
        List<Edge> edgeList=g.getEdgeList();
        for(Edge e:edgeList)
        {
            int first=e.first;
            int second=e.second;

            int s1=find(first,parent);
            int s2=find(second,parent);
            if(s1!=s2)
            {
                union(first,second,parent,rank);
            }
            else
            {
                return true ;
            }
        }
        return false;


    }



}
