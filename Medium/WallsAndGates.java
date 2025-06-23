// 286. Walls and Gates (Islands and Treasure on Neetcode) - 06.22.25
import java.util.*;

class Solution {

    public final int INF = Integer.MAX_VALUE;

    class Point {
        int row;
        int col;
        int distance;

        public Point(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public void islandsAndTreasure(int[][] grid) {

        // Find all start nodes (treasure chest)
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    // run bfs
                    bfs(grid, i, j);
                }
            }
        }

    }

    // row and col for a treasure chest
    private void bfs(int[][] grid, int row, int col) {
        Queue<Point> q = new LinkedList<>();

        // Add all adj of treasure chest
        q.add(new Point(row-1, col, 1));
        q.add(new Point(row+1, col, 1));
        q.add(new Point(row, col-1, 1));
        q.add(new Point(row, col+1, 1));

        while(!q.isEmpty()) {
            Point p = q.poll();
            
            // Check if point is a land cell within the grid whose current dist is >
            if(0 <= p.row && p.row < grid.length && 
               0 <= p.col && p.col < grid[0].length &&
               grid[p.row][p.col] > 0 &&
               grid[p.row][p.col] > p.distance) {

                // Mark as visited + update distance
                grid[p.row][p.col] = p.distance;
                System.out.println(p.row + "," + p.col);

                // Add all adj to queue
                q.add(new Point(p.row-1, p.col, grid[p.row][p.col]+1));
                q.add(new Point(p.row+1, p.col, grid[p.row][p.col]+1));
                q.add(new Point(p.row, p.col-1, grid[p.row][p.col]+1));
                q.add(new Point(p.row, p.col+1, grid[p.row][p.col]+1));

            }
        }
    }
}
