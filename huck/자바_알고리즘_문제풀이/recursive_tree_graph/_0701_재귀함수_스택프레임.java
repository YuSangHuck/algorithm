package huck.자바_알고리즘_문제풀이.recursive_tree_graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0701_재귀함수_스택프레임 {
    private void DFS(int n) {
        if (n == 0) {
            return;
        } else {
//            System.out.print(n + " "); // 3 2 1
            DFS(n - 1);
            System.out.print(n + " "); // 1 2 3
        }
    }

    private int solution() {
        DFS(3);
        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0701_재귀함수_스택프레임 T = new _0701_재귀함수_스택프레임();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/recursive_tree_graph/_0701_재귀함수_스택프레임.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        T.solution();
    }
}
