package org.example;

import java.util.*;

public class GravityAndLifts {
    static int N, M;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int startRow = sc.nextInt();
        int startCol = sc.nextInt();
        int destRow = sc.nextInt();
        int destCol = sc.nextInt();
        int result = bfs(startRow, startCol, destRow, destCol);
        if (result == -1) {
            System.out.println("Impossible");
        } else {
            System.out.println(result);
        }
    }

    public static int bfs(int startRow, int startCol, int destRow, int destCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, 0, 0});
        visited[startRow][startCol] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1], steps = current[2], liftsUsed = current[3];
            if (r == destRow && c == destCol) {
                return steps + liftsUsed;
            }
            if (r + 1 < N && grid[r + 1][c] == 0 && !visited[r + 1][c]) {
                int newRow = gravityFall(r, c);
                if (!visited[newRow][c]) {
                    visited[newRow][c] = true;
                    queue.offer(new int[]{newRow, c, steps + 1, liftsUsed});
                }
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                    if (grid[nr][nc] == 0 || grid[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        if (i != 3) {
                            queue.offer(new int[]{nr, nc, steps + 1, liftsUsed});
                        } else {
                            if (grid[nr][nc] == 1) {
                                queue.offer(new int[]{nr, nc, steps + 1, liftsUsed + 1});
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static int gravityFall(int r, int c) {
        while (r + 1 < N && grid[r + 1][c] == 0) {
            r++;
        }
        return r;
    }
}
