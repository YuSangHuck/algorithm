package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//public class Main {
public class _2580_스도쿠 {

    private static final int SUDOKU_SIZE = 9;
    private static final int[][] board = new int[SUDOKU_SIZE][SUDOKU_SIZE];
    static final ArrayList<Point> l = new ArrayList<>();
    private boolean flag;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    void print() {
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private boolean check(Point point, int i) {
//        row
        for (int x = 0; x < SUDOKU_SIZE; x++) {
            if (board[point.y][x] == i) {
                return false;
            }
        }
//        col
        for (int y = 0; y < SUDOKU_SIZE; y++) {
            if (board[y][point.x] == i) {
                return false;
            }
        }
//        sub-square
        int sy = 3 * (point.y / 3); // 1 => 0 1 2
        int sx = 3 * (point.x / 3); // 4 => 3 4 5
        for (int y = sy; y < sy + 3; y++) {
            for (int x = sx; x < sx + 3; x++) {
                if (board[y][x] == i) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(int d) { // depth는 d이고, l.get(d)를 검사한다
        if (flag) {
            return;
        }
        if (d == l.size()) {
            flag = true;
            return; // 전부 종료
        }

        Point point = l.get(d);
        for (int i = 1; i <= 9; i++) {
            if (check(point, i)) {
                board[point.y][point.x] = i;
                dfs(d + 1);
                if (flag) {
                    return;
                }
                board[point.y][point.x] = 0; // 무조건 0
            }
        }
    }

    private void solution() {
        int d = 0;
        dfs(d);
        print();
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _2580_스도쿠 T = new _2580_스도쿠();
        FileInputStream fileInputStream = new FileInputStream("./baekjoon/_2580_스도쿠.txt");
        Scanner kb = new Scanner(fileInputStream);

        for (int y = 0; y < SUDOKU_SIZE; y++) {
            for (int x = 0; x < SUDOKU_SIZE; x++) {
                int v = kb.nextInt();
                board[y][x] = v;
                if (v == 0) {
                    l.add(new Point(x, y));
                }
            }
        }

        T.solution();
    }
}
