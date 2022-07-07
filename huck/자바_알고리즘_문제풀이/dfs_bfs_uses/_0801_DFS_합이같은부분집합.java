//https://cote.inflearn.com/contest/10/problem/07-08
package huck.자바_알고리즘_문제풀이.dfs_bfs_uses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


//public class Main {
public class _0801_DFS_합이같은부분집합 {
    static int target = 0;
    static int n = 0;
    static int[] arr;
    static boolean flag = false;
    static String answer = "NO";

    private void DFS(int level, int sum) {
        if (flag || sum > target) {
            return;
        }
        if (level == n) {
            if (sum == target) {
                answer = "YES";
                flag = true;
            }
            return;
        }

        DFS(level + 1, sum+arr[level]);
        DFS(level + 1, sum);
    }

    private void solution() {
//        loop(arr의 공집합 제외 모든 부분집합들) // 부분집합은 dfs로 해야만하나?
//            if sum(부분집합) == (target = total/2)
        DFS(0, 0);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0801_DFS_합이같은부분집합 T = new _0801_DFS_합이같은부분집합();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/dfs_bfs_uses/_0801_DFS_합이같은부분집합.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
            target += arr[i];
        }
        if (target % 2 == 0) {
            target /= 2;
            T.solution();
        }
        System.out.println(answer);
    }

}
