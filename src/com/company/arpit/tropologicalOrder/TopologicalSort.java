package com.company.arpit.tropologicalOrder;
/*
 * Topological Sort of a directed graph (a graph with unidirectional edges)
 * is a linear ordering of its vertices such that for every directed edge (U, V)
 * from vertex U to vertex V, U comes before V in the ordering.
 *Given a directed graph, find the topological ordering of its vertices.
 * */

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        /*
        * Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
        Output: Following are the two valid topological sorts for the given graph:
        1) 3, 2, 0, 1
        2) 3, 2, 1, 0
        * */


        int[][] edges = {{3, 2}, {3, 0}, {2, 0}, {2, 1}};
        int vertex = 4;

        List<Integer> path = findTropologicalSort(edges, vertex);

        System.out.println(path);


    }

    private static List<Integer> findTropologicalSort(int[][] edges, int vertex) {

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        List<Integer> sortedOrder = new ArrayList<>();

        for (int i = 0; i < vertex; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];

            inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
            graph.getOrDefault(parent, new ArrayList<Integer>()).add(child);


        }

        Queue<Integer> sourceQueue = new LinkedList<>();
        for (Integer parent : inDegree.keySet()) {
            if (inDegree.get(parent) == 0) {
                sourceQueue.add(parent);
            }
        }
        while (!sourceQueue.isEmpty()) {

            int source = sourceQueue.poll();
            sortedOrder.add(source);
            List<Integer> childrens = graph.get(source);

            for (Integer child : childrens) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sourceQueue.add(child);
                }


            }


        }
        if (sortedOrder.size() != vertex)
            return new ArrayList<>();


        return sortedOrder;
    }


}
