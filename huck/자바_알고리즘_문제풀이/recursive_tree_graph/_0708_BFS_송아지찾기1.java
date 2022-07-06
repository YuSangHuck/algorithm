//https://cote.inflearn.com/contest/10/problem/07-08
package huck.자바_알고리즘_문제풀이.recursive_tree_graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//public class Main {
public class _0708_BFS_송아지찾기1 {
    static int[] ch = new int[10001];
    static int[] dx = {1, -1, 5};

    private void BFS(int pos, int e) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(pos);
        ch[pos] = 1;
        int L = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                for (int d : dx) {
                    int nx = cur + d;
                    if (nx == e) {
                        System.out.println(L + 1);
                        return;
                    }
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            L++;
        }
    }

    private void Solution(int s, int e) {
        BFS(s, e);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0708_BFS_송아지찾기1 T = new _0708_BFS_송아지찾기1();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/recursive_tree_graph/_0708_BFS_송아지찾기1.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);

        int s = kb.nextInt();
        int e = kb.nextInt();
        T.Solution(s, e);
    }

}
