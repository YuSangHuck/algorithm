package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//public class Main {
public class _2667_단지번호붙이기 {
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

    private static void solution(int n, int[][] board) {
        int count = 0;
        PriorityQueue<Integer> areas = new PriorityQueue<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (board[y][x] == 1) {
                    Queue<Point> q = new LinkedList<>();
                    board[y][x] = 2;
                    int area = 1;
                    q.offer(new Point(x, y));
                    while (!q.isEmpty()) {
                        Point cur = q.poll();
                        for (int i = 0; i < dx.length; i++) {
                            int nx = dx[i] + cur.x;
                            int ny = dy[i] + cur.y;
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[ny][nx] == 1) {
                                board[ny][nx] = 2;
                                area++;
                                q.offer(new Point(nx, ny));
                            }
                        }

                    }
                    areas.add(area);
                    count++;
                }
            }
        }
        StringBuilder answer = new StringBuilder(count + "\n");
        while (!areas.isEmpty()) {
            int poll = areas.poll();
            answer.append(poll).append("\n");
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream("./baekjoon/_2667_단지번호붙이기.txt");
        Scanner kb = new Scanner(fileInputStream);

        int n = kb.nextInt();
        int[][] board = new int[n][n]; // 0초기화, 왼쪽아래ld가 (0,0), 오른쪽위ru가 (n,m)
        for (int y = 0; y < n; y++) {
            String next = kb.next();
            int x = 0;
            for (char c : next.toCharArray()) {
                board[y][x] = c - '0';
                x++;
            }
        }

        solution(n, board);
    }
}
