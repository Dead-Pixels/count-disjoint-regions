package com.mundeeppurewal.main;

public class PatternFinder {
    boolean[][] visitedMap;

    public PatternFinder() {
    }

    public int findGroup(int[][] grid) {
        this.visitedMap = new boolean[grid.length][grid.length];
        int groupCount = 0;
        if (grid == null) {
            throw new NullPointerException();
        } else {
            for(int x = 0; x < grid.length; ++x) {
                for(int y = 0; y < grid.length; ++y) {
                    if (grid[x][y] != 0) {
                        boolean isAlreadyVisited = this.visitedMap[x][y];
                        boolean containsNonZero = grid[x][y] != 0;
                        if (!isAlreadyVisited && containsNonZero) {
                            this.findAllCellsNear(grid, x, y);
                            ++groupCount;
                        }
                    }
                }
            }

            return groupCount;
        }
    }

    public void findAllCellsNear(int[][] grid, int x, int y) {
        this.visitedMap[x][y] = true;
        int ROW_MAX_LENGTH = grid.length - 1;
        int COLUMN_MAX_LENGTH = grid.length - 1;
        int rightOfCurrentX = x + 1;
        if (rightOfCurrentX <= ROW_MAX_LENGTH && grid[rightOfCurrentX][y] != 0 && !this.visitedMap[rightOfCurrentX][y]) {
            this.findAllCellsNear(grid, rightOfCurrentX, y);
        }

        int belowOfCurrentY = y + 1;
        if (belowOfCurrentY <= COLUMN_MAX_LENGTH && grid[x][belowOfCurrentY] != 0 && !this.visitedMap[x][belowOfCurrentY]) {
            this.findAllCellsNear(grid, x, belowOfCurrentY);
        }

        int leftOfCurrentX = x - 1;
        if (leftOfCurrentX >= 0 && grid[leftOfCurrentX][y] != 0 && !this.visitedMap[leftOfCurrentX][y]) {
            this.findAllCellsNear(grid, leftOfCurrentX, y);
        }

        int aboveOfCurrentY = y - 1;
        if (aboveOfCurrentY >= 0 && grid[x][aboveOfCurrentY] != 0 && !this.visitedMap[x][aboveOfCurrentY]) {
            this.findAllCellsNear(grid, x, aboveOfCurrentY);
        }

    }
}
