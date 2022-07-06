package huck.자바_알고리즘_문제풀이.recursive_tree_graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//public class Main {
public class _0705_DFS_이진트리순회 {
    static String PRE_ORDER = "preorder";
    static String IN_ORDER = "inorder";
    static String POST_ORDER = "postorder";
    static String LEVEL_ORDER = "levelorder";

    class Node {
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }
    }

    //          1
//    2           3
//  4    5     6     7
// 8 9 10 11 12 13 14 15
    class Tree {
        String direction;
        Node root;

        public void DFS(Node root) {
            if (root == null) {
                return;
            }
            if (direction.equals(PRE_ORDER)) {
                System.out.print(root.data + " "); // 전위, 부-왼-오
            }
            DFS(root.lt);
            if (direction.equals(IN_ORDER)) { // 중위, 왼-부-오
                System.out.print(root.data + " ");
            }
            DFS(root.rt);
            if (direction.equals(POST_ORDER)) { // 후위, 왼-오-부
                System.out.print(root.data + " ");
            }
        }

        public void BFS(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            int L = 0;
            while (!q.isEmpty()) {
                System.out.print(L++ + ": ");
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Node cur = q.poll();
                    System.out.print(cur.data + " ");
                    if (cur.lt != null) {
                        q.offer(cur.lt);
                    }
                    if (cur.rt != null) {
                        q.offer(cur.rt);
                    }
                }
                System.out.println();
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
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.root.lt.lt.lt = new Node(8);
        tree.root.lt.lt.rt = new Node(9);
        tree.root.lt.rt.lt = new Node(10);
        tree.root.lt.rt.rt = new Node(11);
        tree.root.rt.lt.lt = new Node(12);
        tree.root.rt.lt.rt = new Node(13);
        tree.root.rt.rt.lt = new Node(14);
        tree.root.rt.rt.rt = new Node(15);
        tree.direction = LEVEL_ORDER;

        if (!tree.direction.equals(LEVEL_ORDER)) {
            tree.DFS(tree.root);
        } else {
            tree.BFS(tree.root);
        }

        System.out.println();
        if (tree.direction.equals(PRE_ORDER)) {
            System.out.println("1 2 4 8 9 5 10 11 3 6 12 13 7 14 15");
        } else if (tree.direction.equals(IN_ORDER)) {
            System.out.println("8 4 9 2 10 5 11 1 12 6 13 3 14 7 15");
        } else if (tree.direction.equals(POST_ORDER)) {
            System.out.println("8 9 4 10 11 5 2 12 13 6 14 15 7 3 1");
        } else if (tree.direction.equals(LEVEL_ORDER)) {
            System.out.println("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0705_DFS_이진트리순회 T = new _0705_DFS_이진트리순회();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/recursive_tree_graph/_0704_재귀함수_피보나치.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);

        T.Solution();
    }

}
