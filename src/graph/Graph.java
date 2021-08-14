package graph;

import java.util.*;

public class Graph {
    Map<Integer, List<Integer>> parentChild;
    int vertex;
    int[][] edges;

    //AdjacentList
    public Graph(int vertex) {
        this.vertex = vertex;
        parentChild = new HashMap<>();
        for (int i = 0; i < vertex; i++)
            parentChild.put(i, new ArrayList<>());
    }

    //AdjacentMatrix
    public Graph(int vertex, int[][] input) {
        this.vertex = vertex;
        edges = new int[vertex][vertex];
        for (int i = 0; i < input.length; i++) {
            edges[input[i][0]][input[i][1]] = 1;

        }
    }

    public int[][] getEdges() {
        return edges;
    }

    public void setEdges(int[][] edges) {
        this.edges = edges;
    }

    public Map<Integer, List<Integer>> getParentChild() {
        return parentChild;
    }

    public void setParentChild(Map<Integer, List<Integer>> parentChild) {
        this.parentChild = parentChild;
    }

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public static void printAdjacentMatrix(Graph g) {
        int[][] edges = g.getEdges();
        for (int row = 0; row < edges.length; row++) {
            for (int col = 0; col < edges[0].length; col++) {
                System.out.print(edges[row][col]);
            }
            System.out.println();
        }
    }



    public void addEdges(int source, int destination) {
        parentChild.get(source).add(destination);
    }

    public static void printAdjacentList(Graph g) {
        Map<Integer, List<Integer>> edges = g.getParentChild();

        for (Map.Entry<Integer, List<Integer>> entrySet : edges.entrySet()) {
            System.out.println("Parent: " + entrySet.getKey() + " Childs: " + entrySet.getValue());
        }

    }

    public static void bfs(Graph g, int startVertex, int destination) {
        boolean[] visited = new boolean[g.getVertex()];
        int[] parent = new int[g.getVertex()];
        int[] distance = new int[g.getVertex()];

        Queue<Integer> q = new LinkedList<>();
        q.add(startVertex);
        visited[startVertex] = true;
        parent[startVertex] = startVertex;
        distance[startVertex] = 0;

        while (!q.isEmpty()) {
            int vertex = q.poll();
            System.out.print(vertex + "-->");
            List<Integer> childs = g.getParentChild().get(vertex);

            for (Integer node : childs) {

                if (!visited[node]) {
                    q.add(node);
                    visited[node] = true;
                    parent[node] = vertex;
                    distance[node] = distance[vertex] + 1;
                }


            }


        }

        for (int i = 0; i < distance.length; i++) {
            System.out.println("Min Distance from Source Node " + startVertex + " to vertex " + i + "= " + distance[i]);
        }
       System.out.println("Path from Source "+ startVertex+" to destination "+destination);
        int temp = destination;
        while (temp != startVertex) {
            System.out.print(temp + "-->");
            temp = parent[temp];

        }
        System.out.print(startVertex);


    }


}
