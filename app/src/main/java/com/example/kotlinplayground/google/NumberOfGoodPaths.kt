package com.example.kotlinplayground.google

import java.util.LinkedList
import java.util.Queue

/**
 * 2421. Number of Good Paths
 * https://leetcode.com/problems/number-of-good-paths/
 */
class NumberOfGoodPaths {

    /**
     * Union find implementation
     *
     *
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
    int N = vals.length;
    ArrayList<Integer>[] adj = new ArrayList[N];
    TreeMap<Integer, ArrayList<Integer>> sameValues = new TreeMap<>();
    int ans = 0;

    for(int i=0; i<N; i++) {
    adj[i] = new ArrayList<>();

    if(!sameValues.containsKey(vals[i])) sameValues.put(vals[i], new ArrayList<>());
    sameValues.get(vals[i]).add(i);
    }

    for(int[] e : edges) {
    int u = e[0];
    int v = e[1];

    if(vals[u] >= vals[v]) {
    adj[u].add(v);
    } else {
    adj[v].add(u);
    }
    }

    UF uf = new UF(N);

    for(int val : sameValues.entrySet()) {
    for(int u : sameValues.get(val)) {
    for(int v : adj[u]) {
    uf.union(u, v);
    }
    }

    HashMap<Integer, Integer> group = new HashMap<>();

    for(int u : sameValues.get(val)) {
    group.put(uf.find(u), group.getOrDefault(uf.find(u), 0) + 1);
    }

    ans += sameValues.get(val).size();

    for(int key : group.keySet()) {
    int size = group.get(key);
    ans += size * (size-1) / 2;
    }
    }

    return ans;

    }

    class UF {

    int[] parent;

    public UF(int len) {
    parent = new int[len];
    Arrays.fill(parent, -1);
    }

    public int find(int a) {
    if(parent[a] >= 0) {
    return parent[a] = find(parent[a]);
    }
    return a;
    }

    public boolean union(int a, int b) {
    int pa = find(a);
    int pb = find(b);

    if(pa == pb) return false;

    if(parent[pa] <= parent[pb]) {
    parent[pa] += parent[pb];
    parent[pb] = pa;
    } else {
    parent[pb] += parent[pa];
    parent[pa] = pb;
    }

    return true;
    }
    }
     *
     */

    /**
     * Solution:
     * Using BFS or DFS to consist all possible paths
     *
     * Count the number of ood paths
     *
     * Maintain the property of:
     * StartPoint.index > EndPoint.index
     * to avoid duplication
     */
    fun numberOfGoodPaths(vals: IntArray, edges: Array<IntArray>): Int {
        // Initialization
        val size = vals.size
        val nodes: Array<Node> = Array(size) { index ->
            Node(index, LinkedList())
        }

        for (edge in edges) {
            nodes[edge[0]].adjacent.add(edge[1])
            nodes[edge[1]].adjacent.add(edge[0])
        }

        var count = 0
        // BFS, search for all path started from a node, length > 1
        for (i in 0 until size) {
            // Target value to form a good path
            val goodValue = vals[i]

            val checked = HashSet<Int>()
            val visitedNodes: Queue<Node> = LinkedList()
            visitedNodes.offer(nodes[i])

            while (visitedNodes.isNotEmpty()) {
                val currentNode = visitedNodes.poll()!!
                if (vals[currentNode.index] > goodValue) {
                    // Cannot be a good path, do nothing
                } else {
                    if (vals[currentNode.index] == goodValue && currentNode.index >= i) {
                        count++
                    }
                    for (n in currentNode.adjacent) {
                        if (!checked.contains(n)) {
                            visitedNodes.offer(nodes[n])
                        }
                    }
                }
                checked.add(currentNode.index)
            }
        }

        return count
    }

    private data class Node(
        val index: Int,
        val adjacent: LinkedList<Int>
    )
}