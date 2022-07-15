package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//public class Main {
public class _1987_알파벳 {

    private static int r, c;
    private static char[][] board;
    private static boolean[] check = new boolean['Z' + 1];
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    private static char get(int x, int y) {
        return board[y][x];
    }

    private static void set(int x, int y, char val) {
        board[y][x] = val;
    }

    class Point {
        int x, y, count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    '}';
        }
    }

    private void solution() {
        int answer = 0;
        Queue<Point> q = new LinkedList<>();
        check[board[0][0]] = true;
        q.offer(new Point(0, 0, 1));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            answer = cur.count;
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nc = cur.count + 1;
                if (nx >= 0 && nx < c && ny >= 0 && ny < r) {
                    if (!check[board[ny][nx]]) {
                        check[board[ny][nx]] = true;
                        q.offer(new Point(nx, ny, nc));
                    }
                }
            }
        }
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
                set(x, y, c);
                x++;
            }
        }

        T.solution();
    }
}
