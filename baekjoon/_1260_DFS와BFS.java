package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//public class Main {
public class _1260_DFS와BFS {

    private static final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static final StringBuilder sb4bfs = new StringBuilder();
    private static final StringBuilder sb4dfs = new StringBuilder();
    private static boolean[] ch;
    private static int n;

    private static void dfs(int d, int v) {
        ArrayList<Integer> nexts = graph.get(v);
        for (Integer next : nexts) {
            if (!ch[next]) {
                ch[next] = true;
                sb4dfs.append(next).append(' ');
                dfs(d + 1, next);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(v);
        ch[v] = true;
        sb4bfs.append(v).append(' ');

        while (!q.isEmpty()) {
            int c = q.poll();
            for (Integer integer : graph.get(c)) {
                if (!ch[integer]) {
                    q.offer(integer);
                    ch[integer] = true;
                    sb4bfs.append(integer).append(' ');
                }
            }
        }
    }

    private static void solution(int n, int m, int v, int[][] arr) {
//        단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] ints : arr) {
            int v1 = ints[0];
            int v2 = ints[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        for (ArrayList<Integer> arrayList : graph) {
            Collections.sort(arrayList);
        }

        ch[v] = true;
        sb4dfs.append(v).append(' ');
        dfs(1, v);
        System.out.println(sb4dfs);

        Arrays.fill(ch, false);
        bfs(v);
        System.out.println(sb4bfs);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner kb = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream("./baekjoon/_1260_DFS와BFS.txt");
        Scanner kb = new Scanner(fileInputStream);

        n = kb.nextInt();
        ch = new boolean[n + 1];
        int m = kb.nextInt();
        int v = kb.nextInt();
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr[i][0] = kb.nextInt();
            arr[i][1] = kb.nextInt();
        }
        solution(n, m, v, arr);

    }
}
