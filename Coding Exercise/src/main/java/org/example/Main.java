package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
    int ans = 0;
    int next;
    boolean[] seen;

    public int longestDirectedPath(List<Edge> edges, int selectedVertex) {
        int n = edges.size();
        Map<Long, Integer> vertexMap = new HashMap<>();
        int index = 1;

        for (Edge edge : edges) {
            if (!vertexMap.containsKey(edge.from.id)) {
                vertexMap.put(edge.from.id, index++);
            }
            if (!vertexMap.containsKey(edge.to.id)) {
                vertexMap.put(edge.to.id, index++);
            }
        }

        int VertexMapSize = vertexMap.size();
        seen = new boolean[VertexMapSize + 1]; //array to mark Vertex as visited

        List<Integer>[] graph = new List[VertexMapSize + 1];

        for (int i = 1; i <= VertexMapSize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (Edge edge : edges) {
            int u = vertexMap.get(edge.from.id);
            int v = vertexMap.get(edge.to.id);
            graph[u].add(v);
            //tree[v].add(u);
        }

        System.out.println("Vertex Mapping:");
        for (int i = 1; i < graph.length; i++) {
            System.out.print("Vertex - " + i + ": ");
            for (int j : graph[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        next = selectedVertex;//vertexIndexMap.get(edges.get(0).from.id);
        dfs(graph, next, 0);
        seen = new boolean[VertexMapSize + 1];
        dfs(graph, next, 0);
        return ans;
    }

    void dfs(List<Integer>[] tree, int u, int t) {
        if (seen[u]) {
            return;
        }
        seen[u] = true;

        if (ans < t) {
            ans = t;
            next = u;
        }

        for (int v : tree[u]) {
            dfs(tree, v, t + 1);
        }
    }

    public static void main(String[] args) {
        // Example usage
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(v1, v2));
        //edges.add(new Edge(v3, v3));
        edges.add(new Edge(v3, v4));
        //edges.add(new Edge(v4, v5));
        edges.add(new Edge(v4, v6));
        edges.add(new Edge(v6, v7));

        Main solution = new Main();
        System.out.println("Longest Path: " + solution.longestDirectedPath(edges, 3));
    }
}
