//https://cote.inflearn.com/contest/10/problem/08-08
package huck.자바_알고리즘_문제풀이.dfs_bfs_uses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


//public class Main {
public class _0808_DFS_수열추측하기 {
    static int f, n;
    static int[][] cache;
    static int[] b, p, ch;
    private boolean flag = false;

    private int combi(int n, int r) {
        if (cache[n][r] != 0) {
            return cache[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        int v = combi(n - 1, r - 1) + combi(n - 1, r);
        cache[n][r] = v;
        cache[n][n - r] = v;
        return cache[n][r];
    }

    private void DFS(int depth, int sum) {
        if (flag) {
            return;
        }
        if (depth == n) {
            if (sum == f) {
                for (int i : p) {
                    System.out.print(i + " ");
                }
                System.out.println();
                flag = true;
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                p[depth] = 1 + i;
                DFS(1 + depth, sum + b[depth] * p[depth]);
                ch[i] = 0;
            }
        }
    }

    private void solution() {
        for (int i = 0; i < n; i++) {
            b[i] = combi(n - 1, i);
        }
        DFS(0, 0);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0808_DFS_수열추측하기 T = new _0808_DFS_수열추측하기();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/dfs_bfs_uses/_0808_DFS_수열추측하기.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        cache = new int[n + 1][n + 1];
        b = new int[n]; // 이항계수
        p = new int[n]; // 순열
        ch = new int[n]; //

        T.solution();
    }

}
