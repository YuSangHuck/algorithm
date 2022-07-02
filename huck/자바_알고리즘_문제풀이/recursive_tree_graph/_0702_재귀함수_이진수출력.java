package huck.자바_알고리즘_문제풀이.recursive_tree_graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0702_재귀함수_이진수출력 {
    private void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n / 2);
            System.out.print(n % 2 + " "); // 1 1 1 0
        }
    }

    private int solution() {
        DFS(14);
        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0702_재귀함수_이진수출력 T = new _0702_재귀함수_이진수출력();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/recursive_tree_graph/_0702_재귀함수_이진수출력.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        T.solution();
    }
}
