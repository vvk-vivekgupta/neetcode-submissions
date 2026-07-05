class Solution {
    public int countComponents(int n, int[][] edges) {
        int maxLength = n * (n-1) / 2;
        TreeNode[] nodes = new TreeNode[maxLength + 1];
        for (int[] e : edges) {
            if (nodes[e[0]] == null) {
                nodes[e[0]] = new TreeNode(e[0]);
            }

            if (nodes[e[1]] == null) {
                nodes[e[1]] = new TreeNode(e[1]);
            }

            nodes[e[0]].neighbour.add(nodes[e[1]]);
            nodes[e[1]].neighbour.add(nodes[e[0]]);
        }

        Set<Integer> traversed = new HashSet<>();
        int count = 0;
        for (int i = 0; i <= maxLength; i++) {
            if (nodes[i] == null || traversed.contains(nodes[i].val)) {
                continue;
            }

            traverse(nodes[i], null, traversed);
            count++;
        }

        return edges.length == 0 ? n : count;
    }

    private void traverse(TreeNode node, TreeNode parent, Set<Integer> traversed) {
        if (traversed.contains(node.val)) {
            return;
        }

        traversed.add(node.val);
        for (TreeNode c : node.neighbour) {
            if (c == parent) {
                continue;
            }
            traverse(c, node, traversed);
        }
    }

    private class TreeNode {
        int val;
        List<TreeNode> neighbour;

        TreeNode(int val) {
            this.val = val;
            this.neighbour = new ArrayList<>();
        }
    }
}
