package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//public class Main {
public class _1987_알파벳 {

    private static int r, c, answer;
    private static char[][] board;
    private static final boolean[] check = new boolean['Z' - 'A' + 1];
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    private void print(int d) {
        System.out.println(d);
        System.out.println(Arrays.toString(check));
        for (char[] chars : board) {
            System.out.println(chars);
        }
        System.out.println();
        System.out.println();
    }

    private void dfs(int d, int x, int y) {
        answer = Math.max(answer, d + 1);

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < c && ny >= 0 && ny < r) {
                if (!check[board[ny][nx] - 'A']) {
                    check[board[ny][nx] - 'A'] = true;
                    dfs(d + 1, nx, ny);
                    check[board[ny][nx] - 'A'] = false;
                }
            }
        }
    }

    private void solution() {
        int x = 0;
        int y = 0;
        check[board[y][x] - 'A'] = true;
        dfs(0, x, y);
        System.out.println(answer);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _1987_알파벳 T = new _1987_알파벳();
        FileInputStream fileInputStream = new FileInputStream("./baekjoon/_1987_알파벳.txt");
        Scanner kb = new Scanner(fileInputStream);

        r = kb.nextInt(); // board
        c = kb.nextInt(); // 알파벳종류
        board = new char[r][c];
        kb.nextLine();
        for (int y = 0; y < r; y++) {
            int x = 0;
            for (char c : kb.nextLine().toCharArray()) {
                board[y][x] = c;
                x++;
            }
        }

        T.solution();
    }
}
