//https://cote.inflearn.com/contest/10/problem/07-08
package huck.자바_알고리즘_문제풀이.recursive_tree_graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


//public class Main {
public class _0712_Graph_DFS_경로탐색 {
    static int n, m, answer;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public void DFS(int v) {
        if (v == n) {
            answer++;
            return;
        }

        for (Integer i : graph.get(v)) {
//            방문한적 없고, 간선연결
            if (ch[i] == 0) {
                ch[i] = 1;
                DFS(i);
                ch[i] = 0;
            }
        }

    }

    private void Solution() {
        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0712_Graph_DFS_경로탐색 T = new _0712_Graph_DFS_경로탐색();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/recursive_tree_graph/_0712_Graph_DFS_경로탐색.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);

        n = kb.nextInt(); // vertex n개
        m = kb.nextInt(); // edge m개
        graph = new ArrayList<>();
//        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());

        }
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        T.Solution();

    }

}
