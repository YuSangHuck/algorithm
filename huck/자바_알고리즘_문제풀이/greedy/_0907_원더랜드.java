//https://cote.inflearn.com/contest/10/problem/09-07
package huck.자바_알고리즘_문제풀이.greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//public class Main {
public class _0907_원더랜드 {

    private static int[] unf;
    private int answer = 0;

    static class Edge implements Comparable<Edge> {
        private final int v1, v2, cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", cost=" + cost +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost; // cost만 비교하면 됨
        }
    }


    private int find(int v) {
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }

    private void union(int v1, int v2) {
        int fv1 = find(v1);
        int fv2 = find(v2);
        if (fv1 != fv2) {
            unf[fv1] = fv2;
        }

    }

    private void soultion(int v, ArrayList<Edge> edges) {
        Collections.sort(edges);

        unf = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            unf[i] = i;
        }

        for (Edge edge : edges) {
            int a = find(edge.v1);
            int b = find(edge.v2);
            if (a != b) {
                union(edge.v1, edge.v2);
                answer += edge.cost;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _0907_원더랜드 T = new _0907_원더랜드();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/greedy/_0907_원더랜드.txt");
        Scanner kb = new Scanner(fileInputStream);

        int v = kb.nextInt();
        int e = kb.nextInt();
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt(); // a,b가 c비용으로 연결
            edges.add(new Edge(a, b, c));
        }
        T.soultion(v, edges);
    }
}
