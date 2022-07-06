//https://cote.inflearn.com/contest/10/problem/07-08
package huck.자바_알고리즘_문제풀이.recursive_tree_graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//public class Main {
public class _0714_Graph_BFS_최단거리 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;


    public void BFS(int vertex) {
        Queue<Integer> q = new LinkedList<>();
        ch[vertex] = 1;
        dis[vertex] = 0;
        q.offer(vertex);
        while (!q.isEmpty()) {
            int cv = q.poll();
            for (int nv : graph.get(cv)) {
                if (ch[nv] == 0) {
//                cv -> nv로 이동
                    ch[nv] = 1;
                    dis[nv] = 1 + dis[cv];
                    q.offer(nv);
                }
            }
        }

    }

    private void solution() {
        BFS(1);
        for (int i = 2; i < n + 1; i++) {
            System.out.println(i + " = " + dis[i]);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0714_Graph_BFS_최단거리 T = new _0714_Graph_BFS_최단거리();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/recursive_tree_graph/_0714_Graph_BFS_최단거리.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);

        n = kb.nextInt(); // vertex n개
        m = kb.nextInt(); // edge m개

        graph = new ArrayList<>();
        ch = new int[n + 1];
        dis = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }

        T.solution();
    }

}
