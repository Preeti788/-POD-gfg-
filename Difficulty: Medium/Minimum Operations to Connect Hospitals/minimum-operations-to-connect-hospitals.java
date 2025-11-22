class Solution {
        // code here
    int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    void union(int[] parent, int[] rank, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);

        if (pa == pb) return;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else if (rank[pb] < rank[pa]) {
            parent[pb] = pa;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }

    public int minConnect(int V, int[][] edges) {

        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int i = 0; i < V; i++)
            parent[i] = i;

        int extraEdges = 0;

    
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            int pu = find(parent, u);
            int pv = find(parent, v);

            if (pu == pv) {
                extraEdges++; // cycle => this
            } else {
                union(parent, rank, pu, pv);
            }
        }

        int components = 0;
        for (int i = 0; i < V; i++) {
            if (find(parent, i) == i)
                components++;
        }

        int required = components - 1;

        if (extraEdges >= required)
            return required;

        return -1;
    }
}

