package com.kulak.codwars;

public class Spiralizor {

    public static int[][] spiralize(int size) {
        int[][] result = new int[size][size];
        int n = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = 1;
            }
        }
        boolean direction = false;
        int j = 1;
        for (int i = 1; i < size; i++) {
            if (!direction) {
                lineX(result, i, i + n - 1, j);
                direction = true;
            } else {
                lineY(result, i, i + n - 1, n - j);
            }
        }
        return result;
    }

    public static void lineY(int a[][], int x0, int x1, int y) {
        for (int i = x0; i < x1; i++) {
            a[i][y] = 0;
        }
    }

    public static void lineX(int a[][], int y0, int y1, int x) {
        for (int i = y0; i < y1; i++) {
            a[x][i] = 0;
        }
    }

}
