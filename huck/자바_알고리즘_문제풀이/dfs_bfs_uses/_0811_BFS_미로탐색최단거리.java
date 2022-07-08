//https://cote.inflearn.com/contest/10/problem/08-11
package huck.자바_알고리즘_문제풀이.dfs_bfs_uses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//public class Main {
public class _0811_BFS_미로탐색최단거리 {
    static int size, answer;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    static class Pair {
        private final int x, y, depth;

        public Pair(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    private void BFS(int x, int y) {
        Queue<Pair> q = new LinkedList<>();

        board[x][y] = 1;
        q.offer(new Pair(1, 1, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (board[ny][nx] == 0) {
                    if (nx == 7 && ny == 7) {
                        answer = p.depth + 1;
                        return;
                    }

                    board[ny][nx] = 1;
                    q.offer(new Pair(nx, ny, p.depth + 1));
                }
            }
        }
        if (answer == 0) {
            answer = -1;
        }

    }

    private void solution() {
        BFS(1, 1);
        System.out.println(answer);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0811_BFS_미로탐색최단거리 T = new _0811_BFS_미로탐색최단거리();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/dfs_bfs_uses/_0811_BFS_미로탐색최단거리.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);

        size = 7;

        board = new int[2 + size][2 + size];
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < size + 1; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        for (int i = 0; i < 2 + size; i++) {
            board[0][i] = -1;
            board[size + 1][i] = -1;
            board[i][0] = -1;
            board[i][size + 1] = -1;
        }
        T.solution();
    }
}
