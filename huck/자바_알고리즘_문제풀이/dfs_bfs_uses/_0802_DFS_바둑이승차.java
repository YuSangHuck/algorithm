//https://cote.inflearn.com/contest/10/problem/07-08
package huck.자바_알고리즘_문제풀이.dfs_bfs_uses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


//public class Main {
public class _0802_DFS_바둑이승차 {
    static int c, n, answer = Integer.MIN_VALUE;
    static int[] arr;

    private void DFS(int level, int sum) { // 0 level 탐색, 이전까지의 합은 sum
        if (sum > c) {
            return;
        }
        if (level == n) {
            answer = Math.max(answer, sum);
            return;
        }
            DFS(level + 1, sum); // arr[level] 태움}
            DFS(level + 1, sum + arr[level]); // arr[level] 안태움
        }

    private void solution() {
//        loop(arr의 공집합 제외 모든 부분집합들) // 부분집합은 dfs로 해야만하나?
//            if sum(부분집합) == (target = total/2)
        DFS(0, 0);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0802_DFS_바둑이승차 T = new _0802_DFS_바둑이승차();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/dfs_bfs_uses/_0802_DFS_바둑이승차.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        c = kb.nextInt();
        n = kb.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        T.solution();
        System.out.println(answer);
    }

}
