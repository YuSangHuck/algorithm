//https://cote.inflearn.com/contest/10/problem/07-08
package huck.자바_알고리즘_문제풀이.dfs_bfs_uses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


//public class Main {
public class _0805_DFS_동전교환 {
    static int m, n, answer = Integer.MAX_VALUE;
    static Integer[] arr;

    private void DFS(int depth, int sum) {
        if (depth >= answer) {
            return;
        }
        if (sum > m) {
            return;
        }
        if (sum == m) {
//            System.out.println("coins = " + coins);
            answer = Math.min(depth, answer);
            return;
        }
        for (int coin : arr) {
            DFS(1 + depth, sum + coin);
        }
    }

    private void solution() {
        DFS(0, 0);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0805_DFS_동전교환 T = new _0805_DFS_동전교환();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/dfs_bfs_uses/_0805_DFS_동전교환.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        arr = new Integer[n];
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = kb.nextInt();
        T.solution();
        System.out.println(answer);
    }

}
