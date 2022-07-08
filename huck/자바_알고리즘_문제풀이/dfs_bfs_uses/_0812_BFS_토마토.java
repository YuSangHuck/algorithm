//https://cote.inflearn.com/contest/10/problem/08-12
package huck.자바_알고리즘_문제풀이.dfs_bfs_uses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//public class Main {
public class _0812_BFS_토마토 {
    private static boolean flag = true;
    private static int n, m;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static int[][] board;
    static Queue<Point> q = new LinkedList<>();

    static class Point {
        private final int x, y, depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    private int BFS() {
        int days = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            days = p.depth;

            for (int i = 0; i < dx.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int ndepth = p.depth + 1;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[ny][nx] == 0) {
                    board[ny][nx] = 1;
                    q.offer(new Point(nx, ny, ndepth));
                }
            }
        }
        return days;
    }

    private int solution() {
        int days = 0;
//        0.flag 체크(전부 익은토마토인지)
        if (flag) {
            return days;
        }
//        1.토마토 익는과정 시뮬 bfs
        days = BFS();
//        2.토마토 상태 검사. 날짜 or -1

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (board[y][x] == 0) {
                    days = -1;
                    return days;
                }
            }
        }
        return days;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0812_BFS_토마토 T = new _0812_BFS_토마토();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/dfs_bfs_uses/_0812_BFS_토마토.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        board = new int[m][n];
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                int status = kb.nextInt();
                board[y][x] = status; // -1,0,1
                if (status == 1) {
                    q.offer(new Point(x, y, 0));
                } else if (status == 0) {
                    flag = false;
                }
            }
        }
        System.out.println(T.solution());
    }
}
