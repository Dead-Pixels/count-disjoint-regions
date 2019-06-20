package com.mundeeppurewal.main;

public class Main {
    private static int[][] grid = new int[][]{{3, -1, 0, 0}, {1, 0, 0, 1}, {5, 0, 0, 0}, {9, 10, 0, 1}};

    public Main() {
    }

    public static void main(String[] args) {
        PatternFinder pF = new PatternFinder();
        System.out.println("-------------------------\nNumber of patterns " + pF.findGroup(grid));
    }
}
