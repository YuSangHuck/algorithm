//https://cote.inflearn.com/contest/10/problem/08-10
package huck.자바_알고리즘_문제풀이.dfs_bfs_uses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0810_DFS_미로탐색 {
    static int size, answer;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    private void DFS(int x, int y) {
        if (x == 7 && y == 7) {
            answer++;
            return;
        }
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (arr[ny][nx] == 0) {
                arr[ny][nx] = 1;
                DFS(nx, ny);
                arr[ny][nx] = 0;
            }
        }

    }

    private void solution() {
        arr[1][1] = 1;
        DFS(1, 1);
        System.out.println(answer);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0810_DFS_미로탐색 T = new _0810_DFS_미로탐색();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/dfs_bfs_uses/_0810_DFS_미로탐색.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);

        size = 7;

        arr = new int[2 + size][2 + size];
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < size + 1; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        for (int i = 0; i < 2 + size; i++) {
            arr[0][i] = -1;
            arr[size + 1][i] = -1;
            arr[i][0] = -1;
            arr[i][size + 1] = -1;
        }
        T.solution();
    }
}
