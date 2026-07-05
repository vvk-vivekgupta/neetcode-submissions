class Solution {
    public boolean validTree(int n, int[][] edges) {
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
        boolean res = true;
        for (int i = 0; i <= maxLength; i++) {
            if (nodes[i] == null) {
                continue;
            }

            res = isValid(nodes[i], null, traversed);
            break;
        }

        return res && (traversed.size() == n || n == 1);
    }

    private boolean isValid(TreeNode node, TreeNode parent, Set<Integer> traversed) {
        if (traversed.contains(node.val)) {
            return false;
        }

        traversed.add(node.val);
        boolean res = true;
        for (TreeNode c : node.neighbour) {
            if (c == parent) {
                continue;
            }
            res = res && isValid(c, node, traversed);
        }

        return res;
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
