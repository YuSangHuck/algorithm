package huck.자바_알고리즘_문제풀이.recursive_tree_graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0703_재귀함수_팩토리얼 {
    private int DFS(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * DFS(n - 1);
        }
    }

    private int solution(int i) {
        return DFS(i);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0703_재귀함수_팩토리얼 T = new _0703_재귀함수_팩토리얼();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/recursive_tree_graph/_0702_재귀함수_이진수출력.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        int i = kb.nextInt();
        System.out.println(T.solution(i));
    }
}
