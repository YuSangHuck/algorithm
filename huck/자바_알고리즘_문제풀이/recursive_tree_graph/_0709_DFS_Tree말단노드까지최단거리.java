//https://cote.inflearn.com/contest/10/problem/07-08
package huck.자바_알고리즘_문제풀이.recursive_tree_graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


//public class Main {
public class _0709_DFS_Tree말단노드까지최단거리 {
    class Node {
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }

        public boolean isLeaf() {
            return lt == null && rt == null;
        }
    }

    class Tree {
        Node root;

        public int DFS(int level, Node root) {
            if (root.isLeaf()) {
                return level;
            } else {
                return Math.min(DFS(level + 1, root.lt), // lt와 rt가 모두 존재한다고 가정
                        DFS(level + 1, root.rt));
            }
        }
    }

    private void Solution() {
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
//        tree.root.rt.lt = new Node(6);
//        tree.root.rt.rt = new Node(7);

        System.out.println(tree.DFS(0, tree.root));
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0709_DFS_Tree말단노드까지최단거리 T = new _0709_DFS_Tree말단노드까지최단거리();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/recursive_tree_graph/_0708_BFS_송아지찾기1.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);

        T.Solution();

    }

}
