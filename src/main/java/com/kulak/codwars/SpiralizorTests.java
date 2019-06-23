package com.kulak.codwars;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class SpiralizorTests {

    @Test
    public void test1() {
        assertArrayEquals(
                Spiralizor.spiralize(1),
                new int[][]{{1}});
    }

    @Test
    public void test2() {
        assertArrayEquals(
                Spiralizor.spiralize(2),
                new int[][]{
                        {1, 1},
                        {0, 1}
                });
    }

    @Test
    public void test3() {
        assertArrayEquals(
                Spiralizor.spiralize(3),
                new int[][]{
                        {1, 1, 1},
                        {0, 0, 1},
                        {1, 1, 1}
                });
    }

    @Test
    public void test5() {
        assertArrayEquals(
                Spiralizor.spiralize(5),
                new int[][]{
                        {1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 1},
                        {1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1}
                });
    }

    @Test
    public void test8() {
        assertArrayEquals(
                Spiralizor.spiralize(8),
                new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 0, 1, 0, 1},
                        {1, 0, 1, 1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1},
                });
    }

}