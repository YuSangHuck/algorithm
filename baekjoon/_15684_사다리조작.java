package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _15684_사다리조작 {

    private static int n, m, h, answer = Integer.MAX_VALUE; // 세로선개수, 가로선개수, 세로선마다 가로선을 놓을수 있는 위치 개수
    private static int[][] board;
    private boolean flag;

    private boolean go() { // go 내부에서 세로선 전부 loop
        for (int candidate = 1; candidate <= n; candidate++) {
            int x = candidate;
            int y = 1;
            while (y <= h) {
                if (board[y][x] == 1 && board[y][x + 1] == 2) {
                    x++;
                } else if (board[y][x] == 2 && board[y][x - 1] == 1) {
                    x--;
                }
                y++;
            }
            if (candidate != x) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int d) {
        if (flag) {
            return;
        }
        if (d == answer) {
            if (go()) {
                flag = true;
                return;
            }
            return;
        }

        for (int y = 1; y <= h; y++) {
            for (int x = 1; x + 1 <= n; x++) {
                if (board[y][x] == 0 && board[y][x + 1] == 0) {
                    board[y][x] = 1;
                    board[y][x + 1] = 2;
                    dfs(d + 1);
                    board[y][x] = 0;
                    board[y][x + 1] = 0;
                }
            }
        }

    }

    private void solution() {
//        i -> i를 위한 조작
//        추가될 가로선의 최소갯수
        for (int i = 0; i <= 3; i++) {
            // TODO answer를 전역으로 선언하고 0,1,2... 증가시키고, dfs내부에서 bfs처럼 종결조건으로 쓸 수 있음
            answer = i;
            dfs(0);
            if (flag) {
                break;
            }
        }
        System.out.println(flag ? answer : -1);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _15684_사다리조작 T = new _15684_사다리조작();
        FileInputStream fileInputStream = new FileInputStream("./baekjoon/_15684_사다리조작.txt");
        Scanner kb = new Scanner(fileInputStream);

        n = kb.nextInt();
        m = kb.nextInt();
        h = kb.nextInt();
        board = new int[h + 2][n + 2];
        for (int i = 0; i < m; i++) {
            int y = kb.nextInt(); // a
            int x = kb.nextInt(); // b, b+1
            board[y][x] = 1;
            board[y][x + 1] = 2;
        }
        T.solution();
    }
}
