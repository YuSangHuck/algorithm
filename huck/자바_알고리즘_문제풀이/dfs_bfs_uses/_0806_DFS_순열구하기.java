//https://cote.inflearn.com/contest/10/problem/07-08
package huck.자바_알고리즘_문제풀이.dfs_bfs_uses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


//public class Main {
public class _0806_DFS_순열구하기 {
    static int m, n;
    static int[] arr, ch, pm;

    private void DFS(int depth) {
        if (depth == m) {
            for (int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                pm[depth] = arr[i];
                DFS(1 + depth);
                ch[i] = 0;
            }
        }
    }

    private void solution() {
        DFS(0);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0806_DFS_순열구하기 T = new _0806_DFS_순열구하기();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/dfs_bfs_uses/_0806_DFS_순열구하기.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[n]; // 오름차순 정렬
        ch = new int[n]; // 오름차순 정렬
        pm = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        T.solution();
    }

}
