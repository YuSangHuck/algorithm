//https://cote.inflearn.com/contest/10/problem/07-08
package huck.자바_알고리즘_문제풀이.dfs_bfs_uses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


//public class Main {
public class _0804_DFS_중복순열 {
    static int m, n;
    static int[] arr;

    private void DFS(int level) { // 0 level 탐색
        if (level == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[level] = i;
            DFS(level + 1);
        }
    }

    private void solution() {
        DFS(0);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0804_DFS_중복순열 T = new _0804_DFS_중복순열();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/dfs_bfs_uses/_0804_DFS_중복순열.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[m];
        T.solution();
    }

}
