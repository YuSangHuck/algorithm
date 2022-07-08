//https://cote.inflearn.com/contest/10/problem/08-14
package huck.자바_알고리즘_문제풀이.dfs_bfs_uses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//public class Main {
public class _0814_DFS_피자배달 {
    private static int size, n, r, answer = Integer.MAX_VALUE;
    private static int[] combination;
    private static final ArrayList<Point> hs = new ArrayList<>(), ps = new ArrayList<>();

    static class Point {
        private final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void DFS(int l, int s) {
        if (l == r) {
            int sum = 0;
            for (Point h : hs) {

                int tmp = Integer.MAX_VALUE;
                for (int i : combination) {
                    Point p = ps.get(i);
                    tmp = Math.min(tmp, Math.abs(h.x - p.x) + Math.abs(h.y - p.y));
                }
                sum += tmp;
            }
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = s; i < n; i++) {
            combination[l] = i;
            DFS(l + 1, i + 1);
        }
    }

    private void solution() {
        DFS(0, 0);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0814_DFS_피자배달 T = new _0814_DFS_피자배달();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/dfs_bfs_uses/_0814_DFS_피자배달.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        size = kb.nextInt(); // n by n
        r = kb.nextInt(); // m개의 피자집 살림, 살리는 기준은 도시의피자배달거리의 최소, 도시의피자배달거리는 각 집들의 피자배달거리의 합
        combination = new int[r];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                int status = kb.nextInt();
                if (status == 1) {
                    hs.add(new Point(x, y));
                } else if (status == 2) {
                    ps.add(new Point(x, y));
                }
            }
        }
        n = ps.size();
        T.solution();
        System.out.println(answer);
    }
}
