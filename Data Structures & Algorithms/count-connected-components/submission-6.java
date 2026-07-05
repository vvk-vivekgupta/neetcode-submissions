class Solution {
    int[] parent;
    int[] rank;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        // Make each node the parent of its own
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1; 
        }

        // Initially consider all are disconnected
        int connected = n;

        for (var e : edges) {
            if (union(e[0], e[1]))
                connected--;
        }

        return connected;
    }

    private int find(int node) {
        int cur = node;

        while (cur != parent[cur]) {
            // Path compression
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }

        return cur;
    }

    private boolean union(int u, int v) {
        // Find parent of both nodes
        int parentU = find(u);
        int parentV = find(v);

        // They are already connected
        if (parentU == parentV) 
            return false;

        // Make parent the one which has higher rank
        // Smaller rank/size becomes the child
        if (rank[parentU] > rank[parentV]) {
            parent[parentV] = parentU;
            rank[parentU] += rank[parentV];
        } else {
            parent[parentU] = parentV;
            rank[parentV] += rank[parentU];
        }

        return true;
    }
}
