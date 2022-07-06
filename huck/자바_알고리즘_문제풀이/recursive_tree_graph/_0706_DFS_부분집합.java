package huck.자바_알고리즘_문제풀이.recursive_tree_graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


//public class Main {
public class _0706_DFS_부분집합 {
    static int n;
    static int[] ch;

    private void DFS(int l) {
        if (l == n + 1) {
            StringBuilder s = new StringBuilder();
            for (int i = 1; i < ch.length; i++) {
                if (ch[i] == 1) {
                    s.append(i).append(" ");
                }
            }
            if (s.length() > 0) {
                System.out.println(s);
            }
            return;
        }

        ch[l] = 1;
        DFS(l + 1);
        ch[l] = 0;
        DFS(l + 1);
    }

    private void Solution(int n) {
        DFS(1);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0706_DFS_부분집합 T = new _0706_DFS_부분집합();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/recursive_tree_graph/_0704_재귀함수_피보나치.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);

        n = 3;
        ch = new int[n + 1];
        T.Solution(n);
    }

}
