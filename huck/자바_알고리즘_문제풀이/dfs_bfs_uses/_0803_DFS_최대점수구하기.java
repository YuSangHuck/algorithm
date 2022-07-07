//https://cote.inflearn.com/contest/10/problem/07-08
package huck.자바_알고리즘_문제풀이.dfs_bfs_uses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


//public class Main {
public class _0803_DFS_최대점수구하기 {
    static int m, n, answer = Integer.MIN_VALUE;
    static int[][] arr;

    private void DFS(int level, int sumTime, int sumScore) { // 0 level 탐색, 이전까지의 합은 sum
        if (sumTime > m) {
            return;
        }
        if (level == n) {
            answer = Math.max(answer, sumScore);
            return;
        }
        DFS(level + 1, sumTime, sumScore); // arr[level] 태움}
        DFS(level + 1, sumTime + arr[level][1], sumScore + arr[level][0]); // arr[level] 안태움
    }

    private void solution() {
//        loop(arr의 공집합 제외 모든 부분집합들) // 부분집합은 dfs로 해야만하나?
//            if sum(부분집합) == (target = total/2)
        DFS(0, 0, 0);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0803_DFS_최대점수구하기 T = new _0803_DFS_최대점수구하기();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/dfs_bfs_uses/_0803_DFS_최대점수구하기.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); // 문제
        m = kb.nextInt(); // 시간제한
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = kb.nextInt();
            arr[i][1] = kb.nextInt();
        }
        T.solution();
        System.out.println(answer);
    }

}
