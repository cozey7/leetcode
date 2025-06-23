// 695. Max Area of Island - 06.11.2025

class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(findArea(grid, i, j), maxArea);
                }
                
            }
        }

        return maxArea;
    }

    private int findArea(int[][] grid, int row, int col) {
        if(row < 0 || col < 0) return 0;
        if(row >= grid.length || col >= grid[0].length) return 0;
        if(grid[row][col] <= 0) return 0;

        grid[row][col] = -1;

        return findArea(grid, row+1, col) + findArea(grid, row-1, col) + 
            findArea(grid, row, col+1) + findArea(grid, row, col-1) + 1;
    }
}