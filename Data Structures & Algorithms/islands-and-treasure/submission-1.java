class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Location> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new Location(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            Location loc = queue.poll();
            if (loc.val != 0 && grid[loc.X][loc.Y] <= loc.val) {
                continue;
            }

            grid[loc.X][loc.Y] = loc.val;

            if (loc.X-1 >= 0 && grid[loc.X-1][loc.Y] != -1 && grid[loc.X-1][loc.Y] != 0) {
                queue.add(new Location(loc.X-1, loc.Y, loc.val+1));
            }

            if (loc.X+1 < m && grid[loc.X+1][loc.Y] != -1 && grid[loc.X+1][loc.Y] != 0) {
                queue.add(new Location(loc.X+1, loc.Y, loc.val+1));
            }

            if (loc.Y-1 >= 0 && grid[loc.X][loc.Y-1] != -1 && grid[loc.X][loc.Y-1] != 0) {
                queue.add(new Location(loc.X, loc.Y-1, loc.val+1));
            }

            if (loc.Y+1 < n && grid[loc.X][loc.Y+1] != -1 && grid[loc.X][loc.Y+1] != 0) {
                queue.add(new Location(loc.X, loc.Y+1, loc.val+1));
            }
        }
    }

    private class Location {
        int X;
        int Y;
        int val;

        Location(int x, int y, int val) {
            this.X = x;
            this.Y = y;
            this.val = val;
        }
    }
}
