package com.mundeeppurewal.test;

import com.mundeeppurewal.main.PatternFinder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PatternFinderTest {
    PatternFinder patternFinder;

    public PatternFinderTest() {
    }

    @Before
    public void setUp() throws Exception {
        this.patternFinder = new PatternFinder();
    }

    @Test
    public void findGroup() {
    }

    @Test
    public void findAllCellsNear_emptyGrid() {
        int[][] grid = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        Assert.assertEquals(0L, (long)this.patternFinder.findGroup(grid));
    }

    @Test
    public void findAllCellsNear_fullGrid() {
        int[][] grid = new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        Assert.assertEquals(1L, (long)this.patternFinder.findGroup(grid));
    }

    @Test
    public void findAllCellsNear_alternatingGrid() {
        int[][] grid = new int[][]{{0, 1, 0, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 1, 0}};
        Assert.assertEquals(8L, (long)this.patternFinder.findGroup(grid));
    }

    @Test
    public void findAllCellsNear_NegativeAndPositiveNumbers() {
        int[][] grid = new int[][]{{1, -34, 0, -82}, {0, 0, 654, 0}, {234, 0, 0, 999}, {-1222, 0, 10, 87}};
        Assert.assertEquals(5L, (long)this.patternFinder.findGroup(grid));
    }

    @Test
    public void findAllCellsNear_MinMaxPossibleNumbers() {
        int min = -2147483648;
        int max = 2147483647;
        System.out.println(min + " " + max);
        int[][] grid = new int[][]{{0, 0, 0, 0}, {0, min, min, 0}, {0, 0, 0, 0}, {0, max, max, 0}};
        Assert.assertEquals(2L, (long)this.patternFinder.findGroup(grid));
    }

    @Test(
            expected = NullPointerException.class
    )
    public void findAllCellsNear_NullGrid() {
        this.patternFinder.findGroup((int[][])null);
        Assert.fail("NullPointerException should have been thrown...");
    }

    @Test
    public void findAllCellsNear_SixBySixGrid() {
        int[][] grid = new int[][]{{0, 0, 1, 1, 0, 1}, {0, 0, 0, 0, 0, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 0, 0}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 0}};
        Assert.assertEquals(4L, (long)this.patternFinder.findGroup(grid));
    }

    @Test
    public void findAllCellsNear_ThreeByThreeGrid() {
        int[][] grid = new int[][]{{0, 0, 1}, {0, 0, 0}, {1, 0, 0}};
        Assert.assertEquals(2L, (long)this.patternFinder.findGroup(grid));
    }
}
