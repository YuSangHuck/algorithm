//https://cote.inflearn.com/contest/10/problem/09-06
package huck.자바_알고리즘_문제풀이.greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//public class Main {
public class _0906_친구인가 {
    private int[] unf;

    private int find(int n) {
        if (unf[n] == n) {
            return n;
        } else {
            return unf[n] = find(unf[n]);
        }
    }

    private void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    private void soultion(int n, int m, int[][] arr, int[][] check) {
        unf = new int[n + 1];
        for (int i = 0; i < n; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < m; i++) {
            union(arr[i][0], arr[i][1]);
        }

        int a = check[0][0];
        int b = check[0][0];

        if (find(a) != find(b)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _0906_친구인가 T = new _0906_친구인가();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/greedy/_0906_친구인가.txt");
        Scanner kb = new Scanner(fileInputStream);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr[i][0] = kb.nextInt();
            arr[i][1] = kb.nextInt();
        }
        int[][] check = new int[1][2];
        check[0][0] = kb.nextInt();
        check[0][1] = kb.nextInt();

        T.soultion(n, m, arr, check);
    }
}
