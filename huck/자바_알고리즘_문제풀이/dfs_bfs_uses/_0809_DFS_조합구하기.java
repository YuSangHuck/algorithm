//https://cote.inflearn.com/contest/10/problem/07-08
package huck.자바_알고리즘_문제풀이.dfs_bfs_uses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


//public class Main {
public class _0809_DFS_조합구하기 {
    static int n, m;
    static int[] combi;

    private void DFS(int depth, int startIdx) {
        if (depth == m) {
            for (int i : combi) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = startIdx; i < n; i++) {
            combi[depth] = 1 + i;
            DFS(1 + depth, 1 + i);
        }
    }

    private void solution() {

        DFS(0, 0);


    }

    public static void main(String[] args) throws FileNotFoundException {
        _0809_DFS_조합구하기 T = new _0809_DFS_조합구하기();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/dfs_bfs_uses/_0809_DFS_조합구하기.txt");
        Scanner kb = new Scanner(fileInputStream);

        n = kb.nextInt();
        m = kb.nextInt();
        combi = new int[m];

        T.solution();
    }
}
