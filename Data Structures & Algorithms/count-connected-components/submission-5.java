class Solution {
    public int countComponents(int n, int[][] edges) {
        int edgeCount = edges.length;
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int cnt = n;
        for (int[] e : edges) {
            cnt -= merge(parent, rank, e[0], e[1]);
            print(parent);
        }

        //print(parent);

        return cnt;
    }

    private int findParent(int[] parent, int n) {
        int i = n;

        while (parent[i] != i) {
            i = parent[i];
        }

        return i;
    }

    private int merge(int[] parent, int[] rank, int x, int y) {
        int p1 = findParent(parent, x);
        int p2 = findParent(parent, y);

        if (p1 == p2) {
            return 0;
        }

        if (rank[p1] >= rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        return 1;
    }

    private void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }
}
// 0,1,2,3,4,5
// 0,0,0,0,4,4
