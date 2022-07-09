//https://cote.inflearn.com/contest/10/problem/09-07
package huck.자바_알고리즘_문제풀이.greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//public class Main {
public class _0907_원더랜드_prim {

    private static boolean[] ch;
    private static final ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    static class Edge implements Comparable<Edge> {

        private final int v, cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "v=" + v +
                    ", cost=" + cost +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }

    private void soultion() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int answer = 0;
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (!ch[cur.v]) {
                ch[cur.v] = true;
                answer += cur.cost;
                for (Edge next : graph.get(cur.v)) {
                    if (!ch[next.v]) {
                        pq.offer(next);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _0907_원더랜드_prim T = new _0907_원더랜드_prim();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/greedy/_0907_원더랜드.txt");
        Scanner kb = new Scanner(fileInputStream);

        int v = kb.nextInt();
        int e = kb.nextInt();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new boolean[v + 1];
        for (int i = 0; i < e; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt(); // a,b가 c비용으로 연결
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        T.soultion();
    }
}
