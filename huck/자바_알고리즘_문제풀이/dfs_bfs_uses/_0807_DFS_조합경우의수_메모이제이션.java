//https://cote.inflearn.com/contest/10/problem/08-07
package huck.자바_알고리즘_문제풀이.dfs_bfs_uses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


//public class Main {
public class _0807_DFS_조합경우의수_메모이제이션 {
    static int r, n;
    static int[][] cache;

    private int DFS(int n, int r) {
        if (cache[n][r] != 0) {
            return cache[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        int v = DFS(n - 1, r - 1) + DFS(n - 1, r);
        cache[n][r] = v;
        cache[n][n - r] = v;
        return cache[n][r];
    }

    private int solution() {
        return DFS(n, r);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0807_DFS_조합경우의수_메모이제이션 T = new _0807_DFS_조합경우의수_메모이제이션();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/dfs_bfs_uses/_0807_DFS_조합경우의수_메모이제이션.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        r = kb.nextInt();
        cache = new int[n + 1][n + 1];
        System.out.println(T.solution());
    }

}
