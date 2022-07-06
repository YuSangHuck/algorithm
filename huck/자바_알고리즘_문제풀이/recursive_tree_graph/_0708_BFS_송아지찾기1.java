package huck.자바_알고리즘_문제풀이.recursive_tree_graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//public class Main {
public class _0708_BFS_송아지찾기1 {

    class Point {
        int pos, count;

        public Point(int pos, int count) {
            this.pos = pos;
            this.count = count;
        }
    }

    private void BFS(int pos, int e) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(pos, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point cur = q.poll();
                if (cur.pos == e) {
                    System.out.println(cur.count);
                    return;
                } else {
                    q.offer(new Point(cur.pos + 1, cur.count + 1));
                    q.offer(new Point(cur.pos - 1, cur.count + 1));
                    q.offer(new Point(cur.pos + 5, cur.count + 1));
                }
            }
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
