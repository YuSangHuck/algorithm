package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//public class Main {
public class _2583_영역_구하기 {
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

    private static void solution(int n, int m, int k, int[][] board) {
        int count = 0;
        PriorityQueue<Integer> areas = new PriorityQueue<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (board[y][x] != 1) {
                    Queue<Point> q = new LinkedList<>();
                    board[y][x] = 1;
                    int area = 1;
                    q.offer(new Point(x, y));
                    while (!q.isEmpty()) {
                        Point cur = q.poll();
                        for (int i = 0; i < dx.length; i++) {
                            int nx = dx[i] + cur.x;
                            int ny = dy[i] + cur.y;
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[ny][nx] == 0) {
                                board[ny][nx] = 1;
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
            answer.append(poll).append(" ");
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream("./baekjoon/_2583_영역_구하기.txt");
        Scanner kb = new Scanner(fileInputStream);

        int m = kb.nextInt();
        int n = kb.nextInt();
        int[][] board = new int[m][n]; // 0초기화, 왼쪽아래ld가 (0,0), 오른쪽위ru가 (n,m)
        int k = kb.nextInt();
        for (int i = 0; i < k; i++) {
            int ldx = kb.nextInt();
            int ldy = kb.nextInt();
            int rux = kb.nextInt() - 1;
            int ruy = kb.nextInt() - 1;

            for (int y = ldy; y <= ruy; y++) {
                for (int x = ldx; x <= rux; x++) {
                    board[y][x] = 1;
                }
            }
        }

        solution(n, m, k, board);
    }
}
