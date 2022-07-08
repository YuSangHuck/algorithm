//https://cote.inflearn.com/contest/10/problem/08-13
package huck.자바_알고리즘_문제풀이.dfs_bfs_uses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0813_DFS_섬나라아일랜드 {
    private static int n;
    private static int[] dx={0,1,1,1,-1,-1,-1}, dy = {1, 1, 0, -1, -1, -1, 0, 1};
    private static int[][] board;

    private void DFS(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[ny][nx] == 1) {
                board[ny][nx] = 0;
                DFS(nx, ny);
            }
        }

    }

    private int solution() {
//        1.변수
//        dx,dy 8방향(대각선 포함)

//        loop(0~n-1, 0~n-1)
//            섬이면 count++, 해당지점x,y이면 DFS(x,y) // DFS는 x,y시점으로 연결된 섬을 0으로 바꿔버림
        int count = 0;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (board[y][x] == 1) {
                    count++;
                    board[y][x] = 0;
                    DFS(x, y);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0813_DFS_섬나라아일랜드 T = new _0813_DFS_섬나라아일랜드();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/dfs_bfs_uses/_0813_DFS_섬나라아일랜드.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        board = new int[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int status = kb.nextInt();
                board[y][x] = status; // 0,1
            }
        }
        System.out.println(T.solution());
    }
}
