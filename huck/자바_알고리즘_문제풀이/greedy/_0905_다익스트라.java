//https://cote.inflearn.com/contest/10/problem/09-05
package huck.자바_알고리즘_문제풀이.greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//public class Main {
public class _0905_다익스트라 {
    private final static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    private static int[] dis;

    static class Edge implements Comparable<Edge> {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "v=" + v +
                    ", w=" + w +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return w - o.w;
        }
    }

    private void solution(int startV) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(); // Edge 저장, w기준 오름차순
        pq.offer(new Edge(startV, 0));
        dis[startV] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int cv = cur.v;
            int cw = cur.w;
            if (cw > dis[cv]) { // cw가 dis[cv]보다 작으면 업데이트 과정을 볼 필요가 없음
                continue;
            }
            for (Edge next : graph.get(cv)) {
                int nv = next.v;
                int nw = cw + next.w;
                if (dis[nv] > nw) {
                    dis[nv] = nw;
                    pq.offer(new Edge(nv, nw));
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _0905_다익스트라 T = new _0905_다익스트라();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/greedy/_0905_다익스트라.txt");
        Scanner kb = new Scanner(fileInputStream);


        int n = kb.nextInt();
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int m = kb.nextInt();
        for (int i = 0; i < m; i++) {
            int v1 = kb.nextInt();
            int v2 = kb.nextInt();
            int w = kb.nextInt();
            graph.get(v1).add(new Edge(v2, w));
        }
        T.solution(1);


        for (int i = 0; i < n + 1; i++) {
            System.out.println(i + " : " + (dis[i] == Integer.MAX_VALUE ? "Impossible" : String.valueOf(dis[i])));
        }
    }
}
