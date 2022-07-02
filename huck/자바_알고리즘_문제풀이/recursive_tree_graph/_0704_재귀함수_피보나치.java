package huck.자바_알고리즘_문제풀이.recursive_tree_graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0704_재귀함수_피보나치 {
    static int[] memoization;

    private int DFS(int n) {
        if (memoization[n] > 0) {
            return memoization[n];
        }
        if (n == 1 || n == 2) {
            return memoization[n] = 1;
        } else {
            return memoization[n] = DFS(n - 1) + DFS(n - 2);
        }
    }

    private int solution(int i) {
        return DFS(i);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0704_재귀함수_피보나치 T = new _0704_재귀함수_피보나치();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/recursive_tree_graph/_0704_재귀함수_피보나치.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        memoization = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            System.out.println("i = " + i + ", v = " + T.solution(i));
        }
    }
}
